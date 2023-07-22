package com.lvaihua.springcloud.controller;

import com.lvaihua.springcloud.service.OrderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName:OrderHystrixController
 * Package:com.lvaihua.springcloud.controller
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/22  4:35
 * @Version 1.0
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "global_hystrix_handler") // 全局兜底
public class OrderHystrixController {

    @Resource
    private OrderHystrixService orderHystrixService;

    // 正常
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentHystrix_ok(@PathVariable("id") Long id){
        return orderHystrixService.paymentHystrix_ok(id);
    }

    // 延时
    @HystrixCommand(fallbackMethod = "paymentHystrix_timeout_Handler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    }) // 超过自身限，则做自身降级处理
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentHystrix_timeout(@PathVariable("id") Long id){
        int i = 10 / 0;
        return orderHystrixService.paymentHystrix_timeout(id);
    }
    public String paymentHystrix_timeout_Handler(@PathVariable("id") Long id){
        return "我是消费者80，对方支付系统繁忙，请稍后再点击" + "\t" + "┭┮﹏┭┮";
    }

    public String global_hystrix_handler(){
        return "全局兜底，系统错误，或运行错误！" + "\t" + "┭┮﹏┭┮";
    }
}
