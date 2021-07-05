package com.peace.vo;

import com.peace.entity.Product;
import com.peace.entity.ProductDesc;
import lombok.Data;

import java.io.Serializable;

/**
 * @author peace
 * 商品页面传输对象
 */
@Data
public class ProductVO implements Serializable {
    private Product product;
    private String productDesc;
}
