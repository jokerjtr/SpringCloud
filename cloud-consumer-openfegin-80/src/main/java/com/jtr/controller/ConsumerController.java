package com.jtr.controller;

import com.jtr.entriy.CommonResult;
import com.jtr.service.ConsumerSerice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sun.dc.pr.PRError;

import javax.annotation.Resource;

@RestController
public class ConsumerController {
    @Resource
    private ConsumerSerice consumerSerice;
    @GetMapping("/comsumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
         return consumerSerice.getPaymentById(id);
    }
}
