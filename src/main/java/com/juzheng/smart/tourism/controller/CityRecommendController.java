package com.juzheng.smart.tourism.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.juzheng.smart.tourism.entity.CityPlay;
import com.juzheng.smart.tourism.entity.CityPlayComment;
import com.juzheng.smart.tourism.entity.CityPlayRecommend;
import com.juzheng.smart.tourism.entity.UserPlay;
import com.juzheng.smart.tourism.jwt.JwtHelper;
import com.juzheng.smart.tourism.mapper.CityPlayMapper;
import com.juzheng.smart.tourism.result.BaseResult;
import com.juzheng.smart.tourism.result.CityPlayCommentResult;
import com.juzheng.smart.tourism.service.ICityPlayCommentService;
import com.juzheng.smart.tourism.service.ICityPlayRecommendService;
import com.juzheng.smart.tourism.service.ICityPlayService;
import com.juzheng.smart.tourism.util.IdGenerator;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
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
@RequestMapping("/city-recommend")
public class CityRecommendController {
    @Autowired
    private ICityPlayRecommendService cityPlayRecommendService;

    @ApiOperation(value="根据play_id获得play_recommend信息", notes="推荐信息")
    @RequestMapping(value = "/api/city_recommend/{playid}", method = RequestMethod.GET)
    public BaseResult<CityPlayRecommend> getCityRec(@PathVariable("playid") String playid) {
        QueryWrapper<CityPlayRecommend> cityPlayRecommendQueryWrapper = new QueryWrapper<>();
        cityPlayRecommendQueryWrapper.lambda().eq(CityPlayRecommend::getPlayId, playid);
        CityPlayRecommend cityPlayRecommend = cityPlayRecommendService.getOne(cityPlayRecommendQueryWrapper);
        BaseResult baseResult = new BaseResult();
        if (cityPlayRecommend != null) {
            baseResult.setResult(cityPlayRecommend);
            baseResult.setStatus("200");
            baseResult.setMessage("查询成功");
        } else {
            baseResult.setResult(null);
            baseResult.setStatus("400");
            baseResult.setMessage("查询失败");
        }
        return baseResult;

    }




}
