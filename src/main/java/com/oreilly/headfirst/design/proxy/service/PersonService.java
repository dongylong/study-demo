package com.oreilly.headfirst.design.proxy.service;

/**
 * @author dongyl
 * @date 11:36 2019-02-08
 * @project study-demo
 */
public interface PersonService {

    String getName();
    String getGender();
    String getInterests();
    int getHotOrNotRating();
    void setName(String name);
    void setGender(String gender);
    void setInterests(String interests);
    void setHotOrNotRating(int rating);
}
