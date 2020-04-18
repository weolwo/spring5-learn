package com.poplar.test;

import com.poplar.config.DataSourceConfig;
import com.poplar.config.TxConfig;
import com.poplar.dao.StudentDao;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Create BY poplar ON 2020/4/16
 */
public class IOCApplicationTest2 {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("prop");
        applicationContext.register(DataSourceConfig.class);
        applicationContext.refresh();
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        StudentDao studentDao = applicationContext.getBean(StudentDao.class);
        studentDao.add();

    }
}
