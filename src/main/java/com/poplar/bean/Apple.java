package com.poplar.bean;

import lombok.Data;

/**
 * Create BY poplar ON 2020/11/17
 * 模拟对象的循环引用
 */
@Data
public class Apple {

    private Orange orange;

    private String name;
}
