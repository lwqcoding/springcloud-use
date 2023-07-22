package com.lvaihua.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaServer // 表示这是Eureka的服务端
public class EurekaMain7001
{
    public static void main( String[] args ) {
        SpringApplication.run(EurekaMain7001.class,args);
    }
}
