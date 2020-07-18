package com.jtr.controller;

import com.jtr.entriy.CommonResult;
import com.jtr.service.ConsumerSerice;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sun.dc.pr.PRError;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
/*1：N所有的controller方法添加熔断，不过这种方法没有实现业务代码分离
*
*    因为熔断方法是根据参数类表来找到方法的，所以全局配置的熔断方法最好是参数列表为空
*    或者所有的方法的参数都要相同
*
*    熔断的方法和调用的方法的参数类表要相同
* */
@DefaultProperties(defaultFallback ="factor_timeout")

public class ConsumerController {
    @Resource
    private ConsumerSerice consumerSerice;
    @GetMapping("/comsumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
         return consumerSerice.getPaymentById(id);
    }
    @GetMapping(value = "/comsumer/payment/fegin/timeout")
    public String timeout(){
        return consumerSerice.timeout();
    }

 /*   @HystrixCommand(fallbackMethod = "fackFactor_TIMEOUT",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")

    })*/
    @HystrixCommand  //没有设置具体的方法就采用全局配置的
    @GetMapping("/comsumer/payment/fackball/{id}")
    public String fackball(@PathVariable("id") Integer id){
        consumerSerice.fackball(id);
        return "这是消费者服务模块"+Thread.currentThread().getName()+"T_T"+"服务调用成功";
    }
    public String fackFactor_TIMEOUT(Integer id){
        return Thread.currentThread().getName()+"调用服务失败"+"给你返回合适的值";
    }
    /*全局配置，熔断的方法*/
    public String factor_timeout(){
        return Thread.currentThread().getName()+"调用服务失败"+"给你返回合适的值";
    }
}
