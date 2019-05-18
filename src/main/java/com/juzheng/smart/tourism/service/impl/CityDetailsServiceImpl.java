package com.juzheng.smart.tourism.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juzheng.smart.tourism.entity.CityDetails;
import com.juzheng.smart.tourism.entity.CityDetailsComment;
import com.juzheng.smart.tourism.mapper.CityDetailsCommentMapper;
import com.juzheng.smart.tourism.mapper.CityDetailsMapper;
import com.juzheng.smart.tourism.service.ICityDetailsCommentService;
import com.juzheng.smart.tourism.service.ICityDetailsService;
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
public class CityDetailsServiceImpl extends ServiceImpl<CityDetailsMapper, CityDetails> implements ICityDetailsService {

}
