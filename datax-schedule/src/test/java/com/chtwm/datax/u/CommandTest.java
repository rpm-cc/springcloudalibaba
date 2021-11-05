package com.chtwm.datax.u;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommandTest {

    public static void main(String[] args) {

        String datateime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(datateime);
    }
}
