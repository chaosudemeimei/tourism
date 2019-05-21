package com.juzheng.smart.tourism.recommend;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.juzheng.smart.tourism.entity.City;
import com.juzheng.smart.tourism.entity.CityPlay;
import com.juzheng.smart.tourism.entity.CityPlayComment;
import com.juzheng.smart.tourism.jwt.JwtHelper;
import com.juzheng.smart.tourism.mapper.CityPlayCommentMapper;
import com.juzheng.smart.tourism.service.ICityPlayCommentService;
import com.juzheng.smart.tourism.service.ICityPlayService;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.mysql.cj.jdbc.MysqlDataSource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.juzheng.smart.tourism.recommend.RecommendUtils.FILEPATH;
import static com.juzheng.smart.tourism.recommend.RecommendUtils.NEIGHBORHOOD_NUM;
import static com.juzheng.smart.tourism.recommend.RecommendUtils.RECOMMENDER_NUM;

/**
 * @author juzheng
 * @Title: RecommendController
 * @date 2019/5/21 1:56 AM
 * @Description:  推荐算法模块，基于用户的协同过滤算法
 */
@RestController
@RequestMapping("/recommend")
public class RecommendController {


    @Autowired
    public CityPlayCommentMapper cityPlayCommentMapper;

    @Autowired
    public ICityPlayCommentService cityPlayCommentService;

    @Autowired
    public ICityPlayService cityPlayService;

    @ApiOperation(value="返回推荐算法要的格式", notes="")
    @RequestMapping(value = "/api/recommend/token/list", method = RequestMethod.GET)
    public List getUserData() throws IOException,TasteException{
      //先整理数据集，用户的city_play_comment,
      //若对一个play有多个comment则算平均分
      ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
      HttpServletRequest request= servletRequestAttributes.getRequest();
      String jwttoken=request.getHeader("token");
      Claims claims=JwtHelper.verifyJwt(jwttoken);
      String userid = String.valueOf(claims.get("userid"));

//      QueryWrapper<CityPlayComment>queryWrapper=new QueryWrapper<>();
//     // queryWrapper.lambda().eq(CityPlayComment::getUserId,userid);
//      List<CityPlayComment>playCommentList=cityPlayCommentMapper.selectList(queryWrapper);
//
//      List<RecommendResult>resultList=new ArrayList<>();
//      for (int i=0;i<playCommentList.size();i++){
//          RecommendResult recommendResult=new RecommendResult();
//          recommendResult.setPlayId(playCommentList.get(i).getPlayId());
//          recommendResult.setScore(String.valueOf(playCommentList.get(i).getScore()));
//          recommendResult.setUserId(playCommentList.get(i).getUserId());
//          resultList.add(recommendResult);
//      }
//      for(int i=0;i<resultList.size();i++){
//          for(int j=i+1;j<resultList.size();j++) {
//            if(resultList.get(i).getPlayId().equals(resultList.get(j).getPlayId())){
//              String score1=resultList.get(i).getScore();
//              String score2=resultList.get(j).getScore();
//              String score3=String.valueOf((Double.valueOf(score1)+Double.valueOf(score2))/2);
//              RecommendResult recommendResult=resultList.get(i);
//              recommendResult.setScore(score3);
//              resultList.remove(j);
//            }
//          }
//      }
        //List<String> eventsList = new ArrayList<>();
      List<CityPlayComment>cityPlayComments=cityPlayCommentService.list();
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter( new File(FILEPATH)));
            for ( CityPlayComment comment : cityPlayComments) {
                br.write(comment.getUserId()+","+comment.getPlayId()+","+comment.getScore()+"\r");
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        DataModel model = new FileDataModel(new File(FILEPATH));
        //基于用户的协同过滤算法
        UserSimilarity user = new EuclideanDistanceSimilarity(model);  //计算欧式距离，欧式距离来定义相似性，用s=1/(1+d)来表示，范围在[0,1]之间，值越大，表明d越小，距离越近，则表示相似性越大
        NearestNUserNeighborhood neighbor = new NearestNUserNeighborhood(NEIGHBORHOOD_NUM, user, model);
        //指定用户邻居数量

        //构建基于用户的推荐系统
        Recommender r = new GenericUserBasedRecommender(model, neighbor, user);


        //得到所有用户的id集合
        LongPrimitiveIterator iter = model.getUserIDs();

        while(iter.hasNext())
        {
            long uid = iter.nextLong();
            List<RecommendedItem> list = r.recommend(uid,RECOMMENDER_NUM);  //获取推荐结果
         //   System.out.printf("uid:%s",uid);
            //遍历推荐结果
            for(RecommendedItem ritem : list)
            {
                //System.out.printf("(%s,%f)",ritem.getItemID(),ritem.getValue());
           //     System.out.println(ritem);
            }
          //  System.out.println();
        }

        List<RecommendedItem> recommendations = r.recommend(Long.valueOf(userid), RECOMMENDER_NUM);
        List<String>playids=new ArrayList<>();
        for(RecommendedItem recommendedItem:recommendations){
            playids.add(String.valueOf(recommendedItem.getItemID()));
        }
       List<CityPlay>cityPlays=new ArrayList<>();
        for(int i=0;i<playids.size();i++){
           // System.out.println(playids.get(i));
            QueryWrapper<CityPlay>queryWrapper=new QueryWrapper<>();
            queryWrapper.lambda().eq(CityPlay::getPlayId,playids.get(i));
            CityPlay cityPlay=cityPlayService.getOne(queryWrapper);
            cityPlays.add(cityPlay);
          //  System.out.println(cityPlay);
        }
        return cityPlays;
    }


