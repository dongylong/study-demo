package com.oreilly.headfirst.design.chp11.handler;

import com.oreilly.headfirst.design.chp11.service.PersonService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author dongyl
 * @date 21:49 2019-02-08
 * @project study-demo
 */
public class NonOwnerInvocationHandler implements InvocationHandler {
    PersonService personService ;

    public NonOwnerInvocationHandler(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try{
            if(method.getName().startsWith("get")){
                return method.invoke(personService,args);
            }else if (method.getName().equals("setHotOrNotRating")){
                return method.invoke(personService,args);
            }else if(method.getName().startsWith("set")){
                throw new IllegalAccessException();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
