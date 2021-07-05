package com.mall.mallproductservice.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.peace.api.ProductService;
import com.peace.entity.Product;
import com.peace.entity.ProductDesc;
import com.peace.mapper.ProductDescMapper;
import com.peace.mapper.ProductMapper;
import com.peace.vo.PageInfoVO;
import com.peace.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author peace
 * @since 2021-06-15
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    private ProductDescMapper productDescMapper;

    @Override
    public Product getProductById(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public PageInfo<Product> page(Integer pageIndex, Integer pageSize) {
        //1.设置分页信息
        PageHelper.startPage(pageIndex,pageSize);
        //2.获取到集合信息,带limit
//        List<Product> products = baseMapper.selectList(null);
        List<Product> products = this.list(null);
        //3.返回分页对象
        PageInfo<Product> pageInfo = new PageInfo<>(products,3);
        return pageInfo;
    }

    @Override
    public PageInfoVO pageList(Integer pageIndex, Integer pageSize) {
        PageInfoVO pageInfoVo = new PageInfoVO();
        //创建page对象
        Page<Product> pageTeacher = new Page<Product>(pageIndex,pageSize);
        //构建查询条件(多条件组合查询)
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("flag","1");
        //排序
        queryWrapper.orderByDesc("create_time");
        //调用方法实现分页
        this.page(pageTeacher,queryWrapper);

        //总记录数
        long total = pageTeacher.getTotal();
        //数据集合
        List<Product> records = pageTeacher.getRecords();
        pageInfoVo.setPageNum(pageTeacher.getCurrent());
        //获取总页数
        pageInfoVo.setPageTotal(total%pageSize == 0 ? total/pageSize : total/pageSize+1);
        pageInfoVo.setTotal(total);
        pageInfoVo.setRows(records);
//        Map map = new HashMap();
//        map.put("total",total);
//        map.put("rows",records);
        return pageInfoVo;
    }

    @Override
    @Transactional
    public Long add(ProductVO productVO) {
        //1.添加商品的基本信息
        baseMapper.insert(productVO.getProduct());
        //2.添加商品描述信息
        ProductDesc productDesc = new ProductDesc();
        productDesc.setProductId(productVO.getProduct().getId());
        productDesc.setProductDesc(productVO.getProductDesc());
        productDescMapper.insert(productDesc);
        System.out.println(productVO.getProduct().getId());
        return productVO.getProduct().getId();
    }


}
