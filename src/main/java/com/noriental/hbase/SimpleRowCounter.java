package com.noriental.hbase;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.FirstKeyOnlyFilter;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.output.NullOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * @author dongyl
 * @date 19:02 11/30/17
 * @project study-demo
 */
public class SimpleRowCounter extends Configured implements Tool {
    static class RowCounterMapper extends TableMapper<ImmutableBytesWritable, Result> {
        public static enum Counters {
            ROWS;
        }

        @Override
        public void map(ImmutableBytesWritable row, Result result, Context context) {
            context.getCounter(Counters.ROWS).increment(1);
        }
    }

    @Override
    public int run(String[] strings) throws Exception {
        String tName = strings[0];
        Scan scan = new Scan();
        scan.setFilter(new FirstKeyOnlyFilter());
        Job job = new Job(getConf(), getClass().getSimpleName());
        job.setJarByClass(getClass());
        TableMapReduceUtil.initTableMapperJob(tName, scan,
                RowCounterMapper.class, ImmutableBytesWritable.class, Result.class,
                job);
        job.setNumReduceTasks(0);
        job.setOutputFormatClass(NullOutputFormat.class);
        return job.waitForCompletion(true) ? 0 : 1;
    }

    public static void main(String[] args) throws Exception {
        int exitCode = ToolRunner.run(HBaseConfiguration.create(),new SimpleRowCounter(),args);
        System.exit(exitCode);
    }
}