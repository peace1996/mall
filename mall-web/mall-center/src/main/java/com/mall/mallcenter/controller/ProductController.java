package com.mall.mallcenter.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.peace.api.ProductService;
import com.peace.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author peace
 * @since 2021-06-15
 */
@Controller
@RequestMapping("product")
public class ProductController {
    @Reference
    private ProductService productService;

    @RequestMapping("getProduct/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable("id") Long id){
//        productService.getById(id)
        return productService.getProductById(id);
    }

    @RequestMapping("list")
    public String list(){
        return "product/list";
    }


}

