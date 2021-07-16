package com.mall.mallproductservice.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peace.api.ProductTypeService;
import com.peace.entity.ProductType;
import com.peace.mapper.ProductTypeMapper;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author peace
 * @since 2021-06-15
 */
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements ProductTypeService {

}
