package com.jtr.serviceImp;

import com.jtr.entriy.Dept;
import com.jtr.entriy.Payment;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: lihuizhi
 * @date: 2020/7/17:21:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class PaymentServiceImplTest {
   @Autowired
   private PaymentTrans paymentTrans;
    @Test
    void create() {
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

    }

    @Test
    void getPaymentById() {
    }
}