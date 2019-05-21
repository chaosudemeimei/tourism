package com.juzheng.smart.tourism;
 
import com.juzheng.smart.tourism.recommend.RecommendResult;
import com.mysql.cj.jdbc.MysqlDataSource;
import jdk.nashorn.internal.scripts.JD;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.GenericDataModel;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
 
 
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.recommender.*;
import org.apache.mahout.clustering.Model;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Main
{
    final static int NEIGHBORHOOD_NUM = 2;   //用户邻居数量
    final static int RECOMMENDER_NUM = 3;    //推荐结果个数
 
    public static void main(String[] args) throws IOException,TasteException
    {
	// write your code here
       // String projectPath = System.getProperty("user.dir");
       // String file = (projectPath + "/src/main/resources/recommend.csv");   //数据集，其中第一列表示用户id；第二列表示商品id；第三列表示评分，评分是5分制
       // DataModel model = new FileDataModel(new File(file));  //基于文件的model，通过文件形式来读入,且此类型所需要读入的数据的格式要求很低，只需要满足每一行是用户id，物品id，用户偏好，且之间用tab或者是逗号隔开即可

        MysqlDataSource dataSource=new MysqlDataSource();
        dataSource.setServerName("101.132.139.188");
        dataSource.setUser("root");
        dataSource.setPassword("9609");
        dataSource.setDatabaseName("smart_tourism_platform");
        JDBCDataModel dataModel=new MySQLJDBCDataModel(dataSource,"city_play_comment","user_id","play_id","score", "creatime");
        DataModel model=dataModel;

        //基于用户的协同过滤算法，基于物品的协同过滤算法
        UserSimilarity user = new EuclideanDistanceSimilarity(model);  //计算欧式距离，欧式距离来定义相似性，用s=1/(1+d)来表示，范围在[0,1]之间，值越大，表明d越小，距离越近，则表示相似性越大
        NearestNUserNeighborhood  neighbor = new NearestNUserNeighborhood(NEIGHBORHOOD_NUM, user, model);
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

        List<RecommendedItem> recommendations = r.recommend(1, 5);
        //System.out.println(recommendations);
 
    }
}

