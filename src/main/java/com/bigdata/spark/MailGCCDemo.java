//package com.noriental.spark;
//
//import org.apache.spark.SparkContext;
//import org.apache.spark.api.java.JavaRDD;
//import org.apache.spark.api.java.function.Function;
//import org.apache.spark.mllib.classification.LogisticRegressionModel;
//import org.apache.spark.mllib.classification.LogisticRegressionWithSGD;
//import org.apache.spark.mllib.feature.HashingTF;
//import org.apache.spark.mllib.linalg.Vector;
//import org.apache.spark.mllib.regression.LabeledPoint;
//import org.apache.spark.rdd.RDD;
//
//import java.util.Arrays;
//
///**
// * @author dongyl
// * @date 11:48 11/27/17
// * @project study-demo
// */
//public class MailGCCDemo {
//
//    public void Test() {
//        SparkContext sc = new SparkContext();
//
//        RDD<String> spam = sc.textFile("spam.txt", 0);
//        RDD<String> normal = sc.textFile("normal.txt", 0);
//        // 创建一个HashingTF实例来把邮件文本映射为包含10000个特征的向量
//        final HashingTF tf = new HashingTF(10000);
//// 创建LabeledPoint数据集分别存放阳性(垃圾邮件)和阴性(正常邮件)的例子
//
//        JavaRDD<LabeledPoint> posExamples = spam.map(new Function<String, LabeledPoint>() {
//            public LabeledPoint call(String email) {
//                return new LabeledPoint(1, tf.transform(Arrays.asList(email.split(" "))));
//            }
//        });
//        JavaRDD<LabeledPoint> negExamples = normal.map(new Function<String, LabeledPoint>() {
//            public LabeledPoint call(String email) {
//                return new LabeledPoint(0, tf.transform(Arrays.asList(email.split(" "))));
//            }
//        });
//        JavaRDD<LabeledPoint> trainData = positiveExamples.union(negativeExamples);
//        trainData.cache(); // 因为逻辑回归是迭代算法，所以缓存训练数据RDD
//// 使用SGD算法运行逻辑回归
//        LogisticRegressionModel model = new LogisticRegressionWithSGD().run(trainData.rdd());
//// 以阳性(垃圾邮件)和阴性(正常邮件)的例子分别进行测试 Vector posTest = tf.transform(
//        Arrays.asList("O M G GET cheap stuff by sending money to ...".split(" "));
//        Vector negTest = tf.transform(
//                Arrays.asList("Hi Dad, I started studying Spark the other ...".split(" ")));
//        System.out.println("Prediction for positive example: " + model.predict(posTest));
//        System.out.println("Prediction for negative example: " + model.predict(negTest));
//
//    }
//}