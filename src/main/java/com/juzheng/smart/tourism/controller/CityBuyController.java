package com.juzheng.smart.tourism.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.juzheng.smart.tourism.entity.CityBuy;
import com.juzheng.smart.tourism.entity.UserDest;
import com.juzheng.smart.tourism.jwt.JwtHelper;
import com.juzheng.smart.tourism.mapper.CityBuyMapper;
import com.juzheng.smart.tourism.result.BaseResult;
import com.juzheng.smart.tourism.service.ICityBuyService;
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

/**
 *
 *
 * @author juzheng
 * @since 2019-04-19
 */
@RestController
@RequestMapping("/city-buy")
public class CityBuyController {
    @Autowired
    private CityBuyMapper cityBuyMapper;
    @Autowired
    private ICityBuyService cityBuyService;

    @ApiOperation(value="根据city_id获得city_buy", notes="token需要解析")
    @RequestMapping(value = "/api/city_buy/token/", method = RequestMethod.GET)
    public BaseResult<CityBuy> get_Citybuy_by_Cityid() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request= servletRequestAttributes.getRequest();
        Cookie[] cookies = request.getCookies();
        String cityid = "";
        for (Cookie cookie : cookies) {
            switch(cookie.getName()){
                case "cityid":
                    cityid = cookie.getValue();
                    break;
                default:
                    break;
            }
        }
        QueryWrapper<CityBuy> cityBuyQueryWrapper=new QueryWrapper<>();
        cityBuyQueryWrapper.lambda().eq(CityBuy::getCityId,cityid);
        CityBuy cityBuy=cityBuyService.getOne(cityBuyQueryWrapper);
        BaseResult baseResult=new BaseResult();
        if (cityBuy!=null){
            baseResult.setResult(cityBuy);
            baseResult.setStatus("200");
            baseResult.setMessage("查询成功");
        }
        else {
            baseResult.setResult(cityBuy);
            baseResult.setStatus("400");
            baseResult.setMessage("查询失败");
        }
        return  baseResult;
    }
}
