package com.mall.mallproductservice.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peace.api.ProductDescService;
import com.peace.entity.ProductDesc;
import com.peace.mapper.ProductDescMapper;
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
public class ProductDescServiceImpl extends ServiceImpl<ProductDescMapper, ProductDesc> implements ProductDescService {

}
