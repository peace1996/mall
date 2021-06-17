package com.mall.mallproductservice;

import com.peace.api.ProductService;
import com.peace.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MallProductServiceApplicationTests { //p95
    @Autowired
    private ProductService productService;
    @Test
    void contextLoads() {
        Product product = productService.getProductById(1L);
        System.out.println(product.getName());
    }

}
