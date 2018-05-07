package com.noriental.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.hive.HiveContext;
/**
 * @author dongyl
 * @date 15:52 11/22/17
 * @project study-demo
 */
public class SparkDemoChapter5 {
    private static SparkConf conf = new SparkConf().setAppName("Spark Demo").setMaster("localhost");
    private static JavaSparkContext sc = new JavaSparkContext(conf);
    private static String path = "server-error.log";
    private static JavaRDD<String> inputRDD = sc.textFile(path);

    public  void main(String[] args) {
//        JavaRDD<String> input = sc.textFile("file:///Users/dongyl/Documents/ideaworkspace/study-demo/server-error.log");
//        System.out.println("input.first():" + input.first());
        HiveSparkTest();
    }

    private void HiveSparkTest(){
        SparkContext sc = new SparkContext(conf);
        HiveContext hiveContext = new HiveContext(sc);
        SQLContext sqlCtx = new HiveContext(sc);
        Dataset<Row> rows = sqlCtx.sql("SELECT name FROM user");
//        Row rows = hiveContext.sql("SELECT name FROM user");//DataFrame
        System.out.println("rows.first():"+rows.first());


    }
//    class ParseJson implements FlatMapFunction<Iterator<String>, Person> {
//        public Iterable<Person> call(Iterator<String> lines) throws Exception {
//            ArrayList<Person> people = new ArrayList<Person>();
//            ObjectMapper mapper = new ObjectMapper();
//            while (lines.hasNext()) {
//                String line = lines.next();
//                try {
//                    people.add(mapper.readValue(line, Person.class));
//                } catch (Exception e) {
//// 跳过失败的数据 }
//                }
//                return people;
//            }
//        }
//
//        class WriteJson implements FlatMapFunction<Iterator<Person>, String> {
//            public Iterable<String> call(Iterator<Person> people) throws Exception {
//                ArrayList<String> text = new ArrayList<String>();
//                ObjectMapper mapper = new ObjectMapper();
//                while (people.hasNext()) {
//                    Person person = people.next();
//                    text.add(mapper.writeValueAsString(person));
//                    数据读取与保存 | 67
//                }
//                return text;
//            }
//        }
//
//        JavaRDD<Person> result = input.mapPartitions(new ParseJson()).filter(
//                new LikesPandas());
//        JavaRDD<String> formatted = result.mapPartitions(new WriteJson());
//     formatted.saveAsTextFile(outfile);
//    }
}
