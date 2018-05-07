//package com.noriental.spark
//
//import org.apache.spark.{SparkConf, SparkContext}
//
///**
//  * @author dongyl
//  * @date 15:32 11/22/17
//  * @project study-demo
//  */
//class ConfigTest {
//  var inputfile = "";
//  var outputfile = "";
//  var conf = new SparkConf().setMaster("localhost").setAppName("My App");
//  val sc = new SparkContext(conf);
//  val input = sc.textFile(input);
//  var words = input.flatMap(line => line.split(" "));
//  var count = words.map(word => (word, 1)).reduceByKey { case (x, y) => x + y };
//  count.saveAsTextFile(outputfile);
//
//}
