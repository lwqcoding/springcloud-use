package com.lvaihua.springcloud.service;

import com.lvaihua.springcloud.entities.CommonResp;
import com.lvaihua.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName:PaymentService
 * Package:com.lvaihua.springcloud.service
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/21  18:05
 * @Version 1.0
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-SERVICE") // 使用feign功能[指明调用哪个服务提供者实例的接口]
public interface PaymentService {

    // 直接调用服务提供者的接口
    @GetMapping("/payment/get/{id}")
    CommonResp<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    String openFeignTimeOut();
}
