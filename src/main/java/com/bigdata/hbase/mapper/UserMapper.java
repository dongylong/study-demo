package com.bigdata.hbase.mapper;

import com.bigdata.hbase.bean.UserBean;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * @author dongyl
 * @date 15:33 12/1/17
 * @project study-demo
 */
public class UserMapper {
    private static byte[] TABLE_NAME = Bytes.toBytes("user");
    private static byte[] INFO_FAM = Bytes.toBytes("info");
    private static byte[] USER_COL = Bytes.toBytes("user");
    private static byte[] NAME_COL = Bytes.toBytes("name");
    private static byte[] PASSWORD_COL = Bytes.toBytes("password");
    private static byte[] EMAIL_COL = Bytes.toBytes("email");
    private static byte[] TWEET_COL = Bytes.toBytes("tweet_content");

    private static Get mkGet(String user) {
        Get g = new Get(Bytes.toBytes(user));
        g.addFamily(INFO_FAM);
        return g;
    }

    private static Put mkPut(UserBean u) {
        Put put = new Put(Bytes.toBytes(u.user));
        put.add(INFO_FAM, USER_COL, Bytes.toBytes(u.user));
        put.add(INFO_FAM, NAME_COL, Bytes.toBytes(u.name));
        put.add(INFO_FAM, PASSWORD_COL, Bytes.toBytes(u.password));
        put.add(INFO_FAM, EMAIL_COL, Bytes.toBytes(u.email));
        return put;
    }

    public static Delete mkDel(String user) {
        Delete del = new Delete(Bytes.toBytes(user));
        return del;
    }

    public void addUser(String user,
                        String name,
                        String password,
                        String email) throws IOException {
        TableName tableName = TableName.valueOf(TABLE_NAME);
        Table table = null;
        Connection conn = null;
        try {
            Configuration conf = HBaseConfiguration.create();
            conn = ConnectionFactory.createConnection(conf);
            table = conn.getTable(tableName);
            Put p = mkPut(new User(user, name, password, email));
            table.put(p);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                table.close();
                conn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public User getUser(String user) {
        TableName tableName = TableName.valueOf(TABLE_NAME);
        Table table = null;
        Connection conn = null;
        User u = null;
        try {
            Configuration conf = HBaseConfiguration.create();
            conn = ConnectionFactory.createConnection(conf);
            table = conn.getTable(tableName);
            Get get = mkGet(user);
            Result result = table.get(get);
            u = new User(result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                table.close();
                conn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return u;
    }

    public void delUser(String user) {
        TableName tableName = TableName.valueOf(TABLE_NAME);
        Table table = null;
        Connection conn = null;
        try {
            Configuration conf = HBaseConfiguration.create();
            conn = ConnectionFactory.createConnection(conf);
            table = conn.getTable(tableName);
            Delete d = mkDel(user);
            table.delete(d);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                table.close();
                conn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class User extends UserBean {
        public long tweetCount;

        private User(Result result) {
            this(result.getValue(INFO_FAM, USER_COL),
                    result.getValue(INFO_FAM, NAME_COL),
                    result.getValue(INFO_FAM, PASSWORD_COL),
                    result.getValue(INFO_FAM, EMAIL_COL),
                    result.getValue(INFO_FAM, TWEET_COL) == null ? Bytes.toBytes(0L) :
                            result.getValue(INFO_FAM, TWEET_COL));
        }

        public User(byte[] user, byte[] name, byte[] password, byte[] email, byte[] tweetCount) {
            this(Bytes.toString(user),
                    Bytes.toString(name),
                    Bytes.toString(password),
                    Bytes.toString(email));
            this.tweetCount = Bytes.toLong(tweetCount);
        }

        public User(String user, String name, String password, String email) {
            this.user = user;
            this.name = name;
            this.password = password;
            this.email = email;
        }
    }
}
