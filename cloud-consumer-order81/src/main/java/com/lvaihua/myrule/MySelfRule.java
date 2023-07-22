package com.lvaihua.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:MySelfRule
 * Package:com.lvaihua.myrule
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/21  14:46
 * @Version 1.0
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule(); // 定义为随机算法规则
    }
}
