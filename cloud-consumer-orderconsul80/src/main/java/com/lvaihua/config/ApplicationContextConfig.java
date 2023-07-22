package com.lvaihua.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName:ApplicationContextConfig
 * Package:com.lvaihua.config
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/21  1:06
 * @Version 1.0
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced // 实现负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
