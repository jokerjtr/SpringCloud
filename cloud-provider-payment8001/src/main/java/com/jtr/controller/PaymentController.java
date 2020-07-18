package com.jtr.controller;

import com.jtr.entriy.CommonResult;
import com.jtr.entriy.Payment;
import com.jtr.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;


    @Value("${server.port}")
    private String serverport;
    @PostMapping(value="/payment/create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        //log.info("****插入结果:" + result);

        if(result > 0){
            return  new CommonResult(200,"插入数据库成功",result);
        } else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        //log.info("****插入结果:" + payment);

        if(payment != null){
            return  new CommonResult(200,"查询成功",payment);
        } else {
            return new CommonResult(444,"没有对应记录，查询ID: " + id,null);
        }
    }
    @GetMapping(value = "/payment/getport")
    public CommonResult getPort(){
        return new CommonResult(200,"你返回的接口是"+serverport,null);
    }
    //       openfegin 超时demo
    @GetMapping(value = "/payment/fegin/timeout")
    public String timeout(){
        try {
            // openfegin 默认是1s，如果超过一秒中会报错，不会等待服务响应完成
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            return serverport;
        }
    }
    /*设置降级方法和熔断时间
    *
    * 调用方法的参数类表应该和熔断方法的参数类表相同，如果不同
    *com.netflix.hystrix.contrib.javanica.exception.FallbackDefinitionException:
    *
    * */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",
            commandProperties={
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                    value = "3000")
    }
    )
    @GetMapping(value = "/payment/fackball")
    public String fackball(Integer id){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            return Thread.currentThread().getName()+"成功完成耗时";

    }
    public String paymentInfo_TimeoutHandler(Integer id) {
        return "/(ToT)/调用支付接口超时或异常、\t" + "\t当前线程池名字" + Thread.currentThread().getName();
    }

}


