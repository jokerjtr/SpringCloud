package com.jtr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author: lihuizhi
 * @date: 2020/7/18:18:40
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard

public class HystrixBashBorad {
    public static void main(String[] args) {
        SpringApplication.run(HystrixBashBorad.class,args);
    }
}
