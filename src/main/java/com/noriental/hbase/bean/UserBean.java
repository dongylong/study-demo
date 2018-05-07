package com.noriental.hbase.bean;

/**
 * @author dongyl
 * @date 15:28 12/1/17
 * @project study-demo
 */
public class UserBean {
    public String user;
    public String name;
    public String password;
    public String email;

    @Override
    public String toString() {
        return String.format(
                "<user:%s,%s,%s>"+ user,name,email);
    }
}
