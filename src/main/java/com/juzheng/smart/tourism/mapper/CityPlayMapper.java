package com.juzheng.smart.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juzheng.smart.tourism.entity.CityPlay;
import com.juzheng.smart.tourism.entity.CityPlayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CityPlayMapper extends BaseMapper<CityPlay> {
    int countByExample(CityPlayExample example);

    int deleteByExample(CityPlayExample example);

    int insert(CityPlay record);

    int insertSelective(CityPlay record);

    List<CityPlay> selectByExample(CityPlayExample example);

    int updateByExampleSelective(@Param("record") CityPlay record, @Param("example") CityPlayExample example);

    int updateByExample(@Param("record") CityPlay record, @Param("example") CityPlayExample example);
}