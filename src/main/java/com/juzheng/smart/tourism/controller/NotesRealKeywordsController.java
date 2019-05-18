package com.juzheng.smart.tourism.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.juzheng.smart.tourism.entity.KeyWords;
import com.juzheng.smart.tourism.entity.NotesRealKeywords;
import com.juzheng.smart.tourism.entity.UserDest;
import com.juzheng.smart.tourism.entity.UserKeywords;
import com.juzheng.smart.tourism.jwt.JwtHelper;
import com.juzheng.smart.tourism.mapper.NotesRealKeywordsMapper;
import com.juzheng.smart.tourism.service.IKeyWordsService;
import com.juzheng.smart.tourism.service.INotesRealInfoService;
import com.juzheng.smart.tourism.service.INotesRealKeywordsService;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import org.apache.velocity.runtime.directive.contrib.For;
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
public class NotesRealKeywordsController {
//    @Autowired
//    private NotesRealKeywordsMapper notesRealKeywordsMapper;
//
//    @Autowired
//    private INotesRealKeywordsService iNotesRealKeywordsService;
//
//    @ApiOperation(value="查询游记所有的keywords", notes="根据中间表查询，返回的list")
//    @RequestMapping(value = "/api/notes-keywords/{notesid}", method = RequestMethod.GET)
//    public List selKeywords(@PathVariable("notesid") String notesid) {
//        QueryWrapper<NotesRealKeywords>notesKeywordsQueryWrapper=new QueryWrapper<>();
//        notesKeywordsQueryWrapper.lambda().eq(NotesRealKeywords::getNoteId,notesid);
//        List<NotesRealKeywords>list=iNotesRealKeywordsService.list(notesKeywordsQueryWrapper);
//
//        List<KeyWords>keyWordsList=new ArrayList<>();
//        for(NotesRealKeywords notesKeywords1:list){
//            QueryWrapper<KeyWords>keyWordsQueryWrapper=new QueryWrapper<>();
//            keyWordsQueryWrapper.lambda().eq(KeyWords::getKeywordId, notesKeywords1.getKeywordId());
//            keyWordsList.add(keyWordsService.getOne(keyWordsQueryWrapper));
//        }
//        return keyWordsList;
//
//    }

}
