package com.bigdata.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * @author dongyl
 * @date 15:52 11/22/17
 * @project study-demo
 */
public class SparkDemoChapter7 {
    private static SparkConf conf = new SparkConf()
            .setAppName("Spark Demo")
            .setMaster("spark://localhost:7077")
            ;
    private static JavaSparkContext sc = new JavaSparkContext(conf);
    private static String path = "server-error.log";
    private static JavaRDD<String> inputRDD = sc.textFile(path);

    public void main(String[] args) {
        System.out.println("inputRDD:"+inputRDD);
        System.out.println("inputRDD:"+inputRDD);

    }

}
