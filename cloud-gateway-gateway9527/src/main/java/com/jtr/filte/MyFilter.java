package com.jtr.filte;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;


/**
 * @author: lihuizhi
 * @date: 2020/8/21:18:48
 */
@Component
@Slf4j
public class MyFilter implements GlobalFilter, Ordered {

    /*过滤器*/
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
       log.info("你已经进入了自定义的过滤器中========"+new Date());
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (username==null){
            log.info("你的用户名非法，不能进行访问");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return  exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }
    /*优先级，值越小优先级越高*/
    @Override
    public int getOrder() {
        return 0;
    }
}
