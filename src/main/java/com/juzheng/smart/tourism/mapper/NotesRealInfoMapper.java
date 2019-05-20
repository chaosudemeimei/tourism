package com.juzheng.smart.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juzheng.smart.tourism.entity.NotesPlanInfo;
import com.juzheng.smart.tourism.entity.NotesRealInfo;
import com.juzheng.smart.tourism.result.NotesRealResult;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRealInfoMapper extends BaseMapper<NotesRealInfo> {

}