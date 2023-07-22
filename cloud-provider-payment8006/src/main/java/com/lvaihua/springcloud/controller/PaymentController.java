package com.lvaihua.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * ClassName:PaymentController
 * Package:com.lvaihua.springcloud.controller
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/21  0:53
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    // 读取配置文件的端口号
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/consul")
    public String getConsul(){
        return "Spring Cloud and Consul:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
