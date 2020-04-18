package com.poplar.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Create BY poplar ON 2020/4/15
 */
public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        System.out.println(context.getEnvironment().getProperty("os.name"));
        return context.getEnvironment().getProperty("os.name").contains("Windows");
    }
}
