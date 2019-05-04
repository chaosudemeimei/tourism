package com.juzheng.smart.tourism.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.juzheng.smart.tourism.entity.CityEat;
import com.juzheng.smart.tourism.entity.CityPlay;
import com.juzheng.smart.tourism.mapper.CityEatMapper;
import com.juzheng.smart.tourism.mapper.CityPlayMapper;
import com.juzheng.smart.tourism.result.BaseResult;
import com.juzheng.smart.tourism.service.ICityEatService;
import com.juzheng.smart.tourism.service.ICityPlayService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author juzheng
 * @since 2019-04-19
 */
@RestController
@RequestMapping("/city-play")
public class CityPlayController {
    @Autowired
    private CityPlayMapper cityPlayMapper;
    @Autowired
    private ICityPlayService cityPlayService;

    @ApiOperation(value="根据city_id获得city_plyu", notes="token需要解析")
    @RequestMapping(value = "/api/city_play/token/", method = RequestMethod.GET)
    public BaseResult<CityPlay> get_Cityplay_by_Cityid() {
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
        QueryWrapper<CityPlay> cityPlayQueryWrapper=new QueryWrapper<>();
        cityPlayQueryWrapper.lambda().eq(CityPlay::getCityId,cityid);
        CityPlay cityPlay=cityPlayService.getOne(cityPlayQueryWrapper);
        BaseResult baseResult=new BaseResult();
        if (cityPlay!=null){
            baseResult.setResult(cityPlay);
            baseResult.setStatus("200");
            baseResult.setMessage("查询成功");
        }
        else {
            baseResult.setResult(cityPlay);
            baseResult.setStatus("400");
            baseResult.setMessage("查询失败");
        }
        return  baseResult;
    }
}
