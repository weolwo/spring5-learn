package com.poplar.bean;

import lombok.Data;

/**
 * Create BY poplar ON 2020/4/15
 */
@Data
public class Role {
    private String name;

    public void init(){
        System.out.println("对象初始化");
    }

    public void destroy(){
        System.out.println("对象销毁");
    }
}
