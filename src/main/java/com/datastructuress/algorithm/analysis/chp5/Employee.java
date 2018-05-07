package com.datastructuress.algorithm.analysis.chp5;

/**
 * AlgDemo
 * liuling
 * 2018/1/2
 **/
public class Employee {
    private String name;
    private double salary;
    private int seniority;

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Employee && name.equals(((Employee) obj).name);
    }
}
