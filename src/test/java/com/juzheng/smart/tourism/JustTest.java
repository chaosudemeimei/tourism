package com.juzheng.smart.tourism;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @author juzheng
 * @Title: JustTest
 * @date 2019/5/14 10:57 PM
 * @Description:
 */
public class JustTest {
    //测试前端数组格式化
    @Test
    public void array(){
        String array="{\"val\":[\"1\",\"4\",\"7\",\"29\"]}";
        //  System.out.println(JSONArray.parse(array));
        JSONObject j1 = JSONObject.parseObject(array);
        String value = j1.getString("val");
        value=value.replace("[","")
                    .replace(",","")
                    .replace("]","");
        value=value.substring(0,value.length()-1);
        value=value.substring(1).
                    replace("\"",",")
                    .replace(",,",",");
        String[] ss=value.split(",");
        for(String s:ss){
            System.out.println(s);
        }


    }
}
