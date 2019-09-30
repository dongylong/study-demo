package com.oreilly.headfirst.design.chp11;

import com.oreilly.headfirst.design.chp11.handler.NonOwnerInvocationHandler;
import com.oreilly.headfirst.design.chp11.handler.OwnerInvocationHandler;
import com.oreilly.headfirst.design.chp11.service.PersonService;
import com.oreilly.headfirst.design.chp11.service.impl.PersonServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @author dongyl
 * @date 21:39 2019-02-08
 * @project study-demo
 */
public class MatchMakingTestDrive {
    public static void main(String[] args) {
        MatchMakingTestDrive test = new MatchMakingTestDrive();
        test.drive();
    }

    public MatchMakingTestDrive() {
        initializeDataBase();
    }

    private void initializeDataBase() {

    }

    private void drive() {
        PersonService joe = getPersonFromDataBase("Joe JavaBean");
        PersonService ownerProxy = getOwnerProxy(joe);
        System.out.println("Name is :"+ownerProxy.getName());
        ownerProxy.setInterests("bowling,go");
        System.out.println("Interests set from owner proxy");
        try {
            ownerProxy.setHotOrNotRating(10);
        }catch (Exception e){
            System.out.println("canot set interest from non owner proxy");
        }
        PersonService nonOwnerProxy = getNonOwnerProxy(joe);
        nonOwnerProxy.setHotOrNotRating(3);
        System.out.println("rating set from owner proxy");
        System.out.println("Ratind is "+ nonOwnerProxy.getHotOrNotRating());
    }

    private PersonService getPersonFromDataBase(String person) {
        PersonService personService  = new PersonServiceImpl();
        return personService;
    }

    PersonService getOwnerProxy(PersonService personService){
        return (PersonService) Proxy.newProxyInstance(
                personService.getClass().getClassLoader()
                ,personService.getClass().getInterfaces()
                ,new OwnerInvocationHandler(personService)
        );
    }
    PersonService getNonOwnerProxy(PersonService personService){
        return (PersonService) Proxy.newProxyInstance(
                personService.getClass().getClassLoader()
                ,personService.getClass().getInterfaces()
                ,new NonOwnerInvocationHandler(personService)
        );
    }
}
