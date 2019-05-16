package com.juzheng.smart.tourism.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juzheng.smart.tourism.entity.CityPlay;
import com.juzheng.smart.tourism.entity.CityPlayComment;
import com.juzheng.smart.tourism.mapper.CityPlayCommentMapper;
import com.juzheng.smart.tourism.mapper.CityPlayMapper;
import com.juzheng.smart.tourism.service.ICityPlayCommentService;
import com.juzheng.smart.tourism.service.ICityPlayService;
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
public class CityPlayCommentServiceImpl extends ServiceImpl<CityPlayCommentMapper, CityPlayComment> implements ICityPlayCommentService {

}
