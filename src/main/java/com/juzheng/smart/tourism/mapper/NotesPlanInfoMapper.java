package com.juzheng.smart.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juzheng.smart.tourism.entity.NotesPlanInfo;
import com.juzheng.smart.tourism.entity.NotesPlanInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NotesPlanInfoMapper extends BaseMapper<NotesPlanInfo> {
    int countByExample(NotesPlanInfoExample example);

    int deleteByExample(NotesPlanInfoExample example);

    int insert(NotesPlanInfo record);

    int insertSelective(NotesPlanInfo record);

    List<NotesPlanInfo> selectByExample(NotesPlanInfoExample example);

    int updateByExampleSelective(@Param("record") NotesPlanInfo record, @Param("example") NotesPlanInfoExample example);

    int updateByExample(@Param("record") NotesPlanInfo record, @Param("example") NotesPlanInfoExample example);
}