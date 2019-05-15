package com.juzheng.smart.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juzheng.smart.tourism.entity.UserDest;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface UserDestMapper extends BaseMapper<UserDest> {


}