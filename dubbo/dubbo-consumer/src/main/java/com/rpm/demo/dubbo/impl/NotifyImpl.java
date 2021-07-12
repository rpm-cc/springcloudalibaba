package com.rpm.demo.dubbo.impl;

import com.rpm.demo.dubbo.service.Notify;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author PimingRen
 * @Date 2021/4/24
 * @Version 1.0
 */

//@DubboService(interfaceName = "notifyImpl")
public class NotifyImpl implements Notify {
    public Map<Integer, String> ret = new HashMap<Integer, String>();
    public Map<Integer, Throwable> errors = new HashMap<Integer, Throwable>();
    Logger log = LogManager.getLogger(this.getClass());
    //注意到一点，DemoService 中的sayHello方法是没有参数的 。
    //所以，oninvoke  中没有参数，onreturn 中的参数是sayHello的放回值，没有其他参数。
    //onthrow 中是抛出的异常，也没有其他的参数 。

    @Override
    public void oninvoke() {
        log.info("oninvoke:void");
    }

    @Override
    public void onreturn(String msg) {
        log.info("onreturn:{}", msg);
        ret.put(1, msg);
    }

    @Override
    public void onthrow(Throwable ex) {
        errors.put(2, ex);
    }
}