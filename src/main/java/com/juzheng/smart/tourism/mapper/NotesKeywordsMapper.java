package com.juzheng.smart.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juzheng.smart.tourism.entity.NotesKeywords;
import com.juzheng.smart.tourism.entity.NotesKeywordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NotesKeywordsMapper extends BaseMapper<NotesKeywords> {
    int countByExample(NotesKeywordsExample example);

    int deleteByExample(NotesKeywordsExample example);

    int insert(NotesKeywords record);

    int insertSelective(NotesKeywords record);

    List<NotesKeywords> selectByExample(NotesKeywordsExample example);

    int updateByExampleSelective(@Param("record") NotesKeywords record, @Param("example") NotesKeywordsExample example);

    int updateByExample(@Param("record") NotesKeywords record, @Param("example") NotesKeywordsExample example);
}