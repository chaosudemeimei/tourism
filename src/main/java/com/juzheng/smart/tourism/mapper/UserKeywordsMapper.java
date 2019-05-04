package com.juzheng.smart.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juzheng.smart.tourism.entity.UserKeywords;
import com.juzheng.smart.tourism.entity.UserKeywordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserKeywordsMapper extends BaseMapper<UserKeywords> {
    int countByExample(UserKeywordsExample example);

    int deleteByExample(UserKeywordsExample example);

    int insert(UserKeywords record);

    int insertSelective(UserKeywords record);

    List<UserKeywords> selectByExample(UserKeywordsExample example);

    int updateByExampleSelective(@Param("record") UserKeywords record, @Param("example") UserKeywordsExample example);

    int updateByExample(@Param("record") UserKeywords record, @Param("example") UserKeywordsExample example);
}