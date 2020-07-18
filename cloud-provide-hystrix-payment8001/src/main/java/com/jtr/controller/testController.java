package com.jtr.controller;

import com.jtr.entriy.Dept;
import com.jtr.entriy.Payment;
import com.jtr.serviceImp.PaymentTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lihuizhi
 * @date: 2020/7/17:22:28
 */
@RestController
public class testController {
    @Autowired
    private PaymentTrans paymentTrans;
    @GetMapping("/totest")
    String create() {
        Dept dept=new Dept();
        dept.setDeptno(3);
        dept.setDname("你好");
        dept.setDbsources("sdf");
        Payment payment=new Payment();
        payment.setId(Long.valueOf(2));
        payment.setSerial("12");

        new Thread(()->{
            paymentTrans.trans(dept,payment);
        },"A").start();
        new Thread(()->{
            paymentTrans.trans(dept,payment);
        },"B").start();
        new Thread(()->{
            paymentTrans.trans(dept,payment);
        },"C").start();
           return "hello,world";
    }

}
