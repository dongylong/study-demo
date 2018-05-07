package com.noriental.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionOutputStream;
import org.apache.hadoop.util.ReflectionUtils;

public class StreamCompress {
    public static void main(String[] args) throws Exception {
        String codeClassName = args[0];
        Class<?> codeClass = Class.forName(codeClassName);
        Configuration conf = new Configuration();
        CompressionCodec compressionCodec = (CompressionCodec)ReflectionUtils.newInstance(codeClass,conf);
        CompressionOutputStream out = compressionCodec.createOutputStream(System.out);
        IOUtils.copyBytes(System.in,out,4096,false);
        out.finish();
    }
}
