package com.poplar.config;

import com.poplar.bean.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Create BY poplar ON 2020/4/17
 */
@Configuration
@ComponentScan("com.poplar.extend")
public class ExtendConfig {

    @Bean
    public Student student() {

        return new Student();
    }

}
