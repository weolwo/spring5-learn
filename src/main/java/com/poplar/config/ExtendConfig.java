package com.poplar.config;

import com.poplar.bean.XXXAwareTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create BY poplar ON 2020/4/17
 */
@Configuration
public class ExtendConfig {

    @Bean
    public XXXAwareTest xXXAwareTest() {
        XXXAwareTest xxxAwareTest = new XXXAwareTest();
        xxxAwareTest.setName("猫花");
        return xxxAwareTest;
    }

}
