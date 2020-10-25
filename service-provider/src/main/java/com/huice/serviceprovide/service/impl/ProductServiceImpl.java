package com.huice.serviceprovide.service.impl;

import com.huice.serviceprovide.pojo.Product;
import com.huice.serviceprovide.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product findByPid(Integer pid) {
        return new Product(pid, "小米手机", 4999);
    }
}
