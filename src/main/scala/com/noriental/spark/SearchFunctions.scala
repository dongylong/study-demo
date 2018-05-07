//package com.noriental.spark
//
//import org.apache.spark.rdd.RDD
//
///**
//  * @author dongyl
//  * @date 11:23 11/23/17
//  * @project study-demo
//  */
//class SearchFunctions(val query: String) {
//  def isMatch(s: String): Boolean = {
//    s.contains(query)
//  }
//
//  def getMatchFunctionReference(rdd: RDD[String]): RDD[String] = {
//    // 问题:"isMatch"表示"this.isMatch"，因此我们要传递整个"this"
//    rdd.map(isMatch)
//  }
//
//  def getMatchesFieldReference(rdd: RDD[String]): RDD[String] = {
//    // 问题:"query"表示"this.query"，因此我们要传递整个"this"
//    rdd.map(x => x.split(query))
//  }
//
//  def getMatchesNoReference(rdd: RDD[String]): RDD[String] = {
//    // 安全:只把我们需要的字段拿出来放入局部变量中
//    val query_ = this.query
//    rdd.map(x => x.split(query_))
//  }
//
//}
