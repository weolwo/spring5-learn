package com.poplar.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Create BY poplar ON 2020/11/17
 */
public class XmlApplicationTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        context.close();
    }
}
