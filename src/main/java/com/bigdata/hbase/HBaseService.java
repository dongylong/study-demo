package com.bigdata.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

/**
 * @author dongyl
 * @date 18:33 11/30/17
 * @project study-demo
 */
public class HBaseService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final Configuration CONF = HBaseConfiguration.create();
    private static Connection CONN;
    private static Admin HBASEADMIN;
    private static HTableDescriptor[] TABLES;

    public void init() {
//        CONF = HBaseConfiguration.create();
        try {
            CONN = ConnectionFactory.createConnection(CONF);
            HBASEADMIN = CONN.getAdmin();
            TABLES = HBASEADMIN.listTables();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    
    public void deleteTable(String tName) {
        TableName tableName = TableName.valueOf(tName);
        try {
            HBASEADMIN.disableTable(tableName);
            HBASEADMIN.deleteTable(tableName);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeAdmin();
        }
    }

    
    public void createTable(String tName) {
        TableName tableName = TableName.valueOf(tName);
        HTableDescriptor hTableDescriptor = new HTableDescriptor(tableName);
        HColumnDescriptor hColumnDescriptor = new HColumnDescriptor("data");
        hTableDescriptor.addFamily(hColumnDescriptor);
        try {
            HBASEADMIN.createTable(hTableDescriptor);
            HTableDescriptor[] TABLES = HBASEADMIN.listTables();
            if (TABLES.length != 1 && Bytes.equals(tableName.getName(), TABLES[0].getTableName().getName())) {
                LOGGER.error("Fail to create a table");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeAdmin();
        }

    }

    private void closeAdmin() {
        try {
            HBASEADMIN.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeTable(Table table) {
        try {
            table.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public boolean insertData(String tName) {
        TableName tableName = TableName.valueOf(tName);
        if (TABLES.length != 1 && Bytes.equals(tableName.getName(), TABLES[0].getTableName().getName())) {
            LOGGER.error("Fail to create a table");
            return false;
        }
        Table table = null;
        try {
            table = CONN.getTable(tableName);
            for (int i = 1; i < 4; i++) {
                byte[] row = Bytes.toBytes("row" + i);
                Put put = new Put(row);
                byte[] columnFamily = Bytes.toBytes("data");
                byte[] qualifier = Bytes.toBytes("info");
                byte[] value = Bytes.toBytes("value" + i);
                //往单元data:info 存入value+i
                put.addColumn(columnFamily, qualifier, value);
                table.put(put);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeAdmin();
            closeTable(table);
        }
        return true;
    }

    
    public ResultScanner selectData(String tName) {
        TableName tableName = TableName.valueOf(tName);
        Table table = null;
        ResultScanner scanner = null;
        try {
            table = CONN.getTable(tableName);
            Get get = new Get(Bytes.toBytes("row1"));
            Result result = table.get(get);
            System.out.println("result:" + result);
            Scan scan = new Scan();
            scanner = table.getScanner(scan);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeTable(table);
        }
        return scanner;
    }
}
