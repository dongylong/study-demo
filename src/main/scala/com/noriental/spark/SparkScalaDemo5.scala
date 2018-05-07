//package com.noriental.spark
//
//import java.sql.{DriverManager, ResultSet}
//
//import org.apache.hadoop.fs.Path
//import org.apache.hadoop.hbase.HBaseConfiguration
//import org.apache.hadoop.hbase.io.ImmutableBytesWritable
//import org.apache.hadoop.io.MapWritable
//import org.apache.hadoop.mapred.{FileOutputCommitter, FileOutputFormat, JobConf}
//import org.apache.spark.rdd.JdbcRDD
//import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}
//
///**
//  * @author dongyl
//  * @date 15:33 11/22/17
//  * @project study-demo
//  */
//class SparkScalaDemo5 {
//  var conf = new SparkConf().setAppName("My App");
//  //.setMaster("localhost")
//  val sc = new SparkContext(conf);
//  val input = sc.textFile("file:///home/holden/repos/spark/README.md")
//
//  def avg(): Unit = {
//    val input = sc.wholeTextFiles("file://home/holden/salesFiles")
//    val result = input.mapValues { y =>
//      val nums = y.split(" ").map(x => x.toDouble)
//      nums.sum / nums.size.toDouble
//      input.saveAsTextFile("file");
//    }
//  }
//  //ES input
////  def mapWritableToInput(in: MapWritable): Map[String, String] = {
////    in.map{case (k, v) => (k.toString, v.toString)}.toMap
////  }
////  val jobConf = new JobConf(sc.hadoopConfiguration)
////  jobConf.set(ConfigurationOptions.ES_RESOURCE_READ, args(1))
////  jobConf.set(ConfigurationOptions.ES_NODES, args(2))
////  val currentTweets = sc.hadoopRDD(jobConf,
////    classOf[EsInputFormat[Object, MapWritable]], classOf[Object],
////    classOf[MapWritable])
//  // 仅提取map
//  // 将MapWritable[Text, Text]转为Map[String, String]
////  val tweets = currentTweets.map{ case (key, value) => mapWritableToInput(value) }
//  //ES output
//  // ES output BEGIN
////  val jobConf = new JobConf(sc.hadoopConfiguration)
////  jobConf.set("mapred.output.format.class", "org.elasticsearch.hadoop.mr.EsOutputFormat")
////  jobConf.setOutputCommitter(classOf[FileOutputCommitter])
////  jobConf.set(ConfigurationOptions.ES_RESOURCE_WRITE, "twitter/tweets")
////  jobConf.set(ConfigurationOptions.ES_NODES, "localhost")
////  FileOutputFormat.setOutputPath(jobConf, new Path("-"))
////  output.saveAsHadoopDataset(jobConf);
//
//  //ES output END
////  val conf = HBaseConfiguration.create()
////  conf.set(TableInputFormat.INPUT_TABLE, "tablename") // 扫描哪张表
////  val rdd = sc.newAPIHadoopRDD(
////    conf, classOf[TableInputFormat], classOf[ImmutableBytesWritable], classOf[Result])
//
//  //JDBC begin
//  def createConnection() = {
//    Class.forName("com.mysql.jdbc.Driver").newInstance();
//    DriverManager.getConnection("jdbc:mysql://localhost/test?user=holden");
//  }
//
//  def extractValues(r: ResultSet) = {
//    (r.getInt(1), r.getString(2))
//  }
//
//  val data = new JdbcRDD(sc,
//    createConnection, "SELECT * FROM panda WHERE ? <= id AND id <= ?",
//    lowerBound = 1, upperBound = 3, numPartitions = 2, mapRow = extractValues)
//  println(data.collect().toList)
//  // JDBC END
//
//  //  case class Person(name: String, lovePandas: Boolean) {
//  //    val result = input.flatMap(record => {
//  //      try {
//  //        Some(mapper.readValue(record, classOf[Person]))
//  //      } catch {
//  //        case e: Exception => None
//  //      }
//  //    })
//  //  }
//  //
//  //  def save(): Unit = {
//  //    result.filter(p => P.lovesPandas).map(mapper.writeValueAsString(_))
//  //      .saveAsTextFile(outputFile)
//  //  }
//}
