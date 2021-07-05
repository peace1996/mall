package com.peace.api;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.peace.entity.Product;
import com.peace.vo.PageInfoVO;
import com.peace.vo.ProductVO;

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


    public PageInfoVO pageList(Integer pageIndex, Integer pageSize);

    /**
     * 添加
     * @param productVO
     * @return
     */
    public Long add(ProductVO productVO);
}
