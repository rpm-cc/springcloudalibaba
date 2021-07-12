package com.chtwm.datax.u.handler;


import com.chtwm.datax.u.config.DataxPropertis;
import com.chtwm.datax.u.config.KeyConstants;
import com.chtwm.datax.u.util.logparse.LogStatistics;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.chtwm.datax.u.util.logparse.AnalysisStatistics.analysisStatisticsLog;

/**
 * @author: Piming Ren
 * @date: 2021/6/1 09:41
 * @version: 1.0
 * @description: 定时执行器。使用Xxl job 执行
 */
@Component
@Slf4j
public class MysqlToMysqlHandler  {
    @Autowired
    DataxPropertis dataxPropertis;
    @Autowired
    StringRedisTemplate redisTemplate;

    public String execute() throws Exception {
        log.info("****************   datax Transmission started!   ********************");
        String lastTime = redisTemplate.opsForValue().get(KeyConstants.KEY_UPDATE_TIME);
        if (StringUtils.isEmpty(lastTime)){
            lastTime = "1970-01-01%00:00:00";
        }
        // 采用 DateTimeFormatter.ISO_LOCAL_DATE_TIME 原因是在java 命令传参过程中。数据中间带有空格在windows系统中，会出现错误。
        // 采用 ISO_LOCAL_DATE_TIME yyyy-MM-ddTHH:mm:ss:SSS 可以抵消空格带来的影响
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String[] command = buildCommand(lastTime,currentTime);
        for (String com:command) {
            log.info("Prepare run command {}", com);
        }
        LogStatistics logStatistics = null;
        try {
            Runtime run = Runtime.getRuntime();
            final Process process = run.exec(command);
            logStatistics  = analysisStatisticsLog(new BufferedInputStream(process.getInputStream()));
            //analysisStatisticsLog(new BufferedInputStream(process.getErrorStream()));
        } catch (IOException e) {
            log.error("Run command Filed {}!", e);
            return "Datax datax.py exec Fail:"+e.getMessage();
        }
        redisTemplate.opsForValue().set(KeyConstants.KEY_UPDATE_TIME, currentTime);
        log.info("datax Transmission result :{}",logStatistics.toString());
        log.info("****************   datax Transmission complete!   ********************");
        return "success";
    }

    private String[] buildCommand(String lastTime,String currentTime){
        log.info("param get Time {}",lastTime);
        // 如果没有获取到上次更新的时间，那么进行全量更新。
        // 如果需要设置时间。请自行设置
        if (StringUtils.isEmpty(lastTime)) {
            lastTime = "1970-01-01T00:00:00:000";
        }
        dataxPropertis.getParams().setLastTime(lastTime);
        dataxPropertis.getParams().setCurrentTime(currentTime);
        String paramsStr = dataxPropertis.getParams().convertParams();
        // 执行命令 ，格式相对比较严格。在windows和linux中会有不同。
        // 以下方法比较通用，
        String[] command = {"python"
                , dataxPropertis.getPath()
                , "-p", paramsStr
                , dataxPropertis.getJobid()};
        return   command ;
    }


    /**
     * 临时调试调度。Xxjob 在开发过程中不方便 。直接使用scheduled 代替来进行调试
     */
    //@Scheduled(initialDelay = 5000,fixedRate = 60000)
    public void localTest(){
        try {
            execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
