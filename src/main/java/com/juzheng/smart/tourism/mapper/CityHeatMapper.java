package com.juzheng.smart.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juzheng.smart.tourism.entity.CityHeat;
import com.juzheng.smart.tourism.entity.CityHeatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CityHeatMapper extends BaseMapper<CityHeat> {
    int countByExample(CityHeatExample example);

    int deleteByExample(CityHeatExample example);

    int insert(CityHeat record);

    int insertSelective(CityHeat record);

    List<CityHeat> selectByExample(CityHeatExample example);

    int updateByExampleSelective(@Param("record") CityHeat record, @Param("example") CityHeatExample example);

    int updateByExample(@Param("record") CityHeat record, @Param("example") CityHeatExample example);
}