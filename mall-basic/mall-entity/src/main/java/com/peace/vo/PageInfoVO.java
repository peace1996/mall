package com.peace.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageInfoVO<T> implements Serializable {
    //当前页
    private long pageNum;
    //总页数
    private long pageTotal;
    //总数量
    private long total;
    //数据对象
    private T rows;

}
