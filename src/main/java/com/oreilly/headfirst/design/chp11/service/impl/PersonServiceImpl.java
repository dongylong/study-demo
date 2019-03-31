package com.oreilly.headfirst.design.chp11.service.impl;

import com.oreilly.headfirst.design.chp11.service.PersonService;

/**
 * @author dongyl
 * @date 12:16 2019-02-08
 * @project study-demo
 */
public class PersonServiceImpl implements PersonService {
    String name;
    String gender;
    String interests;
    int rating;
    int ratindCount = 0;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getInterests() {
        return interests;
    }

    @Override
    public int getHotOrNotRating() {
        if (ratindCount == 0) {
            return 0;
        }
        return rating / ratindCount;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setInterests(String interests) {
        this.interests = interests;
    }

    @Override
    public void setHotOrNotRating(int rating) {
        this.rating = rating;
        ratindCount++;
    }
}
