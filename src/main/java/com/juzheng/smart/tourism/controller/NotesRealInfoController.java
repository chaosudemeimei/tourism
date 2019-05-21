package com.juzheng.smart.tourism.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.juzheng.smart.tourism.entity.City;
import com.juzheng.smart.tourism.entity.NotesPlanInfo;
import com.juzheng.smart.tourism.entity.NotesRealInfo;
import com.juzheng.smart.tourism.jwt.JwtHelper;
import com.juzheng.smart.tourism.mapper.NotesPlanInfoMapper;
import com.juzheng.smart.tourism.mapper.NotesRealInfoMapper;
import com.juzheng.smart.tourism.result.BaseResult;
import com.juzheng.smart.tourism.result.NotesPlanInfoResult;
import com.juzheng.smart.tourism.result.NotesRealResult;
import com.juzheng.smart.tourism.result.NotesRes;
import com.juzheng.smart.tourism.service.INotesRealInfoService;
import com.juzheng.smart.tourism.util.IdGenerator;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
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
public class NotesRealInfoController {
    @Autowired
    private NotesRealInfoMapper notesRealInfoMapper;
    @Autowired
    private INotesRealInfoService notesRealInfoService;
    @ApiOperation(value="返回所有的游记", notes="list")
    @RequestMapping(value = "/api/notes-real-info", method = RequestMethod.GET)
    public List findAllKeynotesinfo() {
        List<NotesRealInfo>notesInfos=notesRealInfoService.list();
        return  notesInfos;
    }

    @ApiOperation(value="根据token以及返回值我的发布", notes="返回一个自定义类型把cityid换成cityname")
    @RequestMapping(value = "/api/notes-real-info/token", method = RequestMethod.GET)
    public BaseResult getNotesReal() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request= servletRequestAttributes.getRequest();
        String jwttoken=request.getHeader("token");
        Claims claims=JwtHelper.verifyJwt(jwttoken);
        String userid = String.valueOf(claims.get("userid"));

        QueryWrapper<NotesRealInfo>queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(NotesRealInfo::getUserId,userid);
        List<NotesRealInfo>notesRealInfoArrayList=notesRealInfoService.list(queryWrapper);
        List<NotesRealResult>notesRealResultList=new ArrayList<>();
        String cityname="";
        for(int i=0;i<notesRealInfoArrayList.size();i++) {
            QueryWrapper<City> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.lambda().eq(City::getCityId,notesRealInfoArrayList.get(i).getCityId());
            City city=new City();
            if(notesRealInfoArrayList.get(i).getCityId()!=null)
            cityname= city.selectOne(queryWrapper1).getName();
            NotesRealResult notesRealResult=new NotesRealResult();
            notesRealResult.setNoteId(notesRealInfoArrayList.get(i).getNoteId());
            notesRealResult.setUserId(notesRealInfoArrayList.get(i).getUserId());
            notesRealResult.setCityId(notesRealInfoArrayList.get(i).getCityId());
            notesRealResult.setTitle(notesRealInfoArrayList.get(i).getTitle());
            notesRealResult.setContent(notesRealInfoArrayList.get(i).getContent());
            notesRealResult.setCreatime(notesRealInfoArrayList.get(i).getCreatime());
            notesRealResult.setCityName(cityname);

            notesRealResultList.add(notesRealResult);
        }


        BaseResult baseResult=new BaseResult<>();
        baseResult.setResult(notesRealResultList);
        baseResult.setStatus("200");
        baseResult.setMessage("OK");

        return  baseResult;
    }

    @ApiOperation(value="根据token新增一个发布", notes="")
    @RequestMapping(value = "/api/notes-real-info/token", method = RequestMethod.PUT)
    public BaseResult upNotesReal(@RequestBody NotesRes notesReas) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request= servletRequestAttributes.getRequest();
        String jwttoken=request.getHeader("token");
        Claims claims=JwtHelper.verifyJwt(jwttoken);
        String userid = String.valueOf(claims.get("userid"));

        NotesRealInfo notesRealInfo=new NotesRealInfo();
        notesRealInfo.setNoteId(IdGenerator.createUserCode()+"note");
        notesRealInfo.setUserId(userid);
        notesRealInfo.setCityId(notesReas.getCityId());
        notesRealInfo.setTitle(notesReas.getTitle());
        notesRealInfo.setContent(notesReas.getContent());
        notesRealInfo.setCreatime(String.valueOf(new Date()));
        notesRealInfo.insert();
        BaseResult baseResult=new BaseResult<>();
        baseResult.setResult(notesRealInfo);
        baseResult.setStatus("200");
        baseResult.setMessage("OK");

        return  baseResult;

    }


}
