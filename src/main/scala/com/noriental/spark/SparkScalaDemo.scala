//package com.noriental.spark
//
//import org.apache.hadoop.hdfs.protocol.proto.HdfsProtos.DatanodeStorageProto.StorageState
//import org.apache.spark.storage.StorageLevel
//import org.apache.spark.{SparkConf, SparkContext}
//
///**
//  * @author dongyl
//  * @date 15:33 11/22/17
//  * @project study-demo
//  */
//class SparkScalaDemo {
//  var conf = new SparkConf().setAppName("My App");
//  //.setMaster("localhost")
//  val sc = new SparkContext(conf);
//
//  def xx() {
//    val inputRDD = sc.textFile(".server-error");
//    val errorLinesRDD = inputRDD.filter(line => line.contains("error"));
//    val warnLinesRDD = inputRDD.filter(line => line.contains("error"));
//    val badLinesRDD = errorLinesRDD.union(warnLinesRDD);
//
//    errorLinesRDD.take(10).foreach(println);
//
//    println("Input had " + badLinesRDD.count() + " concerning lines")
//    println("Here are 10 examples:")
//    badLinesRDD.take(10).foreach(println)
//  }
//
//  def que(): Unit = {
//    val inputRDD = sc.parallelize(List(1, 2, 3, 4))
//    val result = inputRDD.map(x => x * x)
//    print(result.collect().mkString(","));
//
//  }
//
//  def flatMapTest(): Unit = {
//    val lines = sc.parallelize(List("Hello Spark", "Scala"))
//    val result = lines.flatMap(line => line.split(" "))
//    print(result.collect().mkString(","));
//  }
//
//  def agreegateTest(): Unit = {
//    val inputRDD = sc.parallelize(List(1, 2, 3, 4));
//    val result = inputRDD.aggregate(0, 0)(
//      (acc, value) => (acc._1 + value, acc._2 + 1),
//      (acc1, acc2) => (acc1._1 + acc2._1, acc2._2 + acc2._2));
//    val avg = result._1 / result._2.toDouble;
//  }
//
//  def persistDemo(): Unit = {
//    val inputRDD = sc.parallelize(List(1, 2, 3, 4));
//    val result = inputRDD.map(x => x * x);
//    result.persist(StorageLevel.DISK_ONLY);
//    println(result.count())
//    println(result.collect().mkString(","))
//  }
//
//  def pairRDD(): Unit = {
//    val lines = sc.parallelize(List("Hello Spark", "Scala"))
//    val pairs = lines.map(x => (x.split(" ")(0), x));
//    pairs.filter { case (key, value) => value.length < 20 }
//  }
//
//  def countWord(): Unit = {
//    val lines = sc.parallelize(List("Hello Spark", "Scala"))
//    val words = lines.flatMap(x => (x.split(" ")));
//    var result = words.map(x => (x, 1)).reduceByKey((x, y) => x + y);
//  }
//}
