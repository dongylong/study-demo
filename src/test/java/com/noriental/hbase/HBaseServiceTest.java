package com.noriental.hbase;

import org.apache.hadoop.hbase.client.*;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author dongyl
 * @date 14:58 11/30/17
 * @project study-demo
 */
public class HBaseServiceTest {
    private static String SNAME = "test";

    @Resource
    private HBaseService service;


    @Test
    public void hbasePool() throws IOException {
        HTablePool hTablePool = new HTablePool();
        HTableInterface userTable = hTablePool.getTable("test");

        userTable.close();
        hTablePool.close();
    }

    @Test
    public void ScanTest() throws IOException {
//        byte[] user = Md5Utils.

    }

    @Before
    public void conn() throws IOException {
        service = new HBaseService();
        service.init();
    }

    @Test
    public void deleteTableTest() throws IOException {
        service.deleteTable(SNAME);

    }

    @Test
    public void createTableTest() throws IOException {
        service.createTable(SNAME);
    }

    @Test
    public void insertData() throws IOException {
        service.insertData(SNAME);
    }

    @Test
    public void selectData() throws IOException {
        ResultScanner resultScanner = null;
        try {
            resultScanner = service.selectData(SNAME);
            for (Result result : resultScanner) {
                System.out.println("result:" + result);
            }
        } finally {
            closeScanner(resultScanner);
        }
    }

    private void closeScanner(ResultScanner resultScanner) {
        resultScanner.close();
    }

    @Test
    public void deleteData() throws IOException {
        service.deleteTable(SNAME);
    }
}
