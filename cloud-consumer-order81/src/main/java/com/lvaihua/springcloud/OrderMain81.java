package com.lvaihua.springcloud;

import com.lvaihua.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient  // 表示这是一个Eureka的cli端
@RibbonClient(name = "CLOUD-PROVIDER-SERVICE",configuration = MySelfRule.class)
public class OrderMain81
{
    public static void main(String[] args) {
        SpringApplication.run(OrderMain81.class,args);
    }
}
