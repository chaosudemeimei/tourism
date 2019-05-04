package com.juzheng.smart.tourism.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.juzheng.smart.tourism.entity.CityBuy;
import com.juzheng.smart.tourism.entity.CityEat;
import com.juzheng.smart.tourism.mapper.CityBuyMapper;
import com.juzheng.smart.tourism.mapper.CityEatMapper;
import com.juzheng.smart.tourism.result.BaseResult;
import com.juzheng.smart.tourism.service.ICityBuyService;
import com.juzheng.smart.tourism.service.ICityEatService;
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
@RequestMapping("/city-eat")
public class CityEatController {
    @Autowired
    private CityEatMapper cityEatMapper;
    @Autowired
    private ICityEatService cityEatService;

    @ApiOperation(value="根据city_id获得city_eat", notes="token需要解析")
    @RequestMapping(value = "/api/city_eat/token/", method = RequestMethod.GET)
    public BaseResult<CityEat> get_Cityeat_by_Cityid() {
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
        QueryWrapper<CityEat> cityEatQueryWrapper=new QueryWrapper<>();
        cityEatQueryWrapper.lambda().eq(CityEat::getCityId,cityid);
        CityEat cityEat=cityEatService.getOne(cityEatQueryWrapper);
        BaseResult baseResult=new BaseResult();
        if (cityEat!=null){
            baseResult.setResult(cityEat);
            baseResult.setStatus("200");
            baseResult.setMessage("查询成功");
        }
        else {
            baseResult.setResult(cityEat);
            baseResult.setStatus("400");
            baseResult.setMessage("查询失败");
        }
        return  baseResult;
    }
}
