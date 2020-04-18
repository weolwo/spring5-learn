package com.poplar.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Create BY poplar ON 2020/4/16
 */
@Component
public class Apple {
    public Apple() {
        System.out.println("apple Constructor");
    }

    @PostConstruct
    public void init(){
        System.out.println("对象创建后调用了我");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("对象销毁时调用了我");
    }
}