    @ApiOperation(value="返回给用户推荐的playid以及相关的信息", notes="基于用户相似度的协同过滤的推荐")
    @RequestMapping(value = "/api/recommend/token/recommend", method = RequestMethod.GET)
    public List getRecommendPlayId()throws IOException,TasteException{
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request= servletRequestAttributes.getRequest();
        String jwttoken=request.getHeader("token");
        Claims claims=JwtHelper.verifyJwt(jwttoken);
        String userid = String.valueOf(claims.get("userid"));


        MysqlDataSource dataSource=new MysqlDataSource();
        dataSource.setServerName("101.132.139.188");
        dataSource.setUser("root");
        dataSource.setPassword("9609");
        dataSource.setDatabaseName("smart_tourism_platform");
        JDBCDataModel dataModel=new MySQLJDBCDataModel(dataSource,"city_play_comment","user_id","play_id","score", "creatime");
        DataModel model=dataModel;

        //基于用户的协同过滤算法
        UserSimilarity user = new EuclideanDistanceSimilarity(model);  //计算欧式距离，欧式距离来定义相似性，用s=1/(1+d)来表示，范围在[0,1]之间，值越大，表明d越小，距离越近，则表示相似性越大
        NearestNUserNeighborhood neighbor = new NearestNUserNeighborhood(NEIGHBORHOOD_NUM, user, model);
        //指定用户邻居数量

        //构建基于用户的推荐系统
        Recommender r = new GenericUserBasedRecommender(model, neighbor, user);


        //得到所有用户的id集合
        LongPrimitiveIterator iter = model.getUserIDs();

       while(iter.hasNext())
            {
               long uid = iter.nextLong();
                List<RecommendedItem> list = r.recommend(uid,RECOMMENDER_NUM);  //获取推荐结果
                System.out.printf("uid:%s",uid);
                //遍历推荐结果
                for(RecommendedItem ritem : list)
                {
                    //System.out.printf("(%s,%f)",ritem.getItemID(),ritem.getValue());
                    System.out.println(ritem);
                }
                System.out.println();
            }

        List<RecommendedItem> recommendations = r.recommend(Long.valueOf(userid), RECOMMENDER_NUM);
        //System.out.println(userid);
       // System.out.println(recommendations);
        return recommendations;

    }
}
