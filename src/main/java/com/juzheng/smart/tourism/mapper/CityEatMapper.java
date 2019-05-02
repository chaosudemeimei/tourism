package com.juzheng.smart.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juzheng.smart.tourism.entity.CityEat;
import com.juzheng.smart.tourism.entity.CityEatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CityEatMapper extends BaseMapper<CityEat> {
    int countByExample(CityEatExample example);

    int deleteByExample(CityEatExample example);

    int insert(CityEat record);

    int insertSelective(CityEat record);

    List<CityEat> selectByExample(CityEatExample example);

    int updateByExampleSelective(@Param("record") CityEat record, @Param("example") CityEatExample example);

    int updateByExample(@Param("record") CityEat record, @Param("example") CityEatExample example);
}