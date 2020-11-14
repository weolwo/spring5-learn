package com.poplar.test;

import com.poplar.config.ExtendConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Create BY poplar ON 2020/11/14
 */
public class ExtendTest {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtendConfig.class);
        applicationContext.close();
    }
}
