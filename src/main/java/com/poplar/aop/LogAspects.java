package com.poplar.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * Create BY poplar ON 2020/4/17
 * @Aspect 表明这是易额切面类
 */
@Aspect
public class LogAspects {

    //抽取公共的切入点表达式
    @Pointcut("execution( * com.poplar.aop.Calculator.*(..))")
    public void pointCut() {
    }

    ;

    @Before("execution( * com.poplar.aop.Calculator.*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("@Before 方法名：" + joinPoint.getSignature().getName() + "，方法参数：" + Arrays.asList(joinPoint.getArgs()));
    }

    @After("pointCut()")
    public void after() {
        System.out.println("@After after");
    }

    //JoinPoint必须放在前面，否则会报error at ::0 formal unbound in pointcut
    @AfterReturning(value = "pointCut()", returning = "result")
    public void returning(JoinPoint joinPoint, Object result) {
        System.out.println("方法名" + joinPoint.getSignature().getName() + "参数" + Arrays.asList(joinPoint.getArgs()) + "@AfterReturning返回值" + result.toString());
    }

    @AfterThrowing(value = "pointCut()", throwing = "excption")
    public void throwable(Exception excption) {
        System.out.println("@AfterThrowing异常信息" + excption.getMessage());
    }
}
