package com.jtr.serviceImp;

import com.jtr.dao.PaymentDao;
import com.jtr.entriy.Payment;
import com.jtr.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }

}
