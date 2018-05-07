//package com.noriental.spark
//
//import org.apache.spark.ml
//import org.apache.spark.mllib.regression.LabeledPoint
//import org.apache.spark.mllib.regression.LinearRegressionWithSGD
//import org.apache.spark.rdd.RDD
///**
//  * @author dongyl
//  * @date 14:07 11/27/17
//  * @project study-demo
//  */
//class linearTest {
//  val points: RDD[LabeledPoint] = // ...
////  val lr = new LinearRegressionWithSGD().setNumIterations(200).setIntercept(true)
//  val lr = new ml.regression.LinearRegression().setNumIterations(200).setIntercept(true)
//  val model = lr.run(points)
//  println("weights: %s, intercept: %s".format(model.weights, model.intercept))
//}
