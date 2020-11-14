package com.poplar.condition;

import com.poplar.bean.InitializingBeanAndDisposableBeanTest;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Create BY poplar ON 2020/4/15
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        if (registry.containsBeanDefinition("com.poplar.condition.WindowsCondition")) {
            BeanDefinition beanDefinition = new RootBeanDefinition(InitializingBeanAndDisposableBeanTest.class);
            registry.registerBeanDefinition("teacher", beanDefinition);
        }
    }
}
