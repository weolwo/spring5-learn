package com.poplar.test;

import com.poplar.config.ExtendConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Create BY poplar ON 2020/11/14
 */
public class ExtendTest {

    /**
     * spring整个执行过程：
     * 1.首先创建一个容器 AbstractRefreshableApplicationContext.refreshBeanFactory()
     * 2.AnnotationConfigApplicationContext.scan(String... basePackages)扫描标有
     * 3.
     */

    @Test
    public void test1() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtendConfig.class);
        applicationContext.close();
    }
}
