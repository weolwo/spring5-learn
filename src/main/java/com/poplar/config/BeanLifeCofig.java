package com.poplar.config;

import com.poplar.bean.Apple;
import com.poplar.bean.Role;
import com.poplar.bean.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Create BY poplar ON 2020/4/16
 */
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.poplar.bean")
public class BeanLifeCofig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Role role() {
        return new Role();
    }

    @Bean
    public Teacher teacher() {
        return new Teacher();
    }

    @Bean
    public Apple apple() {
        return new Apple();
    }
}
