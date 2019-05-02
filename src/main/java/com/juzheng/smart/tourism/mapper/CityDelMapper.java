package com.juzheng.smart.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juzheng.smart.tourism.entity.CityDel;
import com.juzheng.smart.tourism.entity.CityDelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CityDelMapper extends BaseMapper<CityDel> {
    int countByExample(CityDelExample example);

    int deleteByExample(CityDelExample example);

    int insert(CityDel record);

    int insertSelective(CityDel record);

    List<CityDel> selectByExample(CityDelExample example);

    int updateByExampleSelective(@Param("record") CityDel record, @Param("example") CityDelExample example);

    int updateByExample(@Param("record") CityDel record, @Param("example") CityDelExample example);
}