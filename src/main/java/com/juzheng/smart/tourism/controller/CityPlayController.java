package com.juzheng.smart.tourism.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.juzheng.smart.tourism.entity.CityPlay;
import com.juzheng.smart.tourism.mapper.CityPlayMapper;
import com.juzheng.smart.tourism.result.BaseResult;
import com.juzheng.smart.tourism.service.ICityPlayService;
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
@RequestMapping("/city-play")
public class CityPlayController {
    @Autowired
    private CityPlayMapper cityPlayMapper;
    @Autowired
    private ICityPlayService cityPlayService;

    @ApiOperation(value="根据city_id获得city_play", notes="token需要解析")
    @RequestMapping(value = "/api/city_play/{cityid}", method = RequestMethod.GET)
    public BaseResult<List<CityPlay>> get_Citybuy_by_Cityid(@PathVariable("cityid") String cityid) {
        QueryWrapper<CityPlay> cityPlayQueryWrapper=new QueryWrapper<>();
        cityPlayQueryWrapper.lambda().eq(CityPlay::getCityId,cityid);
        List<CityPlay> cityPlays=cityPlayService.list(cityPlayQueryWrapper);
        BaseResult baseResult=new BaseResult();
        if (cityPlays!=null){
            baseResult.setResult(cityPlays);
            baseResult.setStatus("200");
            baseResult.setMessage("查询成功");
        }
        else {
            baseResult.setResult(null);
            baseResult.setStatus("400");
            baseResult.setMessage("查询失败");
        }
        return  baseResult;
    }
}
