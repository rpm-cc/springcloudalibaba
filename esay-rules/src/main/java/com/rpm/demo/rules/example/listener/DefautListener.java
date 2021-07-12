package com.rpm.demo.rules.example.listener;

import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.RuleListener;

/**
 * @author: Piming Ren
 * @date: 2021/7/8 13:51
 * @version: 1.0
 * @description:
 */
@Slf4j
public class DefautListener implements RuleListener {
    @Override
    public boolean beforeEvaluate(Rule rule, Facts facts) {
        return true;
    }

    @Override
    public void afterEvaluate(Rule rule, Facts facts, boolean evaluationResult) {
       log.info("afterEvaluate");
        if (!evaluationResult){
            log.info("没有匹配成功");
        }
    }

    @Override
    public void onEvaluationError(Rule rule, Facts facts, Exception exception) {
        log.error("onEvaluationError");
    }

    @Override
    public void beforeExecute(Rule rule, Facts facts) {
        log.info("beforeExecute");
    }

    @Override
    public void onSuccess(Rule rule, Facts facts) {
        log.info("onSuccess");
    }

    @Override
    public void onFailure(Rule rule, Facts facts, Exception exception) {
        log.error("onFailure");
    }
}
