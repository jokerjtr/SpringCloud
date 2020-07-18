package com.jtr.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;



/**
 * @author: lihuizhi
 * @date: 2020/7/18:10:56
 */
@Component
public class FeginLog {
    /*
    *   NONE, 默认不显示任何信息
        BASIC, 记录请求方法，url，响应状态码及执行时间
        HEADERS,  除了basic，还有请求和响应头
        FULL; 除了headers还有 请求和响应的正文和数据
    *
    * */
    @Bean
    Logger.Level feginLoglevel(){
         return Logger.Level.FULL;

    }}
