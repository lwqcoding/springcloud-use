package com.lvaihua.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.WebEndpoint;

/**
 * ClassName:ApplicationContextConfig
 * Package:com.lvaihua.springcloud.config
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/20  22:49
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
