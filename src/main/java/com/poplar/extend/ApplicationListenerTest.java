package com.poplar.extend;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Create BY poplar ON 2020/11/14
 * spring 监听器测试
 */
@Component
public class ApplicationListenerTest implements ApplicationListener<ApplicationEvent> {

    //当容器发布事件后发触发
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("事件到达...." + event.toString());
    }
}
