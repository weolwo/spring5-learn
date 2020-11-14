package com.poplar.config;

import com.poplar.bean.InitializingBeanAndDisposableBeanTest;
import com.poplar.bean.PostConstructAndPreDestroyTest;
import com.poplar.bean.Role;
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

    //@Bean(initMethod = "init", destroyMethod = "destroy")
    public Role role() {
        return new Role();
    }

    //@Bean
    public InitializingBeanAndDisposableBeanTest initializingBeanAndDisposableBeanTest() {
        return new InitializingBeanAndDisposableBeanTest();
    }

    //@Bean
    public PostConstructAndPreDestroyTest postConstructAndPreDestroyTest() {
        return new PostConstructAndPreDestroyTest();
    }

}
