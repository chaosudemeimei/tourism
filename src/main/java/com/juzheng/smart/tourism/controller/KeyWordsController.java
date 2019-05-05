package com.juzheng.smart.tourism.controller;


import com.juzheng.smart.tourism.entity.KeyWords;
import com.juzheng.smart.tourism.mapper.KeyWordsMapper;
import com.juzheng.smart.tourism.service.IKeyWordsService;
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
@RequestMapping("/key-words")
public class KeyWordsController {

    @Autowired
    private KeyWordsMapper keyWordsMapper;
    @Autowired
    private IKeyWordsService keyWordsService;
    @ApiOperation(value="返回所有的keywords", notes="list")
    @RequestMapping(value = "/api/key-words", method = RequestMethod.GET)
    public List findAllKeywords() {
        List<KeyWords>keyWordsList=keyWordsService.list();
        return  keyWordsList;
    }
}
