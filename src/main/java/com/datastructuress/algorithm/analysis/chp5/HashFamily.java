package com.datastructuress.algorithm.analysis.chp5;

/**
 * AlgDemo
 * liuling
 * 2018/1/5
 **/
public interface HashFamily {
    int hash(String x,int which);
    int getNumberOfFunction();
    void generateNewFunctions();
}
