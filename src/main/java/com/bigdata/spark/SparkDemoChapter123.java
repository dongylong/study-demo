package com.bigdata.spark;

import org.apache.hadoop.util.StringUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaDoubleRDD;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.*;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author dongyl
 * @date 15:52 11/22/17
 * @project study-demo
 */
public class SparkDemoChapter123 {
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
                return new Tuple2(s.split(" ")[0],s);
            }
        }).reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer v1, Integer v2) throws Exception {
                return v1+v2;
            }
        });
    }
    private static void combineByKeyTest() {

    }
    private static void doubleMap() {
        JavaRDD<String> rdd = sc.parallelize(Arrays.asList("Hello Spark", "Hi"));
        JavaDoubleRDD result = rdd.mapToDouble(
                new DoubleFunction<String>() {
                    @Override
                    public double call(String s) throws Exception {
                        return Double.valueOf(s) * Double.valueOf(s);
                    }
                });
        System.out.println(result.mean());
    }

    private static void flatMapTest() {
        // flatMap() 将行数据切分为单词
        JavaRDD<String> rdd = sc.parallelize(Arrays.asList("Hello Spark", "Hi"));
        JavaRDD<String> words = rdd.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String line) {
                return Arrays.asList(line.split(" ")).iterator();
            }
        });

    }

    private static void test3() {
        //计算 RDD 中各值的平方
        JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1, 2, 3, 4, 5));
        JavaRDD<Integer> result = rdd.map(new Function<Integer, Integer>() {
            @Override
            public Integer call(Integer integer) throws Exception {
                return integer * integer;
            }
        });
        System.out.println(StringUtils.join(",", result.collect()));
    }

    private static void lambdaTest() {
        JavaRDD<String> errorsRDD = inputRDD.filter(s -> s.contains("error"));

    }

    private static void test2() {
        JavaRDD<String> errorsRDD = inputRDD.filter(new Contains("error"));
    }

    private static class Contains implements Function<String, Boolean> {
        private String query;

        public Contains(String query) {
            this.query = query;
        }

        @Override
        public Boolean call(String s) throws Exception {
            return s.contains(query);
        }
    }

    private static void test() {
        JavaRDD<String> errorsRDD = inputRDD.filter(new Function<String, Boolean>() {
            @Override
            public Boolean call(String s) throws Exception {
                return s.contains("ERROR");
            }
        });
    }

    private static void test1() {
        //在 Java 中使用匿名内部类进行函数传递
        JavaRDD<String> lines = sc.textFile(path);
        JavaRDD<String> errors1 = lines.filter(new ContainsError());
    }


    private static class ContainsError implements Function<String, Boolean> {
        @Override
        public Boolean call(String x) {
            return x.contains("error");

        }
    }

    private static void filterAndUnionAndTakeDemo() {
        //在 Java 中使用具名类进行函数传递
        JavaRDD<String> errorsRDD = inputRDD.filter(new Function<String, Boolean>() {
            @Override
            public Boolean call(String s) throws Exception {
                return s.contains("error");
            }
        });
        JavaRDD<String> warnRDD = inputRDD.filter(new Function<String, Boolean>() {
            @Override
            public Boolean call(String s) throws Exception {
                return s.contains("warn");
            }
        });
        errorsRDD.first();
        System.out.println("errorsRDD :" + errorsRDD);
        JavaRDD<String> badLineRDD = errorsRDD.union(warnRDD);
        System.out.println("badLineRDD.first():" + badLineRDD.first());
        System.out.println("errorsRDD.count():" + errorsRDD.count() + " connecting lines()");
        List<String> errorExample = errorsRDD.take(10);
        for (String ex : errorExample) {
            System.out.println("ex:" + ex);
        }
    }

    private static void parallelizeDemo(String inputFile, String outputFile) {
        sc.parallelize(Arrays.asList("pandas", "i love pandas"));
    }


    private static void wordCount(String inputFile, String outputFile) {
        JavaRDD<String> input = sc.textFile(inputFile);
        JavaRDD<String> words = input.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String s) throws Exception {
                return Arrays.asList(s.split(" ")).iterator();
            }
        });
        JavaPairRDD<String, Integer> counts = words.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<>(s, 1);
            }
        }).reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer v1, Integer v2) throws Exception {
                return v1 + v2;
            }
        });
        counts.saveAsTextFile(outputFile);
    }
}
