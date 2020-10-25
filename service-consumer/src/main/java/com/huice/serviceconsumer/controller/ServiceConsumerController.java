package com.huice.serviceconsumer.controller;


import com.huice.serviceconsumer.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/consumer/product")
public class ServiceConsumerController {

    /**
     * 通过restTemplate来完成远程Restful接口的调用
     */
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("/{pid}")
    public Product findByPid(@PathVariable Integer pid) {

        /*String url = "http://62.234.57.30:8080/provide/product/"+pid;
        return restTemplate.getForObject(url, Product.class);*/

        ServiceInstance serviceInstance = discoveryClient.getInstances("service-provider").get(0);
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String url = "http://" + host + ":" + port + "/provide/product/" + pid;
        return restTemplate.getForObject(url, Product.class);

    }
}
