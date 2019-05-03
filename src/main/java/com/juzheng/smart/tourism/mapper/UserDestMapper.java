package com.juzheng.smart.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juzheng.smart.tourism.entity.UserDest;
import com.juzheng.smart.tourism.entity.UserDestExample;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface UserDestMapper extends BaseMapper<UserDest> {
    int countByExample(UserDestExample example);

    int deleteByExample(UserDestExample example);

    int insert(UserDest record);

    int insertSelective(UserDest record);

    List<UserDest> selectByExample(UserDestExample example);

    int updateByExampleSelective(@Param("record") UserDest record, @Param("example") UserDestExample example);

    int updateByExample(@Param("record") UserDest record, @Param("example") UserDestExample example);


}