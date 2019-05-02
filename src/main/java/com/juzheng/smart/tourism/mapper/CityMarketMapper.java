package com.juzheng.smart.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juzheng.smart.tourism.entity.CityMarket;
import com.juzheng.smart.tourism.entity.CityMarketExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CityMarketMapper extends BaseMapper<CityMarket> {
    int countByExample(CityMarketExample example);

    int deleteByExample(CityMarketExample example);

    int insert(CityMarket record);

    int insertSelective(CityMarket record);

    List<CityMarket> selectByExample(CityMarketExample example);

    int updateByExampleSelective(@Param("record") CityMarket record, @Param("example") CityMarketExample example);

    int updateByExample(@Param("record") CityMarket record, @Param("example") CityMarketExample example);
}