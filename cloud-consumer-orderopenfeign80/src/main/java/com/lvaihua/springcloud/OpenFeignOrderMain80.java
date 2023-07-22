package com.lvaihua.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients // 启动feign功能
public class OpenFeignOrderMain80
{
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignOrderMain80.class,args);
    }
}
