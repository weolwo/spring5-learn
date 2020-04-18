package com.poplar.config;

import com.poplar.bean.Student;
import com.poplar.bean.StudentFactoryBean;
import com.poplar.condition.LinuxCondition;
import com.poplar.condition.MyImportBeanDefinitionRegistrar;
import com.poplar.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * Create BY poplar ON 2020/4/15
 */
@Configuration
@Import(value = {WindowsCondition.class, MyImportBeanDefinitionRegistrar.class})
public class ConfigTest1 {

    @Conditional(value = {LinuxCondition.class})
    @Bean("linus")
    public Student linus() {
        System.out.println("ioc容器创建bean...");
        return new Student(1120, "linus", "49");
    }

    @Bean
    @Scope(value = "prototype")
    public Student student() {
        System.out.println("ioc容器创建bean...");
        return new Student(1100, "猫花", "保密");
    }

    @Conditional(value = {WindowsCondition.class})
    @Bean(value = "bill")
    public Student bill() {
        System.out.println("ioc容器创建bean...");
        return new Student(1110, "bill", "63");
    }

    @Bean
    public StudentFactoryBean studentFactoryBean() {
        return new StudentFactoryBean();
    }
}
