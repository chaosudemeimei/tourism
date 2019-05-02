package com.juzheng.smart.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juzheng.smart.tourism.entity.City;
import com.juzheng.smart.tourism.entity.CityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CityMapper extends BaseMapper<City> {
    int countByExample(CityExample example);

    int deleteByExample(CityExample example);

    int insert(City record);

    int insertSelective(City record);

    List<City> selectByExample(CityExample example);

    int updateByExampleSelective(@Param("record") City record, @Param("example") CityExample example);

    int updateByExample(@Param("record") City record, @Param("example") CityExample example);
}