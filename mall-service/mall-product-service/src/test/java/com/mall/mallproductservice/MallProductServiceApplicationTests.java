package com.mall.mallproductservice;

import com.peace.api.ProductService;
import com.peace.entity.Product;
import com.peace.vo.ProductVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MallProductServiceApplicationTests { //p95
    @Autowired
    private ProductService productService;
    @Test
    void contextLoads() {
        ProductVO productVO = new ProductVO();
        Product product = new Product();
        product.setName("iphone12");
        product.setPrice(5999l);
        product.setSalePrice(4999l);
        product.setImages("111");
        product.setSalePoint("苹果手机");
        product.setTypeId(5l);
        product.setTypeName("手机");
        productVO.setProduct(product);
        productVO.setProductDesc("苹果最新一代手机");
        System.out.println(productService.add(productVO));
    }

}
