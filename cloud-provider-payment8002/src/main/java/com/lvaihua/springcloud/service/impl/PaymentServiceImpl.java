package com.lvaihua.springcloud.service.impl;

import com.lvaihua.springcloud.entities.Payment;
import com.lvaihua.springcloud.mapper.PaymentMapper;
import com.lvaihua.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ClassName:PaymentServiceImpl
 * Package:com.lvaihua.springcloud.service.impl
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/19  20:15
 * @Version 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    // 注入mapper
    @Resource
    private PaymentMapper paymentMapper;


    @Override
    public int create(Payment payment) {
        // 插入
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        // 查询
        return paymentMapper.getPaymentById(id);
    }
}
