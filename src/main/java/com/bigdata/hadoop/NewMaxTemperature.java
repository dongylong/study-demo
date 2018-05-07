package com.bigdata.hadoop;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class NewMaxTemperature {

    static abstract class NewMaxTemperatureMapper implements Mapper<LongWritable, Text, Text, IntWritable> {
        private static final int MISSING = 9999;
        public void map(LongWritable key, Text value, org.apache.hadoop.mapreduce.Mapper.Context context) throws IOException, InterruptedException {
            String line = value.toString();
            String year = line.substring(15,19);
            int airTemperature;
            if(line.charAt(87) == '+'){
                airTemperature = Integer.valueOf(line.substring(88,92));
            }else {
                airTemperature = Integer.valueOf(line.substring(87,92));
            }
            String quality = line.substring(92,93);
            if(airTemperature != MISSING && quality.matches("[01359]")){
                context.write(new Text(year),new IntWritable(airTemperature));
            }
        }
    }

    static class NewMaxTemperatureReduce extends Reducer<Text,IntWritable,Text,IntWritable>{
        public void reduce(Text key, Iterator<IntWritable> values, Context context) throws IOException, InterruptedException {
            int maxValue = Integer.MIN_VALUE;
            while (values.hasNext()){
                maxValue = Integer.max(maxValue,values.next().get());
            }
            context.write(key,new IntWritable(maxValue));
        }
    }

}
