package com.jtr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: lihuizhi
 * @date: 2020/8/21:16:11
 */
@SpringBootApplication
@EnableEurekaClient
public class gatewya {
    public static void main(String[] args) {
        SpringApplication.run(gatewya.class,args);
    }
}
