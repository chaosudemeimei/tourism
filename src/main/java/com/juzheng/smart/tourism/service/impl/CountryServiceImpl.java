package com.juzheng.smart.tourism.service.impl;

import com.juzheng.smart.tourism.entity.Country;
import com.juzheng.smart.tourism.mapper.CountryMapper;
import com.juzheng.smart.tourism.service.ICountryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author juzheng
 * @since 2019-04-26
 */
@Service
public class CountryServiceImpl extends ServiceImpl<CountryMapper, Country> implements ICountryService {

}
