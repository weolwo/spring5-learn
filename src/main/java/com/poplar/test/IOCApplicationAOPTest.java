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
        //calculator这个对象不要自己创建，而是要用容器中的calculator
        Calculator calculator = applicationContext.getBean(Calculator.class);
        System.out.println(calculator.add(1000, 900));
        System.out.println(calculator.div(1000, 0));
    }
}
