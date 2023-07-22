package com.lvaihua.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName:ApplicationContextConfig
 * Package:com.lvaihua.springcloud.config
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/19  23:08
 * @Version 1.0
 */

@Configuration // 表示这是一个配置类
public class ApplicationContextConfig {

    @Bean // 让spring容器扫描到这个对象
//    @LoadBalanced // 赋予RestTemplate负载均衡的能力
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
