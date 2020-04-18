package com.poplar.config;

import com.poplar.aop.Calculator;
import com.poplar.aop.LogAspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Create BY poplar ON 2020/4/17
 * @EnableAspectJAutoProxy 开启aop
 */
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }

    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }
}
