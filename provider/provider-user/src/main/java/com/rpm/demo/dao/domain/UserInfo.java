package com.rpm.demo.dao.domain;

/**
 * @Author Piming Ren
 * @Date 2020/12/17 14:46
 * @Version 1.0
 */
public class UserInfo {

    int userId  ;
    String userName;
    String userSex;
    int orderNum;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
}
