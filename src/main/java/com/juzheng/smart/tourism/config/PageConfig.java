package com.juzheng.smart.tourism.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author juzheng
 * @Title: PageConfig
 * @date 2019/4/24 9:35 AM
 * @Description:
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.juzheng.smart.tourism.mapper")
public class PageConfig {
    /*分页插件*/
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return  new PaginationInterceptor();
    }
}

