package com.juzheng.smart.tourism.controller;


import com.juzheng.smart.tourism.entity.KeyWords;
import com.juzheng.smart.tourism.entity.NotesInfo;
import com.juzheng.smart.tourism.mapper.KeyWordsMapper;
import com.juzheng.smart.tourism.mapper.NotesInfoMapper;
import com.juzheng.smart.tourism.service.IKeyWordsService;
import com.juzheng.smart.tourism.service.INotesInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/notes-info")
public class NotesInfoController {
    @Autowired
    private NotesInfoMapper notesInfoMapper;
    @Autowired
    private INotesInfoService notesInfoService;
    @ApiOperation(value="返回所有的游记", notes="list")
    @RequestMapping(value = "/api/notes-info", method = RequestMethod.GET)
    public List findAllKeynotesinfo() {
        List<NotesInfo>notesInfos=notesInfoService.list();
        return  notesInfos;
    }

}
