package com.bigdata.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.hive.HiveContext;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dongyl
 * @date 14:43 11/22/17
 * @project study-demo
 */
public class SparkTest {


    @Test
    public void SparkSqlTest() {
        SparkConf conf = new SparkConf()
                .setAppName("Spark Demo")
//                .setMaster("spark://localhost:7077")
                .set("spark.app.name", "My Spark App")
                .set("spark.master", "local[4]")
                .set("spark.ui.port", "36000"); // 重载默认端口配置;
        JavaSparkContext sc1 = new JavaSparkContext(conf);
        SparkContext sc = new SparkContext(conf);
        HiveContext hiveContext = new HiveContext(sc);
        SQLContext sqlCtx = new HiveContext(sc);
        Dataset<Row> rows = sqlCtx.sql("SELECT name FROM user");
//        Row rows = hiveContext.sql("SELECT name FROM user");//DataFrame
        System.out.println("rows.first():" + rows.first());
    }

    @Test
    public void ConfigTest() {
        SparkConf conf = new SparkConf()
                .setAppName("Spark Demo")
//                .setMaster("spark://localhost:7077")
                .set("spark.app.name", "My Spark App")
                .set("spark.master", "local[4]")
                .set("spark.ui.port", "36000"); // 重载默认端口配置;
        JavaSparkContext sc = new JavaSparkContext(conf);
        String path = "server-error.log";
        JavaRDD<String> inputRDD = sc.textFile(path);
        System.out.println("inputRDD:" + inputRDD);
    }

    @Before
    public void SparkConnect() {


    }
}
