package com.mall.mallproductservice.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.peace.api.ProductService;
import com.peace.entity.Product;
import com.peace.mapper.ProductMapper;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author peace
 * @since 2021-06-15
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Override
    public Product getProductById(Long id) {
        return baseMapper.selectById(id);
    }
}
