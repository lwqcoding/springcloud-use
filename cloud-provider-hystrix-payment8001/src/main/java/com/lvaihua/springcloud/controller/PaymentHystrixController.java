package com.lvaihua.springcloud.controller;

import com.lvaihua.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName:PaymentHystrixController
 * Package:com.lvaihua.springcloud.controller
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/22  0:12
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentHystrixController {


    @Resource
    private PaymentService paymentService;

    // 读取配置文件的端口号
    @Value("${server.port}")
    private String serverPort;

    // 正常
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentHystrix_ok(@PathVariable("id") Long id){
        return paymentService.paymentHytrix_OK(id) + "\t" + "serverPort = " + serverPort;
    }

    // 延时
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentHystrix_timeout(@PathVariable("id") Long id){
        return paymentService.paymentHystrix_TIMEOUT(id) + "\t" + "serverPort = " + serverPort;
    }

    // 熔断
    @GetMapping("/payment/hystrix/circuitBreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Long id){
        return paymentService.paymentCircuitBreaker(id) + " \t" + "serverPort = " + serverPort;
    }
}
