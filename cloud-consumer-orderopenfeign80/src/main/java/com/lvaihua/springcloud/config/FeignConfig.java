package com.lvaihua.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:FeignConfig
 * Package:com.lvaihua.springcloud.config
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/21  21:38
 * @Version 1.0
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL; // 详细日志
    }
}
