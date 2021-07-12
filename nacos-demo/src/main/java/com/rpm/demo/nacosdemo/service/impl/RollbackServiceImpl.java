package com.rpm.demo.nacosdemo.service.impl;

import com.rpm.demo.nacosdemo.service.RollbackService;
import com.rpm.demo.service.OrderDemoService;
import com.rpm.demo.service.UserDemoService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Piming Ren
 * @Date 2020/12/21 16:31
 * @Version 1.0
 */
@Service
public class RollbackServiceImpl implements RollbackService {
    @Autowired
    OrderDemoService orderDemoService;
    @Autowired
    UserDemoService userDemoService;
    @Override
    @GlobalTransactional(timeoutMills = 300000,rollbackFor = Exception.class )
    public String createOrder() {

        System.out.println("开始全局事务，XID = " + RootContext.getXID());
        String order  = orderDemoService.createOrder();
        int amount =   userDemoService.orderplus();
        if (1==1){
            throw new RuntimeException("测试抛异常后，分布式事务回滚！");
        };
        return order+":"+amount;
    }
}
