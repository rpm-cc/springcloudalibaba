package com.rpm.demo.mapper;

import com.rpm.demo.dao.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


/**
 * @Author Piming Ren
 * @Date 2020/12/17 14:51
 * @Version 1.0
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserMapperTest {
    @Autowired
    UserMapper mapper;

    @Test
    public void orderPlus() {
        for (int i=0;i<10000;i++) {
            mapper.orderPlus(1);
        }
    }
}
