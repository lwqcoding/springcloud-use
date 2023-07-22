package com.lvaihua.springcloud.controller;

import com.lvaihua.springcloud.entities.CommonResp;
import com.lvaihua.springcloud.entities.Payment;
import com.lvaihua.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName:OpenFeignOrderController
 * Package:com.lvaihua.springcloud.controller
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/21  18:03
 * @Version 1.0
 */
@RestController
@Slf4j
public class OpenFeignOrderController {

    // 注入feign接口
    @Resource
    private PaymentService paymentService;

    @GetMapping( "/consumer/payment/get/{id}")
    public CommonResp<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentService.getPaymentById(id);
    }

    @GetMapping( "/consumer/payment/feign/timeout")
    public String openFeignTimeOut(){
        // openfeign-ribbon  客户端一般默认等待1秒钟
        return paymentService.openFeignTimeOut();
    }
}
