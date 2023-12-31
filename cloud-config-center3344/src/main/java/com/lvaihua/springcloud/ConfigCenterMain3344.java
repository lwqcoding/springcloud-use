package com.lvaihua.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableConfigServer // 激活配置中心
public class ConfigCenterMain3344
{
    public static void main( String[] args ) {
        SpringApplication.run(ConfigCenterMain3344.class,args);
    }
}
