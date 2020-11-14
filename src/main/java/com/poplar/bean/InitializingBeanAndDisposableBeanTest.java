package com.poplar.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Create BY poplar ON 2020/4/15
 */
public class InitializingBeanAndDisposableBeanTest implements InitializingBean, DisposableBean {

    public InitializingBeanAndDisposableBeanTest() {
        System.out.println("InitializingBeanAndDisposableBeanTest Constructor");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBeanAndDisposableBeanTest afterPropertiesSet..");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("InitializingBeanAndDisposableBeanTest destroy");
    }
}
