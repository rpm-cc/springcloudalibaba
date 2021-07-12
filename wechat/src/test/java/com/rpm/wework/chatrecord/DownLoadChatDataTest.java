package com.rpm.wework.chatrecord;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class DownLoadChatDataTest {
    @Autowired
    DownLoadChatData chatData;
    @Autowired
    MediaDataHandler handler;

    @Test
    public void test() {


        chatData.download();
        handler.invoke();

    }

}