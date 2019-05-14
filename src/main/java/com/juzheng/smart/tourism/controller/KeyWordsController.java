package com.juzheng.smart.tourism.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.juzheng.smart.tourism.entity.KeyWords;
import com.juzheng.smart.tourism.entity.UserKeywords;
import com.juzheng.smart.tourism.jwt.JwtHelper;
import com.juzheng.smart.tourism.mapper.KeyWordsMapper;
import com.juzheng.smart.tourism.result.KeywordsResult;
import com.juzheng.smart.tourism.service.IKeyWordsService;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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
@RequestMapping("/key-words")
public class KeyWordsController {

    @Autowired
    private KeyWordsMapper keyWordsMapper;
    @Autowired
    private IKeyWordsService keyWordsService;
    @ApiOperation(value="直接返回所有的keywords的名字", notes="list")
    @RequestMapping(value = "/api/key-words", method = RequestMethod.GET)
    public List findAllKeywords() {
        List<KeyWords>keyWordsList=keyWordsService.list();
        ArrayList<String> key=new ArrayList<>();
        for(int i=0;i<keyWordsList.size();i++){
                key.add(keyWordsList.get(i).getContent());
        }
        return  key;
    }

    @ApiOperation(value="返回所有keywords，自定义类型，根据token与mykeywords联查", notes="token放在header中")
    @RequestMapping(value = "/api/key-words/token", method = RequestMethod.GET)
    public String findAllKeywords2() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request= servletRequestAttributes.getRequest();
        String jwttoken=request.getHeader("token");
        Claims claims=JwtHelper.verifyJwt(jwttoken);
        String userid = String.valueOf(claims.get("userid"));

        UserKeywords userKeywords = new UserKeywords();
        QueryWrapper<UserKeywords> userKeywordsQueryWrapper=new QueryWrapper<>();
        userKeywordsQueryWrapper.lambda()
                .eq(UserKeywords::getUserId,userid);
        List<UserKeywords> userKeywordsList=userKeywords.selectList(userKeywordsQueryWrapper);
        ArrayList<String>user_keyid=new ArrayList<>();
        for(UserKeywords userKeywords1:userKeywordsList){
            user_keyid.add(userKeywords1.getKeywords());
        };

        List<KeyWords>keyWordsList=keyWordsService.list();
        ArrayList<KeywordsResult> key=new ArrayList<>();
        for(int i=0;i<keyWordsList.size();i++){
            KeywordsResult keywordsResult=new KeywordsResult();
            keywordsResult.setName(keyWordsList.get(i).getContent());
            keywordsResult.setValue(keyWordsList.get(i).getKeywordId());
            String keyid=keyWordsList.get(i).getKeywordId();
            int checked=0;
            for(int j=0;j<user_keyid.size();j++){
                if(user_keyid.get(j).equals(keyid)){
                    checked=1;
                }
            }
            keywordsResult.setChecked(checked);
            key.add(keywordsResult);
        }
        String json = JSON.toJSONString(key);
        return  json; //返回json字符串不然前端无法解析
    }

}
