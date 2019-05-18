package com.juzheng.smart.tourism.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juzheng.smart.tourism.entity.KeyWords;
import com.juzheng.smart.tourism.entity.KeyWordsType;
import com.juzheng.smart.tourism.mapper.KeyWordsMapper;
import com.juzheng.smart.tourism.mapper.KeyWordsTypeMapper;
import com.juzheng.smart.tourism.service.IKeyWordsService;
import com.juzheng.smart.tourism.service.IKeyWordsTypeService;
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
public class KeyWordsTypeServiceImpl extends ServiceImpl<KeyWordsTypeMapper, KeyWordsType> implements IKeyWordsTypeService {

}
