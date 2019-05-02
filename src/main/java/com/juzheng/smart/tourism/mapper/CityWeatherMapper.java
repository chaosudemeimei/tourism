package com.juzheng.smart.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juzheng.smart.tourism.entity.CityWeather;
import com.juzheng.smart.tourism.entity.CityWeatherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CityWeatherMapper extends BaseMapper<CityWeather> {
    int countByExample(CityWeatherExample example);

    int deleteByExample(CityWeatherExample example);

    int insert(CityWeather record);

    int insertSelective(CityWeather record);

    List<CityWeather> selectByExample(CityWeatherExample example);

    int updateByExampleSelective(@Param("record") CityWeather record, @Param("example") CityWeatherExample example);

    int updateByExample(@Param("record") CityWeather record, @Param("example") CityWeatherExample example);
}