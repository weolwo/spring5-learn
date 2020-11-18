package com.poplar.bean;

import lombok.Data;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * Create BY poplar ON 2020/11/17
 */
@Data
public class Orange implements EnvironmentAware {

    private Apple apple;

    private String name;

    Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("Orange.setEnvironment()");
        this.environment = environment;
    }
}
