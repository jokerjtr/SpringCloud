package com.jtr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lihuizhi
 * @date: 2020/8/22:15:28
 */
@RestController
@RefreshScope //OST curl -X POST "http://localhost:3345/actuator/refresh"
public class ClientController {

    @Value("${config.info}")
    private  String info;
    @GetMapping("/getMessage")
    public String getMessage(){
        return  info;
    }

}
