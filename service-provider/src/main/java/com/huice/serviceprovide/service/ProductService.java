package com.huice.serviceprovide.service;

import com.huice.serviceprovide.pojo.Product;

public interface ProductService {
    Product findByPid(Integer pid);
}
