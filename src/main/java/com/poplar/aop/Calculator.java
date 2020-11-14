package com.poplar.aop;

/**
 * Create BY poplar ON 2020/4/17
 */

public class Calculator {

    public Integer add(int x, int y) {
        System.out.println("add 运行。。。");
        return x + y;
    }

    public Integer div(int x, int y) {
        System.out.println("div 运行。。。");
        return x / y;
    }
}
