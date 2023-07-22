package com.lvaihua.springcloud.controller;

import com.lvaihua.springcloud.entities.CommonResp;
import com.lvaihua.springcloud.entities.Payment;
import com.lvaihua.springcloud.lb.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * ClassName:OrderController
 * Package:com.lvaihua.springcloud.controller
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/19  23:10
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderController {

    // 定义远程接口的url
//    public static final String PAYMENT_URL = "http://localhost:8001";  单机版
    public static final String PAYMENT_URL = "http://CLOUD-PROVIDER-SERVICE"; // 集群版


    // 注入用于远程调用接口的restTemplate
    @Resource
    private RestTemplate restTemplate;

    // 注入自写轮询接口
    @Resource
    private LoadBalance loadBalance;
    // 注入客户端服务发现接口
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/save") // 浏览器只能发送get请求
    public CommonResp<Payment> create(Payment payment){
        // restTemplate底层发post请求远程调用paymant的接口
        return restTemplate.postForObject(PAYMENT_URL + "/payment/save",payment,CommonResp.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResp<Payment> getPayment(@PathVariable("id") Long id){
        // restTemplate底层发get请求远程调用payment接口
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id,CommonResp.class);
    }

    // 自写Ribbon轮询
    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLb(){
        // 获取eureka上服务提供者暴露的实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        // 判断是否有暴露的实例
        if (instances == null || instances.size() < 0){
            return null;
        }
        // 将实例放入接口用来轮询出服务提供者下标
        ServiceInstance serviceInstance = loadBalance.instances(instances);
        URI uri = serviceInstance.getUri();
        // 利用 restTemplate 实现远程调用
        return restTemplate.getForObject(uri + "/payment/lb",String.class);

    }
}
