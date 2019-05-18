package com.juzheng.smart.tourism.controller;


import com.juzheng.smart.tourism.entity.NotesRealInfo;
import com.juzheng.smart.tourism.mapper.NotesPlanInfoMapper;
import com.juzheng.smart.tourism.mapper.NotesRealInfoMapper;
import com.juzheng.smart.tourism.service.INotesRealInfoService;
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

}
