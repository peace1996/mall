package com.mall.mallindex.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.peace.api.ProductTypeService;
import com.peace.entity.ProductType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("index")
public class IndexController { //p142,没有前端代码
    @Reference
    private ProductTypeService productTypeService;

    @RequestMapping("showIndex")
    public String showIndex(Model model){
        //1.获取type数据
        List<ProductType> list = productTypeService.list(null);
        model.addAttribute("list",list);
        return "index";
    }
}
