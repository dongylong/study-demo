package com.noriental.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.util.LongAccumulator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author dongyl
 * @date 15:52 11/22/17
 * @project study-demo
 */
public class SparkDemoChapter6 {
    private static SparkConf conf = new SparkConf().setAppName("Spark Demo").setMaster("localhost");
    private static JavaSparkContext sc = new JavaSparkContext(conf);
    private static String path = "server-error.log";
    private static JavaRDD<String> inputRDD = sc.textFile(path);

    public void main(String[] args) {


    }

    private void contactCounts(){
//      读入呼号表
//      查询RDD contactCounts中的呼号对应的国家
//        final Broadcast<String[]> signPrefixes = sc.broadcast(loadCallSignTable());
//        JavaPairRDD<String, Integer> countryContactCounts = contactCounts.mapToPair(
//                new PairFunction<Tuple2<String, Integer>, String, Integer>() {
//                    @Override
//                    public Tuple2<String, Integer> call(Tuple2<String, Integer> callSignCount) {
//                        String sign = callSignCount._1();
//                        String country = lookupCountry(sign, callSignInfo.value());
//                        return new Tuple2(country, callSignCount._2());
//                    }
//                }).reduceByKey(new SumInts());
//        countryContactCounts.saveAsTextFile(outputDir + "/countries.txt");
    }
    private void accumulate() {
        String args1 = "";//args[1];
        JavaRDD<String> rdd = sc.textFile(args1);
        LongAccumulator blankLines = sc.sc().longAccumulator();
        JavaRDD<String> callSigns = rdd.flatMap(
                new FlatMapFunction<String, String>() {
                    @Override
                    public Iterator<String> call(String line) throws Exception {
                        if (line.equals("")) {
                            blankLines.add(1);
                        }
                        return Arrays.asList(line.split(" ")).iterator();
                    }
                }
        );
        callSigns.saveAsTextFile("output.txt");
        System.out.println("Blank lines: " + blankLines.value());
    }
}
