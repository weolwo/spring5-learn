package com.poplar.test;

import com.poplar.bean.XXXAwareTest;
import com.poplar.config.AutoConfig;
import com.poplar.config.BeanLifeCofig;
import com.poplar.config.ConfigTest1;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Conditional;

/**
 * Create BY poplar ON 2020/4/15
 */
@Conditional(value = {})
public class IOCApplicationTest {

    @Test
    public void test1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigTest1.class);
        System.out.println(context.getBean("studentFactoryBean")); //Role(name=null)
        String[] names = context.getBeanDefinitionNames();
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanLifeCofig.class);
        String[] names = context.getBeanDefinitionNames();
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
        //容器销毁
        context.close();
    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutoConfig.class);
        System.out.println(context.getBean(XXXAwareTest.class));
        System.out.println(context);
    }
}
