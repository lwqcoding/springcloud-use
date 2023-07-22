package com.lvaihua.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * ClassName:PaymentController
 * Package:com.lvaihua.springcloud.controller
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/20  22:24
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    // 读取配置文件的端口号
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/zk")
    public String paymentzk(){
        return "springcloud and zookeeper " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
