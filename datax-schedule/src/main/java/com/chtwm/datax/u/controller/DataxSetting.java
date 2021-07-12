package com.chtwm.datax.u.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author: Piming Ren
 * @date: 2021/6/3 16:41
 * @version: 1.0
 * @description: 可以进行一些页面的简单设置
 */
@Controller
@RequestMapping("/datax")
public class DataxSetting {

    Logger logger  = LogManager.getLogger(this.getClass());
    @RequestMapping("/lastupdate/time")
    public String setLastUpdate(){
        return "view/datax/setting";
    }

    @RequestMapping("/error")
    public String error(){

        logger.debug("===========================debug============================");
        logger.info("===========================info============================");
        logger.warn("===========================warn============================");
        logger.fatal("===========================fatal============================");
        logger.error("===========================error============================");
        return "view/datax/setting";
    }

}
