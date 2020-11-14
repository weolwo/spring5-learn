package com.poplar.test;

/**
 * Create BY poplar ON 2020/11/14
 */
public class Test {
     private static final String KEY = "id";
    /**皇冠key的数量*/
    private static final String KEY_LENGTH = ",2,3,";
    public static void main(String[] args) {
        String[] keys = KEY.split(",");
        //判断key的长度。
        if (KEY_LENGTH.contains(","+ keys.length +",")){
            System.out.println("----------");
        }
    }
}
