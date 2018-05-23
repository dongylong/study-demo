package com.spring.aop;

import com.spring.aop.annotation.Action;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author dongyl
 * @date 14:12 5/15/18
 * @project study-demo
 */
//声明一个切面
@Aspect
//让此切面成为Spring容器管理的Bean
@Component
public class LogAspect {

    //注解声明切点
    @Pointcut("@annotation(com.spring.aop.annotation.Action)")
    public void annotationPorinCut(){

    }

    //注解声明一个建言，并使用@Pointcut定义的切点
    @After("annotationPorinCut()")
    public void after(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("actionName = " +action.name());
    }

    //注解声明一个建言，此建言直接使用
    @Before("execution(* com.spring.aop.service.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("method = " +method.getName());
    }
}
