package com.lvaihua.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * ClassName:PaymentService
 * Package:com.lvaihua.springcloud.service
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/22  0:05
 * @Version 1.0
 */
@Service
public class PaymentService {

    // 正常
    public String paymentHytrix_OK(Long id){
        String result = "线程池：" + Thread.currentThread().getName() + "\t" + "paymentHytrix_OK,id = " + id + "^_^";
        return result;
    }



    // 延时
    @HystrixCommand(fallbackMethod = "paymentHystrix_TIMEOUT_Handler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    }) // 3秒后无回应则执行fallbackMethod 进行降级兜底
    public String paymentHystrix_TIMEOUT(Long id){
//        int i = 10 / 0 ;
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }

        String result = "线程池：" + Thread.currentThread().getName() + "\t" + "paymentHystrix_TIMEOUT,id = " + id + "^_^";
        return result;
    }

    public String paymentHystrix_TIMEOUT_Handler(Long id){
        String result = "线程池：" + Thread.currentThread().getName() + "\t" + "系统繁忙，请稍后再试！,id = " + id + "┭┮﹏┭┮";
        return result;
    }


    // 服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallBack", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), // 失败率到达多少后熔断
    })
    public String paymentCircuitBreaker(@PathVariable("id") Long id){
        if (id < 0){
            throw new RuntimeException("id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号 =" + serialNumber;
    }

    public String paymentCircuitBreakerFallBack(Long id){
        return "id不能为负数，不信我就o(╥﹏╥)o";
    }

}
