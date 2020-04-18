package com.poplar.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Create BY poplar ON 2020/4/16
 */
@Data
@Component
public class Potato {

    @Value("${potato.name}")
    private String name;
}
