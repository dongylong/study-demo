package com.neworiental.bean;

import lombok.*;

/**
 * @author dongyl
 * @date 17:09 5/18/18
 * @project study-demo
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class UserBean {
    private long id;
    public String name;
    public String pwd;

    public static void main(String[] args) {
        UserBean user = new UserBean();
//        user.setId(1);
        user.setName("name");
        user.setPwd("pwd");
        System.out.println(user);
    }
}
