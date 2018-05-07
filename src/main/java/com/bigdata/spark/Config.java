package com.bigdata.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;

/**
 * @author dongyl
 * @date 14:41 11/22/17
 * @project study-demo
 */
public class Config {
    SparkConf conf = new SparkConf().setMaster("localhost").setAppName("My App");
    SparkContext sc = new SparkContext(conf);
}
