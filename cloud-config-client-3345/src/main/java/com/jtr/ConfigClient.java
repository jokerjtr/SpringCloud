package com.jtr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: lihuizhi
 * @date: 2020/8/22:15:27
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClient {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient.class,args);
    }
}
