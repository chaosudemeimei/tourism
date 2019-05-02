package com.juzheng.smart.tourism;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.juzheng.smart.tourism.entity.UserInfo;
import com.juzheng.smart.tourism.mapper.UserInfoMapper;
import com.juzheng.smart.tourism.service.IUserInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TourismApplicationTests {


    @Autowired
    public IUserInfoService infoService;

    @Test
    public void contextLoads() {
        /*测试分页插件的代码*/
       Page<UserInfo>userInfoPage=new Page<>();
       //每页数量
        userInfoPage.setSize(3);
        //当前页数
        userInfoPage.setCurrent(2);
        System.out.println(infoService.page(userInfoPage).getRecords().toString());

    }






}
