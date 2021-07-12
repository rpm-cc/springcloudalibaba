package com.rpm.demo.rules.example.listener;

import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngineListener;

/**
 * @author: Piming Ren
 * @date: 2021/7/8 14:52
 * @version: 1.0
 * @description:
 */
@Slf4j
public class DefalutEngineListener implements RulesEngineListener {
    @Override
    public void beforeEvaluate(Rules rules, Facts facts) {
          log.info("beforeEvaluate");
    }

    @Override
    public void afterExecute(Rules rules, Facts facts) {
        log.info("afterExecute");
    }
}
