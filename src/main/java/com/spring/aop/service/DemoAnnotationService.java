package com.spring.aop.service;

import com.spring.aop.annotation.Action;
import org.springframework.stereotype.Service;


/**
 * @author dongyl
 * @date 14:08 5/15/18
 * @project study-demo
 */
@Service
public class DemoAnnotationService {
    @Action(name="注解拦截的add操作")
    public void add(){
        System.out.println("DemoAnnotationService.add");
    }

}
