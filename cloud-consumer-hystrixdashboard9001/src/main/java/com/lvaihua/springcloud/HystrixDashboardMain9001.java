package com.lvaihua.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableHystrixDashboard // 开始实时监控仪表盘
public class HystrixDashboardMain9001
{
    public static void main( String[] args ) {
        SpringApplication.run(HystrixDashboardMain9001.class,args);
    }
}
