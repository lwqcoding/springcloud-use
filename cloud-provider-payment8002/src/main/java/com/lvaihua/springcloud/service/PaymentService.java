package com.lvaihua.springcloud.service;

import com.lvaihua.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName:PaymentService
 * Package:com.lvaihua.springcloud.service
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/19  20:14
 * @Version 1.0
 */
public interface PaymentService {

    // 插入
    int create(Payment payment);

    // 查询
    Payment getPaymentById(@Param("id") Long id);
}
