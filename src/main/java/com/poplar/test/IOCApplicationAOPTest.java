package com.poplar.test;

import com.poplar.aop.Calculator;
import com.poplar.config.AopConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Create BY poplar ON 2020/4/17
 */
public class IOCApplicationAOPTest {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        Calculator calculator = applicationContext.getBean(Calculator.class);
        calculator.add(1000, 900);
    }
}
