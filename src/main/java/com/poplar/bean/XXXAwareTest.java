package com.poplar.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * Create BY poplar ON 2020/4/16
 * 实现 ApplicationContextAware 该接口将容器注入到组件中
 */
@Component
public class XXXAwareTest implements EmbeddedValueResolverAware, ApplicationContextAware, BeanNameAware {

    ApplicationContext applicationContext;

    @Override
    public void setBeanName(String name) {
        System.out.println("bean的名字==>" + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext.getBean(XXXAwareTest.class));
        System.out.println(applicationContext);
        //把得到的spring容器保存起来
        this.applicationContext = applicationContext;
    }

    //解析字符串
    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        System.out.println(resolver.resolveStringValue("${os.name} #{10*10}"));
    }
}
