package com.noriental.hadoop;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.junit.Test;

import java.io.IOException;

public class HadoopTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length != 2) {
            System.err.println("Usage:MaxTemperature <input path> <output path>");
            System.exit(-1);
        }

        JobConf jobConf = new JobConf(MaxTemperatureMapper.class);
        jobConf.setJobName("Max TemperatureMapper");

        FileInputFormat.addInputPath(jobConf, new Path(args[0]));
        FileOutputFormat.setOutputPath(jobConf, new Path(args[1]));

        jobConf.setMapperClass(MaxTemperatureMapper.class);
        jobConf.setReducerClass(MaxTemperatureReducer.class);

        jobConf.setOutputKeyClass(Text.class);
        jobConf.setOutputValueClass(IntWritable.class);
        JobClient.runJob(jobConf);

//        Job job = Job.getInstance();
//        job.setJarByClass(NewMaxTemperature.class);
//        job.setJobName("Max TemperatureMapper");
//
//        FileInputFormat.addInputPath(job, new Path(args[0]));
//        FileOutputFormat.setOutputPath(job, new Path(args[1]));
//
//        job.setMapperClass(MaxTemperatureMapper.class);
//        job.setReducerClass(MaxTemperatureReducer.class);
//
//        job.setOutputKeyClass(Text.class);
//        job.setOutputValueClass(IntWritable.class);
//        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

    @Test
    public void MapReduceTest() {

    }
}
