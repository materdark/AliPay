package com.example.alipay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.alipay.pojo.Product;
import com.example.alipay.service.ProductService;
import com.example.alipay.mapper.ProductMapper;
import org.springframework.stereotype.Service;

/**
* @author chenz
* @description 针对表【t_product】的数据库操作Service实现
* @createDate 2024-03-03 14:15:03
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{

}




