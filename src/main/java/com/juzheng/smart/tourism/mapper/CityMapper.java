package com.juzheng.smart.tourism.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juzheng.smart.tourism.entity.City;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityMapper extends BaseMapper<City> {
}