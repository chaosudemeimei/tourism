package com.juzheng.smart.tourism.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juzheng.smart.tourism.entity.CityDetailsComment;
import com.juzheng.smart.tourism.entity.CityPlayComment;
import com.juzheng.smart.tourism.mapper.CityDetailsCommentMapper;
import com.juzheng.smart.tourism.mapper.CityPlayCommentMapper;
import com.juzheng.smart.tourism.service.ICityDetailsCommentService;
import com.juzheng.smart.tourism.service.ICityPlayCommentService;
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
public class CityDetailsCommentServiceImpl extends ServiceImpl<CityDetailsCommentMapper, CityDetailsComment> implements ICityDetailsCommentService {

}
