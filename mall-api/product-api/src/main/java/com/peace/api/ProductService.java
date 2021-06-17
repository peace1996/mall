package com.peace.api;

import com.baomidou.mybatisplus.extension.service.IService;
import com.peace.entity.Product;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author peace
 * @since 2021-06-15
 */
public interface ProductService extends IService<Product> {
    public Product getProductById(Long id);
}
