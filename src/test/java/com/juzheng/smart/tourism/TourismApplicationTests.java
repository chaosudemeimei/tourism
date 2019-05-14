package com.juzheng.smart.tourism;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.juzheng.smart.tourism.entity.UserInfo;
import com.juzheng.smart.tourism.mapper.UserInfoMapper;
import com.juzheng.smart.tourism.service.IUserInfoService;
import com.juzheng.smart.tourism.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TourismApplicationTests {


    @Autowired
    public IUserInfoService infoService;

    @Test
    public void contextLoads() {
        /*测试分页插件的代码*/
       Page<UserInfo>userInfoPage=new Page<>();
       //每页数量
        userInfoPage.setSize(3);
        //当前页数
        userInfoPage.setCurrent(2);
        System.out.println(infoService.page(userInfoPage).getRecords().toString());

    }


    //测试城市的实时天气预报
    @Test
    public void weather2() {
        String host = "http://saweather.market.alicloudapi.com";
        String path = "/hour24";
        String method = "GET";
        String appcode = "26d5b6355f7f458ba426740c92d1be08";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("area", "丽江");
        //querys.put("areaid", "101230506");


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            System.out.println(response.toString());
            //获取response的body
            String s=EntityUtils.toString(response.getEntity());
            Map map= (Map) JSONArray.parse(s);
            System.out.println(map.get("showapi_res_body"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }







}
