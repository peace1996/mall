package com.mall.commons.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author peace
 * 统一返回json对象
 */
@Data
@AllArgsConstructor
public class ResultBean<T> {

    private String code;
    private String msg;
    private T data;
}
