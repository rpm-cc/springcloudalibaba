package com.chtwm.datax.u;

import com.chtwm.datax.u.handler.MysqlToMysqlHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CommondSpringtest {
    @Autowired
    MysqlToMysqlHandler handler;

    @Test
    public void test(){
        try {
            handler.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
