package com.juzheng.smart.tourism.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.juzheng.smart.tourism.entity.City;
import com.juzheng.smart.tourism.mapper.CityMapper;
import com.juzheng.smart.tourism.result.BaseResult;
import com.juzheng.smart.tourism.service.ICityService;
import com.juzheng.smart.tourism.util.HotCity;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private ICityService cityService;
    @ApiOperation(value="返回热门城市列表", notes="token需要解析")
    @RequestMapping(value = "/api/city/token", method = RequestMethod.GET)
    public List<City> city_des_sel() {
        List<City>list=new ArrayList<>();
        for(HotCity hotCity : HotCity .values()){
            QueryWrapper<City>cityQueryWrapper=new QueryWrapper<>();
            cityQueryWrapper.lambda().eq(City::getName,hotCity.getCity_name());
            list.add(cityService.getOne(cityQueryWrapper));
        }

        return list;
    }



}
