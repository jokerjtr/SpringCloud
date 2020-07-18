package com.jtr.service;

import com.jtr.entriy.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface ConsumerSerice {
    @GetMapping(value="/payment/get/{id}")
   public CommonResult getPaymentById(@PathVariable("id") Long id);
    @GetMapping(value = "/payment/fegin/timeout")
    public String timeout();
}
