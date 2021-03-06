package com.mall.mallcenter.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.peace.api.ProductService;
import com.peace.entity.Product;
import com.peace.vo.PageInfoVO;
import com.peace.vo.ProductVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
public class ProductController { //p133
    @Reference
    private ProductService productService;

    @RequestMapping("getProduct/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable("id") Long id){
//        productService.getById(id)
        return productService.getProductById(id);
    }

    @RequestMapping("list")
    public String list(Model model) {
        //1.获取商品数据
        List<Product> list = productService.list(null);
        model.addAttribute("list",list);
        return "product/list";
    }

    @RequestMapping("page/{pageIndex}/{pageSize}")
    public String pageList(Model model, @PathVariable("pageIndex") Integer pageIndex,
                           @PathVariable("pageSize") Integer pageSize) {
        //1.获取商品数据,分页
        PageInfo<Product> page = productService.page(pageIndex, pageSize);
        model.addAttribute("list",page);
        return "product/list";
    }

    @RequestMapping("row/{pageIndex}/{pageSize}")
    public String pageList2(Model model, @PathVariable("pageIndex") Integer pageIndex,
                           @PathVariable("pageSize") Integer pageSize) {
        PageInfoVO pageInfoVo = productService.pageList(pageIndex, pageSize);
        model.addAttribute("page",pageInfoVo);
        return "product/list";
    }
    @PostMapping("add")
    public String addProduct(ProductVO vo){
        Long newId = productService.add(vo);
        return "redirect:/product/row/1/3";
    }




}

