package com.poplar.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Create BY poplar ON 2020/4/16
 * BeanPostProcessor 在bean初始化前后对bean进行操作
 *   postProcessBeforeInitialization 在bean初始化之前工作
 *   postProcessAfterInitialization  在bean初始化之后工作
 */
@Component
public class PostProcessTest implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization"+bean+"=>"+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization"+bean+"=>"+beanName);
        return bean;
    }
}
