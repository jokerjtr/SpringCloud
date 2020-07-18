package com.jtr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class ProvidePayMent {
    public static void main(String[] args) {
        SpringApplication.run(ProvidePayMent.class,args);
    }

}
