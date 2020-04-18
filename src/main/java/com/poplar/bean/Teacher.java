package com.poplar.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Create BY poplar ON 2020/4/15
 */
public class Teacher implements InitializingBean, DisposableBean {

    public Teacher() {
        System.out.println("Teacher Constructor");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Teacher afterPropertiesSet..");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Teacher destroy");
    }
}
