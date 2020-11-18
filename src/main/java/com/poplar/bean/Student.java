package com.poplar.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create BY poplar ON 2020/4/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;

    private String name;

    private String gender;


}
