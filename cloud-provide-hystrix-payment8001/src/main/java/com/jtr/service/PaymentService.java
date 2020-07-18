package com.jtr.service;

import com.jtr.entriy.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
    public String paymentCircuitBreaker(Integer id);
    public String paymentCircuitBreaker_fallback(Integer id);
}



