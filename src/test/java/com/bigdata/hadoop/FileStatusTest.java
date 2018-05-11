package com.bigdata.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.MiniDFSCluster;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author dongyl
 * @date 22:00 11/19/17
 * @project study-demo
 */
public class FileStatusTest {
    private FileSystem fs;
    private MiniDFSCluster cluster;
    private Path dir = new Path("hadoop/test");


    @Before
    public void setUp() throws IOException {
        Configuration conf = new Configuration();
        if (System.getProperty("test.build.data") == null) {
            System.setProperty("test.build.data", "/tmp");
            cluster = new MiniDFSCluster.Builder(conf).build();
            fs = cluster.getFileSystem();
            OutputStream out = fs.create(dir);
            out.write("content".getBytes("UTF-8"));
            out.close();
        }
    }

    @After
    public void tearDown() throws IOException {
        if (fs != null) {
            fs.close();
        }
        if (cluster != null) {
            cluster.shutdown();
        }
    }

    @Test
    public void mkDirTest() throws IOException {
        boolean flagMkdir = fs.mkdirs(dir);
        FileStatus status = fs.getFileStatus(dir);
        System.out.println("status:" + status);


    }

    @Test
    public void fileStatusForDirectory() throws IOException {
        boolean isExists = existsFile(dir);
        FileStatus status = fs.getFileStatus(dir);
        System.out.println("status:" + status);
    }

    public boolean existsFile(Path f) throws IOException {
        return fs.exists(f);
    }
}
