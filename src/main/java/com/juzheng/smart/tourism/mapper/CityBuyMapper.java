package com.juzheng.smart.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juzheng.smart.tourism.entity.CityBuy;
import com.juzheng.smart.tourism.entity.CityBuyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CityBuyMapper extends BaseMapper<CityBuy> {
    int countByExample(CityBuyExample example);

    int deleteByExample(CityBuyExample example);

    int insert(CityBuy record);

    int insertSelective(CityBuy record);

    List<CityBuy> selectByExample(CityBuyExample example);

    int updateByExampleSelective(@Param("record") CityBuy record, @Param("example") CityBuyExample example);

    int updateByExample(@Param("record") CityBuy record, @Param("example") CityBuyExample example);
}