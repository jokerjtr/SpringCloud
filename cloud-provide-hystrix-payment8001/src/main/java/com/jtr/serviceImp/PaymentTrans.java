package com.jtr.serviceImp;

import com.jtr.entriy.Dept;
import com.jtr.entriy.Payment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author: lihuizhi
 * @date: 2020/7/17:21:57
 */
@Service
public class PaymentTrans {
    @Resource
    private DeptTrans deptTrans;
    @Resource
    private PaymentServiceImpl paymentService;
    @Transactional(rollbackFor = Exception.class)
    public void trans(Dept dept, Payment payment){
       deptTrans.inserdel(dept);
        System.out.println("++++++++++++++++++++++++++");

        paymentService.create(payment);
    }
}
