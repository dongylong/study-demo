package com.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author dongyl
 * @date 15:01 5/15/18
 * @project study-demo
 */
@Configuration
@ComponentScan("com.spring.aop")
//开启spring对AspectJ代理的支持
@EnableAspectJAutoProxy
public class AopConfig {

}
