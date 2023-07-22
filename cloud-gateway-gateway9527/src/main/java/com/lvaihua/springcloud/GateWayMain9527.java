package com.lvaihua.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.xml.crypto.Data;

/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient // 表示以client端注册到eureka中
public class GateWayMain9527
{
    public static void main( String[] args ) {
        SpringApplication.run(GateWayMain9527.class,args);
    }
}
