package com.rpm.demo.rules.example.sets;

import com.alibaba.fastjson.JSON;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.RuleListener;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngineListener;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.RuleDefinition;
import org.jeasy.rules.support.reader.JsonRuleDefinitionReader;
import org.jeasy.rules.support.reader.YamlRuleDefinitionReader;
import org.yaml.snakeyaml.Yaml;

import java.io.StringReader;

/**
 * @author: Piming Ren
 * @date: 2021/7/12 9:25
 * @version: 1.0
 * @description:
 */
public class RuleSets {

    private final DefaultRulesEngine rulesEngine = new DefaultRulesEngine();
    private Rules rules;

    /**
     * 注册ruleListener
     * @param ruleListener
     */
    public void registerRuleListener(RuleListener ruleListener) {
        rulesEngine.registerRuleListener(ruleListener);
    }

    /**
     * 注册ruleEngineListener
     * @param rulesEngineListener
     */
    public void registerRuleEngineListener(RulesEngineListener rulesEngineListener) {
        registerRuleEngineListener(rulesEngineListener);
    }


    public void rules(String str,String type) throws Exception {
        //首先验证字符串格式。如果字符串是json 走jsonrule
        if ("是json".isEmpty()){
            jsonRules(str);
            return;
        }
        Yaml yaml = new Yaml();
        if ("是yaml".isEmpty()){
            yamlRules(str);
            return;
        }
        throw new RuntimeException("字符串不能转化为rule");

    }

    /**
     * 根据yaml字符串生成
     * @param yamlString
     * @throws Exception
     */
    private void yamlRules(String yamlString) throws Exception {
        MVELRuleFactory ruleFactory  = new MVELRuleFactory(new YamlRuleDefinitionReader());
        rules=   ruleFactory.createRules(new StringReader(yamlString));
    }

    /**
     * 根据json字符串生成
     * @param json
     * @throws Exception
     */
    private void jsonRules(String json) throws Exception {
        MVELRuleFactory ruleFactory  = new MVELRuleFactory(new JsonRuleDefinitionReader());
        rules=   ruleFactory.createRules(new StringReader(json));
    }

    /**
     * 规则匹配
     * @param facts
     */
    public void fire(Facts facts) {
        rulesEngine.fire(rules,facts);
    }

    /**
     * 获取到最后要存储的规则配置字符串。
     * 使用yaml格式返回
     * @param definition
     * @return
     */
    public String yamlString(RuleDefinition definition){
        if (definition == null){
            return null;
        }
        Yaml yaml  = new Yaml();
        return  yaml.dumpAsMap(definition);

    }

    public static void main(String[] args) throws Exception {
        RuleSets ruleSets = new RuleSets();
        ruleSets.rules("ddddddddddd","json" );
    }

}
