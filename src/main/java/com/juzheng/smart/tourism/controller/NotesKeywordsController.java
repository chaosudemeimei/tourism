package com.juzheng.smart.tourism.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.juzheng.smart.tourism.entity.KeyWords;
import com.juzheng.smart.tourism.entity.NotesKeywords;
import com.juzheng.smart.tourism.entity.UserDest;
import com.juzheng.smart.tourism.entity.UserKeywords;
import com.juzheng.smart.tourism.jwt.JwtHelper;
import com.juzheng.smart.tourism.mapper.NotesKeywordsMapper;
import com.juzheng.smart.tourism.service.IKeyWordsService;
import com.juzheng.smart.tourism.service.INotesKeywordsService;
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
@RequestMapping("/notes-keywords")
public class NotesKeywordsController {
    @Autowired
    private NotesKeywordsMapper notesKeywordsMapper;
    @Autowired
    private INotesKeywordsService notesKeywordsService;
    @Autowired
    private IKeyWordsService keyWordsService;

    @ApiOperation(value="查询游记所有的keywords", notes="根据中间表查询，返回的list")
    @RequestMapping(value = "/api/notes-keywords/{notesid}", method = RequestMethod.GET)
    public List selKeywords(@PathVariable("notesid") String notesid) {
        QueryWrapper<NotesKeywords>notesKeywordsQueryWrapper=new QueryWrapper<>();
        notesKeywordsQueryWrapper.lambda().eq(NotesKeywords::getNoteId,notesid);
        List<NotesKeywords>list=notesKeywordsService.list(notesKeywordsQueryWrapper);

        List<KeyWords>keyWordsList=new ArrayList<>();
        for(NotesKeywords notesKeywords1:list){
            QueryWrapper<KeyWords>keyWordsQueryWrapper=new QueryWrapper<>();
            keyWordsQueryWrapper.lambda().eq(KeyWords::getKeywordId, notesKeywords1.getKeywordId());
            keyWordsList.add(keyWordsService.getOne(keyWordsQueryWrapper));
        }
        return keyWordsList;

    }

}
