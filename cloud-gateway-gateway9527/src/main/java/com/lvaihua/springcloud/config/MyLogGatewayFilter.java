package com.lvaihua.springcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * ClassName:MyLogGatewayFilter
 * Package:com.lvaihua.springcloud.config
 * Description:
 *
 * @Author 吕大帅
 * @Create 2023/7/22  20:23
 * @Version 1.0
 */
@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("come in MyLogGatewayFilter : " + new Date());

        // 获取请求的参数名
        String name = exchange.getRequest().getQueryParams().getFirst("name");
        if (name == null){
            log.info("用户名为null ，非法用户，我哭给你看o(╥﹏╥)o");
            // 设置响应返回码
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();  // 返回响应返回码
        }
        // 不为空则进行第二个链路Filter【以此类推】
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() { // 数字越小，Filter过滤器越高
        return 0;
    }
}
