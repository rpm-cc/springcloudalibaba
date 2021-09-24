package com.rpm.temp.controller;

import com.rpm.temp.entity.DataResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author: Piming Ren
 * @date: 2021/9/9 14:23
 * @version: 1.0
 * @description:
 */


@RestController
@RequestMapping("/temp")
public class BigDecimalController {

    @RequestMapping("/data")
    DataResponse response(){

        DataResponse response  = new DataResponse();
        response.setString("this is string");
        response.setInteger(1);
        response.set_double(1.00);
        response.set_long(10000L);
        response.setBigDecimal(BigDecimal.valueOf(10000.09098));
        return  response;

    }
}
