package com.poplar.bean;

import lombok.Data;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.util.StringValueResolver;

/**
 * Create BY poplar ON 2020/4/16
 * 实现 ApplicationContextAware 该接口将容器注入到组件中
 */
@Data
public class XXXAwareTest implements EmbeddedValueResolverAware, EnvironmentAware {

    private String name;
    private Environment environment;

    //解析字符串
    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        System.out.println(resolver.resolveStringValue("setEmbeddedValueResolver ${os.name} #{10*10} ...XXXAwareTest"));
    }

    //设置环境信息
    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("setEnvironment 设置环境信息...XXXAwareTest");
        this.environment = environment;
    }
}
