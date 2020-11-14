package com.poplar.extend;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * Create BY poplar ON 2020/11/14
 * BeanFactoryPostProcessor 接口方法执行时机测试
 */
@Component
public class BeanFactoryPostProcessorTest implements BeanFactoryPostProcessor {

    /**
     * 执行时机 所有的bean的定义信息已经加载完成，但是还未创建任何的bean实例
     *
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessorTest--->postProcessBeanFactory");
        System.out.println("已经定义的bean数量 = "+beanFactory.getBeanDefinitionCount());
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            System.out.println(definitionName);
        }
    }
}
