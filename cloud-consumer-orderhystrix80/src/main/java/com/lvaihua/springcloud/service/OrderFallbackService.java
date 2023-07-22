package com.lvaihua.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * ClassName:OrderFallbackService
 * Package:com.lvaihua.springcloud.service
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/22  6:06
 * @Version 1.0
 */
@Component
public class OrderFallbackService implements OrderHystrixService {

    @Override
    public String paymentHystrix_ok(Long id) {
        return "系统错误！！！！！！！！！" + "\t" + "o(╥﹏╥)o";
    }

    @Override
    public String paymentHystrix_timeout(Long id) {
        return "系统错误！！！！！！！！！" + "\t" + "o(╥﹏╥)o";
    }


}
