package com.juzheng.smart.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juzheng.smart.tourism.entity.KeyWords;
import com.juzheng.smart.tourism.entity.KeyWordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KeyWordsMapper extends BaseMapper<KeyWords> {
    int countByExample(KeyWordsExample example);

    int deleteByExample(KeyWordsExample example);

    int insert(KeyWords record);

    int insertSelective(KeyWords record);

    List<KeyWords> selectByExample(KeyWordsExample example);

    int updateByExampleSelective(@Param("record") KeyWords record, @Param("example") KeyWordsExample example);

    int updateByExample(@Param("record") KeyWords record, @Param("example") KeyWordsExample example);
}