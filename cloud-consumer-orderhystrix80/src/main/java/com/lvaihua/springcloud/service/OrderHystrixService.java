package com.lvaihua.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName:OrderHystrixService
 * Package:com.lvaihua.springcloud.service
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/22  4:28
 * @Version 1.0
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = OrderFallbackService.class) // 指明 调用哪个服务提供者实例
public interface OrderHystrixService {

    // 正常
    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentHystrix_ok(@PathVariable("id") Long id);

    // 延时
    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentHystrix_timeout(@PathVariable("id") Long id);

}
