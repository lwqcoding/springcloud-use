package com.lvaihua.springcloud.mapper;

import com.lvaihua.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName:PaymenMapper
 * Package:com.lvaihua.springcloud.mapper
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/19  20:06
 * @Version 1.0
 */
@Mapper
public interface PaymentMapper {

    // 进行插入
    int create(Payment payment);

    // 进行查询
    Payment getPaymentById(@Param("id") Long id);
}
