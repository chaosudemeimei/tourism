package com.juzheng.smart.tourism.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.juzheng.smart.tourism.entity.CityPlay;
import com.juzheng.smart.tourism.entity.UserInfo;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ApiOperation(value="根据city_id获得city_play", notes="分页")
    @RequestMapping(value = "/api/city_play/{cityid}/{page}", method = RequestMethod.GET)
    public BaseResult<List<CityPlay>> getCityplays(@PathVariable("cityid") String cityid,@PathVariable("page")String page) {
        QueryWrapper<CityPlay> cityPlayQueryWrapper=new QueryWrapper<>();
        cityPlayQueryWrapper.lambda().eq(CityPlay::getCityId,cityid);
        //List<CityPlay> cityPlays=cityPlayService.list(cityPlayQueryWrapper);


        Page<CityPlay> cityPlayPage=new Page<>();
        //每页数量
        cityPlayPage.setSize(2);
        //当前页数
        cityPlayPage.setCurrent(Long.valueOf(page));
        List<CityPlay> cityPlays=cityPlayService.page(cityPlayPage,cityPlayQueryWrapper).getRecords();
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

    @ApiOperation(value="根据play_id获得play信息", notes="")
    @RequestMapping(value = "/api/city_play/{cityid}/play/{playid}", method = RequestMethod.GET)
    public BaseResult<CityPlay> getCityplay(@PathVariable("cityid") String cityid,@PathVariable("playid")String playid) {
        QueryWrapper<CityPlay> cityPlayQueryWrapper=new QueryWrapper<>();
        cityPlayQueryWrapper.lambda()
                .eq(CityPlay::getCityId,cityid)
                .eq(CityPlay::getPlayId,playid);
        CityPlay cityPlay=cityPlayService.getOne(cityPlayQueryWrapper);
        BaseResult baseResult=new BaseResult();

        if (cityPlay!=null){
            baseResult.setResult(cityPlay);
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

    @ApiOperation(value="根据token中的userid和返回的go", notes="设置用户是否想去/去过某个景点")
    @RequestMapping(value = "/api/city_play/{cityid}/play/{playid}", method = RequestMethod.GET)
    public BaseResult<CityPlay> setUserPlay(@PathVariable("cityid") String cityid,@PathVariable("playid")String playid) {
        QueryWrapper<CityPlay> cityPlayQueryWrapper=new QueryWrapper<>();
        cityPlayQueryWrapper.lambda()
                .eq(CityPlay::getCityId,cityid)
                .eq(CityPlay::getPlayId,playid);
        CityPlay cityPlay=cityPlayService.getOne(cityPlayQueryWrapper);
        BaseResult baseResult=new BaseResult();

        if (cityPlay!=null){
            baseResult.setResult(cityPlay);
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
