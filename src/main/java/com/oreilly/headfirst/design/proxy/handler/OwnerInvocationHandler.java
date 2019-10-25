package com.oreilly.headfirst.design.proxy.handler;

import com.oreilly.headfirst.design.proxy.service.PersonService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author dongyl
 * @date 12:26 2019-02-08
 * @project study-demo
 */
public class OwnerInvocationHandler implements InvocationHandler {
    PersonService personService;

    public OwnerInvocationHandler(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if(method.getName().startsWith("get")){
                return method.invoke(personService,args);
            }else if(method.getName().equals("setHotOrNotRating")){
                throw new IllegalAccessException();
            }else if(method.getName().startsWith("set")){
                return method.invoke(personService,args);
            }
        }catch (InvocationTargetException e){
            e.printStackTrace();
        }
        return null;
    }

}
