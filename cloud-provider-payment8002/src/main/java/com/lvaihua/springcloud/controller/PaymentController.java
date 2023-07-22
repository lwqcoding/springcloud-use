package com.lvaihua.springcloud.controller;

import com.lvaihua.springcloud.entities.CommonResp;
import com.lvaihua.springcloud.entities.Payment;
import com.lvaihua.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * ClassName:PaymentController
 * Package:com.lvaihua.springcloud.controller
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/19  20:18
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    // 注入service
    @Resource
    private PaymentService paymentService;

    // 读取配置文件的端口号
    @Value("${server.port}")
    private String serverPort;

    // 注入服务发现
    @Resource
    private DiscoveryClient discoveryClient;

    // 插入接口
    @PostMapping("/payment/save")
    public CommonResp create(@RequestBody Payment payment){
        int count = paymentService.create(payment);
        log.info("插入结果：" + count);

        if (count > 0){// 插入成功
            return new CommonResp(200,"数据插入成功,serverPort:" + serverPort,count);
        }else {
            return new CommonResp(500,"数据插入失败",null);
        }
    }

    // 查询接口
    @GetMapping("/payment/get/{id}")
    public CommonResp<Payment> getPaymentById(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果：" + payment);
        if (payment != null){
            return new CommonResp<>(200,"数据查询成功,serverPort" + serverPort,payment);
        }else {
            return new CommonResp<>(500,"数据查询失败",null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            // 获取注册中心的服务信息
            log.info("service:" + service);
        }

        // 获取Eureka某名称下的实例的信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        for (ServiceInstance instance : instances) {
            // 获取服务名称、端口、ip
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }

    // 返回端口
    @GetMapping( "/payment/lb")
    public String getPaymentLb(){
        return serverPort;
    }

    // 模拟openfeign超时
    @GetMapping("/payment/feign/timeout")
    public String openFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e){
            e.printStackTrace();
        }
        return serverPort; // 3秒后才返回端口号
    }
}
