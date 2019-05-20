package com.juzheng.smart.tourism.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.juzheng.smart.tourism.entity.CityPlayComment;
import com.juzheng.smart.tourism.entity.NotesPlanInfo;
import com.juzheng.smart.tourism.jwt.JwtHelper;
import com.juzheng.smart.tourism.mapper.NotesPlanInfoMapper;
import com.juzheng.smart.tourism.result.BaseResult;
import com.juzheng.smart.tourism.result.NotesPlanInfoResult;
import com.juzheng.smart.tourism.service.INotesPlanInfoService;
import com.juzheng.smart.tourism.util.IdGenerator;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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
@RequestMapping("/notes-plan-info")
public class NotesPlanInfoController {
    @Autowired
    public NotesPlanInfoMapper notesPlanInfoMapper;

    @Autowired
    public INotesPlanInfoService iNotesPlanInfoService;
    @ApiOperation(value="根据token查询", notes="一个用户一个行程，没有就创建空的")
    @RequestMapping(value = "/api/notes-plan-info/token", method = RequestMethod.GET)
    public BaseResult selnotesplan() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request= servletRequestAttributes.getRequest();
        String jwttoken=request.getHeader("token");
        Claims claims=JwtHelper.verifyJwt(jwttoken);
        String userid = String.valueOf(claims.get("userid"));
        QueryWrapper<NotesPlanInfo>queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(NotesPlanInfo::getUserId,userid);
        NotesPlanInfo notesPlanInfo = new NotesPlanInfo();
        if(iNotesPlanInfoService.getOne(queryWrapper)==null){
            notesPlanInfo.setUserId(userid);
            notesPlanInfo.setPlanId(IdGenerator.createUserCode()+userid);
            notesPlanInfo.insert();
        }
        else{
            notesPlanInfo=iNotesPlanInfoService.getOne(queryWrapper);
        }
        BaseResult baseResult=new BaseResult<>();
        baseResult.setResult(notesPlanInfo);
        baseResult.setStatus("200");
        baseResult.setMessage("OK");

        return  baseResult;
    }

    @ApiOperation(value="根据tokeny以及返回值进行更新", notes="返回一个自定义类型")
    @RequestMapping(value = "/api/notes-plan-info/token", method = RequestMethod.PUT)
    public BaseResult upNotesPlan(@RequestBody NotesPlanInfoResult notesPlanInfoResult) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request= servletRequestAttributes.getRequest();
        String jwttoken=request.getHeader("token");
        Claims claims=JwtHelper.verifyJwt(jwttoken);
        String userid = String.valueOf(claims.get("userid"));

        QueryWrapper<NotesPlanInfo>queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(NotesPlanInfo::getUserId,userid);
        NotesPlanInfo notesPlanInfo = new NotesPlanInfo();

        notesPlanInfo.setCityId(notesPlanInfoResult.getCityId());
        notesPlanInfo.setBegintime(notesPlanInfoResult.getBegintime());
        notesPlanInfo.setEndtime(notesPlanInfoResult.getEndtime());
        notesPlanInfo.setPopulation(notesPlanInfoResult.getPopulation());
        notesPlanInfo.setBudget(notesPlanInfoResult.getBudget());
        notesPlanInfo.setContent(notesPlanInfoResult.getContent());
        notesPlanInfo.update(queryWrapper);

        BaseResult baseResult=new BaseResult<>();
        baseResult.setResult(notesPlanInfo);
        baseResult.setStatus("200");
        baseResult.setMessage("OK");

        return  baseResult;
    }

}
