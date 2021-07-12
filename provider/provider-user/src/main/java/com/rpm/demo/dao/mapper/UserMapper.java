package com.rpm.demo.dao.mapper;

/**
 * @Author Piming Ren
 * @Date 2020/12/17 14:33
 * @Version 1.0
 */
public interface UserMapper {

    /**
     * 每次将订单数量加  1
     * @param userId
     * @return
     */
    int orderPlus(int userId);
}
