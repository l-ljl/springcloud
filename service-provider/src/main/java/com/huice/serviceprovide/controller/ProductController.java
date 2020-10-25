package com.huice.serviceprovide.controller;

import com.huice.serviceprovide.pojo.Product;
import com.huice.serviceprovide.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provide/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/{pid}")
    public Product findByPid(@PathVariable Integer pid) {
        return productService.findByPid(pid);

    }
}
