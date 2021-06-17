package com.mall.mallcenter.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.peace.api.ProductService;
import com.peace.entity.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author peace
 * @since 2021-06-15
 */
@RestController
@RequestMapping("product")
public class ProductController {
    @Reference
    private ProductService productService;

    @RequestMapping("getProduct/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }


}

