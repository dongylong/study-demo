//package com.noriental.spark;
//
//import org.apache.spark.SparkConf;
//import org.apache.spark.api.java.JavaRDD;
//import org.apache.spark.api.java.JavaSparkContext;
//import org.apache.spark.ml.regression.LinearRegression;
//import org.apache.spark.mllib.optimization.LBFGS;
//import org.apache.spark.mllib.regression.LabeledPoint;
//import org.apache.spark.mllib.regression.LinearRegressionModel;
//import org.apache.spark.mllib.regression.LinearRegressionWithSGD;
//
///**
// * @author dongyl
// * @date 15:52 11/22/17
// * @project study-demo
// */
//public class SparkDemoChapter11 {
//    private static SparkConf conf = new SparkConf().setAppName("Spark Demo");
//    private static JavaSparkContext sc = new JavaSparkContext(conf);
//    private static String path = "server-error.log";
//    private static JavaRDD<String> inputRDD = sc.textFile(path);
////    String path = "server-error.log";
////    JavaRDD<String> inputRDD = sc.textFile(path);
////    SparkConf conf = new SparkConf().setAppName("Spark Demo");
////    JavaSparkContext sc = new JavaSparkContext(conf);
//
//
//    public static void main(String[] args) {
//        JavaRDD<LabeledPoint> points = null;// ...
//        LinearRegressionWithSGD lr = new LBFGS().setNumIterations(200).setIntercept(true);
//        LinearRegressionWithSGD lr1 = new LinearRegression().setNumIterations(200).setIntercept(true);
//        LinearRegressionModel model = lr.run(points.rdd());
//        System.out.printf("weights: %s, intercept: %s\n",
//                model.weights(), model.intercept());
//    }
//}
