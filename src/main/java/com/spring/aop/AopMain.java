package com.spring.aop;

import com.spring.aop.service.DemoAnnotationService;
import com.spring.aop.service.DemoMethodService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author dongyl
 * @date 15:04 5/15/18
 * @project study-demo
 */
public class AopMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);
        demoAnnotationService.add();
        demoMethodService.add();
        context.close();
    }
}
