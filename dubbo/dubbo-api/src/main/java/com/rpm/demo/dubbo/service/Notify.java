package com.rpm.demo.dubbo.service;

/**
 * @Author PimingRen
 * @Date 2021/4/24
 * @Version 1.0
 */
public interface Notify {
    void oninvoke();
    void onreturn(String msg);
    void onthrow(Throwable ex);
}