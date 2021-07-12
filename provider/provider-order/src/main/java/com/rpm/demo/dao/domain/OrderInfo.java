package com.rpm.demo.dao.domain;

/**
 * @Author Piming Ren
 * @Date 2020/12/17 15:30
 * @Version 1.0
 */
public class OrderInfo {
    int orderId;
    int userId;
    String orderDescr;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOrderDescr() {
        return orderDescr;
    }

    public void setOrderDescr(String orderDescr) {
        this.orderDescr = orderDescr;
    }
}
