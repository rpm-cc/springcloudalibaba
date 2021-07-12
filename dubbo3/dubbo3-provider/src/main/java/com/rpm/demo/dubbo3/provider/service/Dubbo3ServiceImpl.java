package com.rpm.demo.dubbo3.provider.service;

import com.rpm.demo.dubbo3.api.Dubbo3Service;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author: Piming Ren
 * @date: 2021/7/6 17:52
 * @version: 1.0
 * @description:
 */
@DubboService
public class Dubbo3ServiceImpl implements Dubbo3Service {
    @Override
    public String dubbo3() {
        return "dubbo3";
    }
}
