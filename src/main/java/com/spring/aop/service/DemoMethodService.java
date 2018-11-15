package com.spring.aop.service;

import org.springframework.stereotype.Service;

/**
 * @author dongyl
 * @date 14:08 5/15/18
 * @project study-demo
 */
@Service
public class DemoMethodService {
    public void add(){
        System.out.println("DemoMethodService.add");
    }

}
