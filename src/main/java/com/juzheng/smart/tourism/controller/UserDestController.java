package com.juzheng.smart.tourism.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.juzheng.smart.tourism.entity.City;
import com.juzheng.smart.tourism.entity.UserDest;
import com.juzheng.smart.tourism.entity.UserInfo;
import com.juzheng.smart.tourism.jwt.JwtHelper;
import com.juzheng.smart.tourism.mapper.UserDestMapper;
import com.juzheng.smart.tourism.result.BaseResult;
import com.juzheng.smart.tourism.service.ICityService;
import com.juzheng.smart.tourism.service.IUserDestService;
import com.juzheng.smart.tourism.service.impl.CityServiceImpl;
import com.juzheng.smart.tourism.service.impl.UserDestServiceImpl;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author juzheng
 * @since 2019-04-19
 */
@RestController
@RequestMapping("/user-dest")
public class UserDestController {
    @Autowired
    private UserDestMapper userDestMapper;
    @Autowired
    private IUserDestService userDestService;
    @Autowired
    private ICityService cityService;

    @ApiOperation(value="新增/修改用户的目的地城市", notes="token需要解析")
    @RequestMapping(value = "/api/user_dest/token/{cityid}", method = RequestMethod.POST)
    public BaseResult<UserDest> city_des_update_or_create(@PathVariable("cityid") String cityid) {
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

        QueryWrapper<City>cityQueryWrapper=new QueryWrapper<>();
        cityQueryWrapper.lambda().eq(City::getCityId,cityid);
        City city=cityService.getOne(cityQueryWrapper);
        UserDest userDest_new=new UserDest();
        if (city!=null&&userid!=null){
            userDest_new.setUserId(userid);
            userDest_new.setCityId(cityid);

            QueryWrapper<UserDest> queryWrapper=new QueryWrapper<>();
            queryWrapper.lambda().eq(UserDest::getUserId,userid);
            UserDest userDest_table=userDestService.getOne(queryWrapper);

            if (userDest_table!=null){
                int user_dest_id=userDest_table.getId();
                userDest_new.setId(user_dest_id);
                userDestService.saveOrUpdate(userDest_new);
            }
            else{
                userDestService.saveOrUpdate(userDest_new);
            }

        }
        HttpServletResponse response = servletRequestAttributes.getResponse();
        Cookie cookie = new Cookie("cityid", cityid);
        cookie.setMaxAge(3600);
        cookie.setDomain("localhost");
        cookie.setPath("/");
        response.addCookie(cookie);
        BaseResult baseResult=new BaseResult();
        baseResult.setResult(userDest_new);
        baseResult.setStatus("200");
        baseResult.setMessage("success");
        return baseResult;
    }

    @ApiOperation(value="查询用户的目的地城市", notes="token需要解析")
    @RequestMapping(value = "/api/user_dest/token", method = RequestMethod.GET)
    public BaseResult<UserDest> city_des_sel() {
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

        QueryWrapper<UserDest>userDestQueryWrapper=new QueryWrapper<>();
        userDestQueryWrapper.lambda().eq(UserDest::getUserId,userid);
        UserDest userDest=userDestService.getOne(userDestQueryWrapper);
        BaseResult baseResult=new BaseResult();
        if (userDest!=null){
            baseResult.setResult(userDest);
            baseResult.setStatus("200");
            baseResult.setMessage("查询成功");
        }
        else {
            baseResult.setResult(userDest);
            baseResult.setStatus("400");
            baseResult.setMessage("查询失败");
        }
        //把城市信息存cookie
        HttpServletResponse response = servletRequestAttributes.getResponse();
        Cookie cookie = new Cookie("cityid", userDest.getCityId());
        cookie.setMaxAge(3600);
        cookie.setDomain("localhost");
        cookie.setPath("/");
        response.addCookie(cookie);

        return baseResult;
    }




}
