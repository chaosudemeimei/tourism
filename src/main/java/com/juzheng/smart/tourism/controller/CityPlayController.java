package com.juzheng.smart.tourism.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.juzheng.smart.tourism.entity.CityPlay;
import com.juzheng.smart.tourism.entity.CityPlayComment;
import com.juzheng.smart.tourism.entity.UserInfo;
import com.juzheng.smart.tourism.entity.UserPlay;
import com.juzheng.smart.tourism.jwt.JwtHelper;
import com.juzheng.smart.tourism.mapper.CityPlayMapper;
import com.juzheng.smart.tourism.result.BaseResult;
import com.juzheng.smart.tourism.result.CityPlayCommentResult;
import com.juzheng.smart.tourism.service.ICityPlayCommentService;
import com.juzheng.smart.tourism.service.ICityPlayService;
import com.juzheng.smart.tourism.util.IdGenerator;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
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

    @Autowired
    private ICityPlayCommentService cityPlayCommentService;

    @ApiOperation(value="根据city_id获得city_play", notes="分页")
    @RequestMapping(value = "/api/city_play/{cityid}/{page}", method = RequestMethod.GET)
    public BaseResult<List<CityPlay>> getCityplays(@PathVariable("cityid") String cityid,@PathVariable("page")String page) {
        QueryWrapper<CityPlay> cityPlayQueryWrapper=new QueryWrapper<>();
        cityPlayQueryWrapper.lambda().eq(CityPlay::getCityId,cityid);
        //List<CityPlay> cityPlays=cityPlayService.list(cityPlayQueryWrapper);


        Page<CityPlay> cityPlayPage=new Page<>();
        //每页数量
        cityPlayPage.setSize(6);
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

    @ApiOperation(value="根据play_id+cityid获得play信息", notes="")
    @RequestMapping(value = "/api/city_play/{cityid}/play/{playid}", method = RequestMethod.GET)
    public BaseResult<CityPlay> getCityplay(@PathVariable("cityid") String cityid,@PathVariable("playid")String playid) {
            QueryWrapper<CityPlay> cityPlayQueryWrapper = new QueryWrapper<>();
            cityPlayQueryWrapper.lambda()
                    .eq(CityPlay::getCityId, cityid)
                    .eq(CityPlay::getPlayId, playid);
            CityPlay cityPlay = cityPlayService.getOne(cityPlayQueryWrapper);
            BaseResult baseResult = new BaseResult();
            if (cityPlay != null) {
                baseResult.setResult(cityPlay);
                baseResult.setStatus("200");
                baseResult.setMessage("查询成功");
            } else {
                baseResult.setResult(null);
                baseResult.setStatus("400");
                baseResult.setMessage("查询失败");
            }
            return baseResult;

    }

    @ApiOperation(value="根据play_id获得play信息", notes="")
    @RequestMapping(value = "/api/city_play/{playid}", method = RequestMethod.GET)
    public BaseResult<CityPlay> getCityplay2(@PathVariable("playid") String playid) {
        QueryWrapper<CityPlay> cityPlayQueryWrapper = new QueryWrapper<>();
        cityPlayQueryWrapper.lambda().eq(CityPlay::getPlayId, playid);
        CityPlay cityPlay = cityPlayService.getOne(cityPlayQueryWrapper);
        BaseResult baseResult = new BaseResult();
        if (cityPlay != null) {
            baseResult.setResult(cityPlay);
            baseResult.setStatus("200");
            baseResult.setMessage("查询成功");
        } else {
            baseResult.setResult(null);
            baseResult.setStatus("400");
            baseResult.setMessage("查询失败");
        }
        return baseResult;

    }


    @ApiOperation(value="根据token中的userid和cityid,playid返回对应的go", notes="查询是否想去。去过某个景点")
    @RequestMapping(value = "/api/user-play/token/{cityid}/play/{playid}", method = RequestMethod.GET)
    public BaseResult<String> selUserPlay(@PathVariable("cityid") String cityid,@PathVariable("playid")String playid) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request= servletRequestAttributes.getRequest();
        String jwttoken=request.getHeader("token");
        Claims claims=JwtHelper.verifyJwt(jwttoken);
        String userid = String.valueOf(claims.get("userid"));


        //此处尝试活动模式：
        QueryWrapper<UserPlay>queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(UserPlay::getCityId,cityid)
                             .eq(UserPlay::getUserId,userid)
                             .eq(UserPlay::getPlayId,playid);
        UserPlay userPlay=new UserPlay();
        if(userPlay.selectCount(queryWrapper)==0){
            userPlay.setGo(Integer.valueOf("0"));
            userPlay.setCityId(cityid);
            userPlay.setPlayId(playid);
            userPlay.setUserId(userid);
            userPlay.insert();
        }
        else {
           userPlay=userPlay.selectOne(queryWrapper);
        }

        BaseResult<String> baseResult=new BaseResult<>();
        baseResult.setResult(userPlay.getGo().toString());
        baseResult.setStatus("200");
        baseResult.setMessage("OK");

        return  baseResult;
    }


    @ApiOperation(value="根据token中的userid和返回的go", notes="更新设置用户是否想去/去过某个景点")
    @RequestMapping(value = "/api/user-play/token/{cityid}/play/{playid}/go/{go}", method = RequestMethod.PUT)
    public BaseResult<UserPlay> setUserPlay(@PathVariable("cityid") String cityid,@PathVariable("playid")String playid,@PathVariable("go")String go) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request= servletRequestAttributes.getRequest();
        String jwttoken=request.getHeader("token");
        Claims claims=JwtHelper.verifyJwt(jwttoken);
        String userid = String.valueOf(claims.get("userid"));

        QueryWrapper<UserPlay>queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(UserPlay::getCityId,cityid)
                .eq(UserPlay::getUserId,userid)
                .eq(UserPlay::getPlayId,playid);
        UserPlay userPlay=new UserPlay();
        if(userPlay.selectCount(queryWrapper)==0){
            userPlay.setGo(Integer.valueOf(go));
            userPlay.setCityId(cityid);
            userPlay.setPlayId(playid);
            userPlay.setUserId(userid);
            userPlay.insert();
        }
        else {
            userPlay.setGo(Integer.valueOf(go));
            userPlay.update(queryWrapper);
        }
        BaseResult<UserPlay> baseResult=new BaseResult<>();
        baseResult.setResult(userPlay);
        baseResult.setStatus("200");
        baseResult.setMessage("OK");

        return  baseResult;
    }

    @ApiOperation(value="根据cityid查看所有cityplay的所有评论", notes="分页")
    @RequestMapping(value = "/api/city-play-comment/play/{playid}/page/{page}", method = RequestMethod.GET)
    public BaseResult selPlayComment(@PathVariable("playid")String playid,@PathVariable("page")String page) {
        QueryWrapper<CityPlayComment>queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(CityPlayComment::getPlayId,playid);
        Page<CityPlayComment>cityPlayCommentPage=new Page<>();
        cityPlayCommentPage.setSize(5);
        cityPlayCommentPage.setCurrent(Long.valueOf(page));
        BaseResult baseResult=new BaseResult<>();
        List<CityPlayComment>cityPlayComments=cityPlayCommentService.page(cityPlayCommentPage,queryWrapper).getRecords();
        baseResult.setResult(cityPlayComments);
        baseResult.setStatus("200");
        baseResult.setMessage("OK");

        return  baseResult;
    }

    @ApiOperation(value="根据token,playid插入新的cityplaycoment", notes="发布对景点的评论打分")
    @RequestMapping(value = "/api/city-play-comment/token", method = RequestMethod.PUT)
    public BaseResult selPlayComment(@RequestBody CityPlayCommentResult cityPlayCommentResult) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request= servletRequestAttributes.getRequest();
        String jwttoken=request.getHeader("token");
        Claims claims=JwtHelper.verifyJwt(jwttoken);
        String userid = String.valueOf(claims.get("userid"));

        String playId=cityPlayCommentResult.getPlayId();
        String content=cityPlayCommentResult.getContent();
        int score=cityPlayCommentResult.getScore();

        CityPlayComment cityPlayComment = new CityPlayComment();
        cityPlayComment.setCommentId(IdGenerator.createUserCode()+"_"+playId);
        cityPlayComment.setPlayId(playId);
        cityPlayComment.setUserId(userid);
        cityPlayComment.setCreatime(String.valueOf(LocalDate.now()));
        cityPlayComment.setContent(content);
        cityPlayComment.setScore(score);
        cityPlayCommentService.save(cityPlayComment);
        BaseResult baseResult=new BaseResult();
        baseResult.setResult(cityPlayCommentResult);
        baseResult.setStatus("200");
        baseResult.setMessage("OK");

        return  baseResult;
    }

}
