package com.peace.api;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.peace.entity.Product;

import java.util.List;
import java.util.Map;

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

    /**
     * 分页
     */
    public PageInfo<Product> page(Integer pageIndex,Integer pageSize);


    public Map pageList(Integer pageIndex,Integer pageSize);
}
