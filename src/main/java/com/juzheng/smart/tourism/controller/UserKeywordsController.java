package com.juzheng.smart.tourism.controller;


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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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
        Cookie[] cookies = request.getCookies();
        String jwttoken = "";
        for (Cookie cookie : cookies) {
            switch(cookie.getName()){
                case "token":
                    jwttoken = cookie.getValue();
                    break;
                default:
                    break;
            }
        }
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
        Cookie[] cookies = request.getCookies();
        String jwttoken = "";
        for (Cookie cookie : cookies) {
            switch(cookie.getName()){
                case "token":
                    jwttoken = cookie.getValue();
                    break;
                default:
                    break;
            }
        }
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
        Cookie[] cookies = request.getCookies();
        String jwttoken = "";
        for (Cookie cookie : cookies) {
            switch(cookie.getName()){
                case "token":
                    jwttoken = cookie.getValue();
                    break;
                default:
                    break;
            }
        }
        Claims claims=JwtHelper.verifyJwt(jwttoken);
        String userid = String.valueOf(claims.get("userid"));

        UserKeywords userKeywords = new UserKeywords();
            List<UserKeywords> result=userKeywords.selectAll();
           // baseResult.setResult(result);
           // baseResult.setMessage("OK");
           // baseResult.setStatus("200");

        return result;

    }
}
