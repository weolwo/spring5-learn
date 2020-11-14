package com.poplar.config;

import com.poplar.bean.Fruit;
import com.poplar.bean.PostConstructAndPreDestroyTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Create BY poplar ON 2020/4/16
 */
@Configuration
@ComponentScan(basePackages = "com.poplar.bean")
public class AutoConfig {

    @Bean
    public Fruit fruit(PostConstructAndPreDestroyTest apple) {
        Fruit fruit = new Fruit();
        fruit.setApple(apple);
        System.out.println(apple);
        return fruit;
    }
}
