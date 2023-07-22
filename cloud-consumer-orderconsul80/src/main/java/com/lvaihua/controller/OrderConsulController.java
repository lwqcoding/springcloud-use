package com.lvaihua.controller;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * ClassName:OrderConsulController
 * Package:com.lvaihua.controller
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/21  1:07
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderConsulController {

    // consul暴露的服务提供者的名称
    public static final String URL = "http://cloud-provider-payment";

    // 注入远程调用的对象
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String orderConsul(){
        return restTemplate.getForObject(URL + "/payment/consul",String.class);
    }
}
