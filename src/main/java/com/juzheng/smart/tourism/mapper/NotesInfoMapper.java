package com.juzheng.smart.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juzheng.smart.tourism.entity.NotesInfo;
import com.juzheng.smart.tourism.entity.NotesInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NotesInfoMapper extends BaseMapper<NotesInfo> {
    int countByExample(NotesInfoExample example);

    int deleteByExample(NotesInfoExample example);

    int insert(NotesInfo record);

    int insertSelective(NotesInfo record);

    List<NotesInfo> selectByExample(NotesInfoExample example);

    int updateByExampleSelective(@Param("record") NotesInfo record, @Param("example") NotesInfoExample example);

    int updateByExample(@Param("record") NotesInfo record, @Param("example") NotesInfoExample example);
}