package com.poplar.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * Create BY poplar ON 2020/4/15
 */
public class StudentFactoryBean implements FactoryBean<Role> {
    @Override
    public Role getObject() throws Exception {
        return new Role();
    }

    @Override
    public Class<?> getObjectType() {
        return Role.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
