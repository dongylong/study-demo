package com.noriental.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/**
 * @author dongyl
 * @date 15:52 11/22/17
 * @project study-demo
 */
public class SparkDemoChapter4 {
    private static SparkConf conf = new SparkConf().setAppName("Spark Demo");
    private static JavaSparkContext sc = new JavaSparkContext(conf);
    private static String path = "server-error.log";
    private static JavaRDD<String> inputRDD = sc.textFile(path);
//    String path = "server-error.log";
//    JavaRDD<String> inputRDD = sc.textFile(path);
//    SparkConf conf = new SparkConf().setAppName("Spark Demo");
//    JavaSparkContext sc = new JavaSparkContext(conf);


    public static void main(String[] args) {
//        String inputFile = args[0];
//        String outputFile = args[1];
//        wordCount(inputFile, outputFile);
//        filterDemo();
//        test3();
        JavaRDD<String> rdd = sc.parallelize(Arrays.asList("Hello Spark", "Hi"));
        JavaRDD<String> words = rdd.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String s) throws Exception {
                return Arrays.asList(s.split(" ")).iterator();
            }
        });
        JavaPairRDD<String, Integer> result = words.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2(s.split(" ")[0], s);
            }
        }).reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer v1, Integer v2) throws Exception {
                return v1 + v2;
            }
        });
    }

    static class AvgCount implements Serializable {

        public SparkConf conf = new SparkConf().setAppName("Avg Count");
        public JavaSparkContext sc = new JavaSparkContext(conf);
        public int total_;
        public int sum_;

        public AvgCount(int total_, int sum_) {
            this.total_ = total_;
            this.sum_ = sum_;
        }

        public float avg() {
            return total_ / sum_;
        }

        ;
    }

    private static void combineByKeyTest() {
        Function<Integer, AvgCount> createAcc = new Function<Integer, AvgCount>() {
            @Override
            public AvgCount call(Integer v1) throws Exception {
                return new AvgCount(v1, 1);
            }
        };
        Function2<AvgCount, Integer, AvgCount> addAndCount = new Function2<AvgCount, Integer, AvgCount>() {
            @Override
            public AvgCount call(AvgCount v1, Integer v2) throws Exception {
                v1.sum_ += v2;
                v1.total_ += 1;
                return v1;
            }
        };
        Function2<AvgCount, AvgCount, AvgCount> combine = new Function2<AvgCount, AvgCount, AvgCount>() {
            @Override
            public AvgCount call(AvgCount v1, AvgCount v2) throws Exception {
                v1.total_ += v2.total_;
                v1.sum_ += v2.sum_;
                return v1;
            }
        };
        AvgCount initial = new AvgCount(0, 0);
        JavaRDD<String> words = sc.parallelize(Arrays.asList("Hello Spark", "Hi"));
        JavaPairRDD<String, Integer> result = words.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2(s.split(" ")[0], s);
            }
        });
        JavaPairRDD<String, AvgCount> avgCounts =
                result.combineByKey(createAcc, addAndCount, combine);
        Map<String, AvgCount> countMap = avgCounts.collectAsMap();
        for (Map.Entry<String, AvgCount> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().avg());
        }
    }

    private static void map2pair() {
        PairFunction<String, String, String> pairFunction = new PairFunction<String, String, String>() {
            @Override
            public Tuple2<String, String> call(String s) throws Exception {
                return new Tuple2(s.split(" ")[0], s);
            }
        };
        JavaPairRDD<String, String> mapToPair = inputRDD.mapToPair(pairFunction);
        Function<Tuple2<String, String>, Boolean> longWordFilter = new Function<Tuple2<String, String>, Boolean>() {
            @Override
            public Boolean call(Tuple2<String, String> v1) throws Exception {
                return v1._2().length() < 20;
            }
        };
        mapToPair.filter(longWordFilter);
        System.out.println("mapToPair:" + mapToPair);
    }
}
