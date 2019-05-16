package com.juzheng.smart.tourism.mapper;

/**
 * @author juzheng
 * @Title: CityPlayCommentMapper
 * @date 2019/5/16 10:55 PM
 * @Description:
 */
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juzheng.smart.tourism.entity.City;
import java.util.List;

import com.juzheng.smart.tourism.entity.CityPlayComment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityPlayCommentMapper extends BaseMapper<CityPlayComment> {
}