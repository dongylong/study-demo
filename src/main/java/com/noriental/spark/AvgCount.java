package com.noriental.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author dongyl
 * @date 13:50 11/23/17
 * @project study-demo
 */
public class AvgCount implements Serializable {

    private SparkConf conf = new SparkConf().setAppName("Avg Count");
    private JavaSparkContext sc = new JavaSparkContext(conf);
    private int total;
    private int sum;

    public AvgCount(int totle, int sum) {
        this.total = totle;
        this.sum = sum;
    }

    public double avg() {
        return total / sum;
    }

    Function2<AvgCount, Integer, AvgCount> addAndCount = new Function2<AvgCount, Integer, AvgCount>() {
        @Override
        public AvgCount call(AvgCount v1, Integer v2) throws Exception {
            v1.total += v2;
            v1.sum = 1;
            return v1;
        }
    };
    Function2<AvgCount, AvgCount, AvgCount> combine = new Function2<AvgCount, AvgCount, AvgCount>() {
        @Override
        public AvgCount call(AvgCount v1, AvgCount v2) throws Exception {
            v1.total += v2.total;
            v1.sum += v2.sum;
            return v1;
        }
    };

    public void main(String[] args) {
        AvgCount initial = new AvgCount(0,0);
        JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1, 2, 3, 4, 5));
        AvgCount result = rdd.aggregate(initial,addAndCount,combine);
        System.out.println("result.avg(): "+result.avg());
    }
}
