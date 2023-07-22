package com.lvaihua.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * ClassName:OrderZKController
 * Package:com.lvaihua.springcloud.controller
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/20  22:51
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderZKController {

    // 定义zookeeper暴露出来的服务提供者接口
    public static final String URL = "http://cloud-provider-payment";

    // 注入远程调用对象
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String paymentInfo(){
        return restTemplate.getForObject(URL + "/payment/zk",String.class );
    }
}
