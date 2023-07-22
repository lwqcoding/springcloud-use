package com.lvaihua.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients // 开启Feign
@EnableHystrix // 激活 Hystrix
public class OrderHystrixMain80
{
    public static void main( String[] args ) {
        SpringApplication.run(OrderHystrixMain80.class,args);
    }
}
