package com.juzheng.smart.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juzheng.smart.tourism.entity.UserKeywords;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserKeywordsMapper extends BaseMapper<UserKeywords> {
}