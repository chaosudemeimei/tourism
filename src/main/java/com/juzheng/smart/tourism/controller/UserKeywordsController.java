package com.juzheng.smart.tourism.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.juzheng.smart.tourism.entity.KeyWords;
import com.juzheng.smart.tourism.entity.UserKeywords;
import com.juzheng.smart.tourism.jwt.JwtHelper;
import com.juzheng.smart.tourism.mapper.UserKeywordsMapper;
import com.juzheng.smart.tourism.result.BaseResult;
import com.juzheng.smart.tourism.service.IUserKeywordsService;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author juzheng
 * @since 2019-04-19
 */
@RestController
@RequestMapping("/user-keywords")
public class UserKeywordsController {
    @Autowired
    private IUserKeywordsService userKeywordsService;
    @Autowired
    private UserKeywordsMapper userKeywordsMapper;

    @ApiOperation(value="根据token，增加用户的keywords", notes="一次增加一条")
    @RequestMapping(value = "/api/user-keywords/token/{keywordsid}", method = RequestMethod.POST)
    public BaseResult addKeywords(@PathVariable("keywordsid") String keywordsid) {
        BaseResult baseResult=new BaseResult();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request= servletRequestAttributes.getRequest();
        String jwttoken=request.getHeader("token");

        Claims claims=JwtHelper.verifyJwt(jwttoken);
        String userid = String.valueOf(claims.get("userid"));
        //此处尝试使用活动模式
        UserKeywords userKeywords = new UserKeywords();
        if (keywordsid!=null){
        userKeywords.setKeywords(keywordsid);
        userKeywords.setUserId(userid);
        boolean result=userKeywords.insert();
        baseResult.setResult(result);
        baseResult.setMessage("OK");
        baseResult.setStatus("200");
        }
        return baseResult;

    }

    @ApiOperation(value="根据token，删除用户指定的单个keywords", notes="一次删除一条")
    @RequestMapping(value = "/api/user-keywords/token/{keywordsid}", method = RequestMethod.DELETE)
    public BaseResult delKeywords(@PathVariable("keywordsid") String keywordsid) {
        BaseResult baseResult=new BaseResult();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request= servletRequestAttributes.getRequest();
        String jwttoken=request.getHeader("token");

        Claims claims=JwtHelper.verifyJwt(jwttoken);
        String userid = String.valueOf(claims.get("userid"));

        if (keywordsid!=null){
            QueryWrapper<UserKeywords>userKeywordsQueryWrapper=new QueryWrapper<>();
            userKeywordsQueryWrapper.lambda()
                                    .eq(UserKeywords::getKeywords,keywordsid)
                                    .eq(UserKeywords::getUserId,userid);
            UserKeywords userKeywords = new UserKeywords();
            boolean result=userKeywords.delete(userKeywordsQueryWrapper);
            baseResult.setResult(result);
            baseResult.setMessage("OK");
            baseResult.setStatus("200");
        }
        return baseResult;

    }

    @ApiOperation(value="根据token，查询用户所有的keywords", notes="返回的list")
    @RequestMapping(value = "/api/user-keywords/token", method = RequestMethod.GET)
    public List selKeywords() {
       // BaseResult baseResult=new BaseResult();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request= servletRequestAttributes.getRequest();
        String jwttoken=request.getHeader("token");
        Claims claims=JwtHelper.verifyJwt(jwttoken);
        String userid = String.valueOf(claims.get("userid"));

        UserKeywords userKeywords = new UserKeywords();
        QueryWrapper<UserKeywords>userKeywordsQueryWrapper=new QueryWrapper<>();
        userKeywordsQueryWrapper.lambda()
                .eq(UserKeywords::getUserId,userid);
        List<UserKeywords> result=userKeywords.selectList(userKeywordsQueryWrapper);
           // baseResult.setResult(result);
           // baseResult.setMessage("OK");
           // baseResult.setStatus("200");

        return result;

    }

    @ApiOperation(value="根据token，以及返回的keywords的id，修改user的的keywords", notes="更新包括增加/删除")
    @RequestMapping(value = "/api/user-keywords/token/update", method = RequestMethod.PUT)
    public BaseResult updateKeywords(@RequestBody String keyids) {
        BaseResult baseResult=new BaseResult();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request= servletRequestAttributes.getRequest();
        String jwttoken=request.getHeader("token");
        Claims claims=JwtHelper.verifyJwt(jwttoken);
        String userid = String.valueOf(claims.get("userid"));

        System.out.println(keyids);
        JSONObject j1 = JSONObject.parseObject(keyids);
        String value = j1.getString("val");
        value=value.replace("[","")
                .replace(",","")
                .replace("]","");
        value=value.substring(0,value.length()-1);
        value=value.substring(1).
                replace("\"",",")
                .replace(",,",",");
        String[] ss=value.split(","); //最终获得了前端个人选择的keywordsid

        UserKeywords userKeywords = new UserKeywords();
        QueryWrapper<UserKeywords>userKeywordsQueryWrapper=new QueryWrapper<>();
        userKeywordsQueryWrapper.lambda()
                .eq(UserKeywords::getUserId,userid);
        List<UserKeywords> userKeywordsList=userKeywords.selectList(userKeywordsQueryWrapper);//数据库的个人keyid
        System.out.println(userKeywordsList);
        //假设ss:1,4,9    list:1,4,7 实际：1，4，7
        for(int i=0;i<ss.length;i++){//先遍历新的
            boolean new_hava=false;//状态，
            for (int j=0;j<userKeywordsList.size();j++){//遍历老的
            if(ss[i].equals(userKeywordsList.get(j).getKeywords())){//在老的里能找到新的
                new_hava=true;//true
               // userKeywordsList.remove(j);
            }
            }
            if(new_hava==false)//若找不到就插入对应的新的
            {
                UserKeywords userKeywords1=new UserKeywords();
                userKeywords1.setUserId(userid);
                userKeywords1.setKeywords(ss[i]);
                userKeywords1.insert();
            }
        }
        System.out.println(userKeywords.selectAll());
        //此时ss:1,4,9    list:1，4，7   实际：1，4，7，9
        for(int j=0;j<userKeywordsList.size();j++){
            boolean old_hava=false;
            for(int i=0;i<ss.length;i++){
                if(ss[i].equals(userKeywordsList.get(j).getKeywords())){
                    old_hava=true;
                }

            }
            if(old_hava==false){
                UserKeywords userKeywords1=new UserKeywords();
                QueryWrapper<UserKeywords>userKeywordsWrapper=new QueryWrapper<>();
                userKeywordsWrapper.lambda()
                        .eq(UserKeywords::getUserId,userid)
                        .eq(UserKeywords::getKeywords,userKeywordsList.get(j).getKeywords());
                userKeywords1.delete(userKeywordsWrapper);
            }

        }
        System.out.println(userKeywords.selectAll());
        //此时，实际1，4，7

         baseResult.setResult("success");
         baseResult.setMessage("OK");
         baseResult.setStatus("200");

        return baseResult;

    }
}
