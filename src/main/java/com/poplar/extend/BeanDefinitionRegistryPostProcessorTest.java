package com.poplar.extend;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Create BY poplar ON 2020/11/14
 */
@Component
public class BeanDefinitionRegistryPostProcessorTest implements BeanDefinitionRegistryPostProcessor {

    /**
     * 执行时机，所有的bean信息将要被加载，但是还没有任何bean还未创建 ,优先于postProcessBeanFactory执行
     * BeanDefinitionRegistry  bean定义信息的保存中心，以后BeanFactory就是按照里面的bean定义信息创建实例的
     * 也可以在这儿注册bean
     * @param registry
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("BeanDefinitionRegistryPostProcessorTest--->postProcessBeanDefinitionRegistry");
        System.out.println(registry.getBeanDefinitionCount());
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            System.out.println(definitionName);
        }

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanDefinitionRegistryPostProcessorTest--->postProcessBeanFactory");
        System.out.println(beanFactory.getBeanDefinitionCount());
    }
}
