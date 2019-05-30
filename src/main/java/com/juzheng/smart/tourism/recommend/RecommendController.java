package com.juzheng.smart.tourism.recommend;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.juzheng.smart.tourism.entity.*;
import com.juzheng.smart.tourism.jwt.JwtHelper;
import com.juzheng.smart.tourism.mapper.CityPlayCommentMapper;
import com.juzheng.smart.tourism.result.BaseResult;
import com.juzheng.smart.tourism.service.ICityPlayCommentService;
import com.juzheng.smart.tourism.service.ICityPlayRecommendService;
import com.juzheng.smart.tourism.service.ICityPlayService;
import com.juzheng.smart.tourism.service.IUserPlayService;
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
import java.util.*;

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

    @Autowired
    public ICityPlayRecommendService cityPlayRecommendService;

    @Autowired
    public IUserPlayService userPlayService;

    @ApiOperation(value="采用Mahout实现基于用户的协同过滤算法", notes=" 对评分数据进行收集，从文件中读取")
    @RequestMapping(value = "/api/recommend/token/list", method = RequestMethod.GET)
    public List getUserData() throws IOException,TasteException{
      ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
      HttpServletRequest request= servletRequestAttributes.getRequest();
      String jwttoken=request.getHeader("token");
      Claims claims=JwtHelper.verifyJwt(jwttoken);
      String userid = String.valueOf(claims.get("userid"));

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
           // System.out.printf("uid:%s",uid);
            //遍历推荐结果
            for(RecommendedItem ritem : list)
            {
                System.out.printf("(%s,%f)",ritem.getItemID(),ritem.getValue());
              //  System.out.println(ritem);
            }
         //   System.out.println();
        }


      List<RecommendedItem> recommendations = r.recommend(Long.valueOf(userid), RECOMMENDER_NUM);
      List<CityPlayRecommend>cityPlayRecommends=new ArrayList<>();
      for(int i=0;i<recommendations.size();i++){
          QueryWrapper<CityPlayRecommend>queryWrapper=new QueryWrapper<>();
          queryWrapper.lambda().eq(CityPlayRecommend::getPlayId,recommendations.get(i).getItemID());
          List<CityPlayRecommend> cityPlayRecommends1=cityPlayRecommendService.list(queryWrapper);

          Random random=new Random();
          int rand=random.nextInt(cityPlayRecommends1.size());
          CityPlayRecommend cityPlayRecommend=cityPlayRecommends1.get(rand);
          cityPlayRecommends.add(cityPlayRecommend);
        }
        return cityPlayRecommends;
    }

    @ApiOperation(value="纯手动实现基于用户的协同过滤算法", notes=" 对意愿数据进行收集")
    @RequestMapping(value = "/api/recommend/token/list2", method = RequestMethod.GET)
    public List getUserData2() throws IOException,TasteException{
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request= servletRequestAttributes.getRequest();
        String jwttoken=request.getHeader("token");
        Claims claims=JwtHelper.verifyJwt(jwttoken);
        String userid = String.valueOf(claims.get("userid"));

        QueryWrapper<UserPlay>userPlayQueryWrapper1=new QueryWrapper();
        userPlayQueryWrapper1.lambda().eq(UserPlay::getUserId,userid);
        List<UserPlay>userPlays1=userPlayService.list(userPlayQueryWrapper1);

        ArrayList<String>playids=new ArrayList<>();
        for(UserPlay userPlayex:userPlays1){
            if(playids.contains(userPlayex.getPlayId())==false){
                playids.add(userPlayex.getPlayId());
            }
        }

        QueryWrapper<UserPlay>userPlayQueryWrapper2=new QueryWrapper();
        userPlayQueryWrapper2.lambda().notIn(UserPlay::getUserId,userid);
        List<UserPlay>userPlays2=userPlayService.list(userPlayQueryWrapper2);

        ArrayList<String>userids=new ArrayList<>();
        for(UserPlay userplay :userPlays2){
            if(userids.contains(userplay.getUserId())==false){
                userids.add(userplay.getUserId());
            }
        }

        ArrayList<List<UserPlay>>userPlays=new ArrayList<>();
        for(String userid1:userids){
            QueryWrapper<UserPlay>userPlayQueryWrapper3=new QueryWrapper();
            userPlayQueryWrapper3.lambda().eq(UserPlay::getUserId,userid1);
            List<UserPlay>userPlays3=userPlayService.list(userPlayQueryWrapper3);

            ArrayList<String>playids2=new ArrayList<>();
            playids2=playids;
            for(int i=0;i<playids.size();i++){
                for(int j=0;j<userPlays3.size();j++){
                    if(playids.get(i).equals(userPlays3.get(j).getPlayId())){
                        playids2.remove(i);
                    }
                }
            }
            for(String playidaa:playids2){
                UserPlay userPlay=new UserPlay();
                userPlay.setPlayId(playidaa);
                userPlay.setUserId(userid1);
                userPlay.setGo(-1);
                userPlays3.add(userPlay);
            }
            userPlays.add(userPlays3);
        }
        //System.out.println(userPlays.toString());
        Map<String,Double>map=new HashMap<>();
        for(int i=0;i<userPlays.size();i++){
            double sum=0.00;
            List<UserPlay>userPlayList=userPlays.get(i);
            int dataLength=userPlayList.size();
            for(int j=0;j<dataLength;j++){
                for(int m=0;m<dataLength;m++){
                    if(userPlays1.get(j).getPlayId().equals(userPlayList.get(m).getPlayId())){
                            double data=Math.pow((userPlays1.get(j).getGo()-userPlayList.get(m).getGo()),2);
                            sum+=data;
                    }
                }
            }
            double sum_sqrt=Math.sqrt(sum);
            double value=1/(1+sum_sqrt);
            map.put(userPlayList.get(0).getUserId(),value);
        }

        String maxKey="";
        double maxValue=0.00;
        for (String key : map.keySet()) {
           if(map.get(key)>maxValue){
               maxValue=map.get(key);
               maxKey=key;
           }
        }
       // System.out.println(maxValue+"  "+maxKey);

        QueryWrapper<UserPlay>queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(UserPlay::getUserId,maxKey)
                            .eq(UserPlay::getGo,2);
        List<UserPlay>userPlay4=userPlayService.list(queryWrapper);
        ArrayList<String>resultPlayIds=new ArrayList<>();
        for(UserPlay userPlay:userPlay4){
            resultPlayIds.add(userPlay.getPlayId());
        }
        Random random=new Random();
        int rand=random.nextInt(resultPlayIds.size());
        String resultid=resultPlayIds.get(rand);

        QueryWrapper<CityPlayRecommend>queryWrapper2=new QueryWrapper<>();
        queryWrapper2.lambda().eq(CityPlayRecommend::getPlayId,resultid);
        List<CityPlayRecommend> cityPlayRecommends=cityPlayRecommendService.list(queryWrapper2);

        System.out.println(cityPlayRecommends);
        return cityPlayRecommends;
    }



    @ApiOperation(value="(数据库)返回给用户推荐的playid以及相关的信息", notes="基于用户相似度的协同过滤的推荐")
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
