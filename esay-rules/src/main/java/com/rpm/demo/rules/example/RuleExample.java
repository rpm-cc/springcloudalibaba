package com.rpm.demo.rules.example;

import com.rpm.demo.rules.example.listener.DefalutEngineListener;
import com.rpm.demo.rules.example.listener.DefautListener;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.RuleDefinition;
import org.jeasy.rules.support.reader.YamlRuleDefinitionReader;
import org.yaml.snakeyaml.Yaml;

import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/7/8 9:03
 * @version: 1.0
 * @description:
 */
public class RuleExample {

    public static void main(String[] args) throws Exception {

         mvelRule();
        // unit();
//         active();
//         condition();

    }

    public static void mvelRule() throws Exception{
        DefaultRulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.registerRuleListener(new DefautListener());
        rulesEngine.registerRulesEngineListener(new DefalutEngineListener());
        MVELRuleFactory ruleFactory  = new MVELRuleFactory(new YamlRuleDefinitionReader());
       // Rules rules = ruleFactory.createRules(new FileReader( new Example().getClass().getResource("/rules/mvel-rule.yml").getFile()));
        Rules rules = ruleFactory.createRules(new StringReader(yaml()));
        Facts facts  = new Facts();
        facts.put("rain",true);
        facts.put("config" ,true);
        rulesEngine.fire(rules,facts);
    }

    /**
     * 每个rule都满足条件执行
     * @throws Exception
     */
    public static void unit() throws Exception {
        DefaultRulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.registerRuleListener(new DefautListener());
        rulesEngine.registerRulesEngineListener(new DefalutEngineListener());
        MVELRuleFactory ruleFactory  = new MVELRuleFactory(new YamlRuleDefinitionReader());
        Rules rules=   ruleFactory.createRules(new FileReader( new RuleExample().getClass().getResource("/rules/unit-rule.yml").getFile()));
        Facts facts  = new Facts();
        facts.put("age",27);
        facts.put("sex",2);
        rulesEngine.fire(rules,facts);
    }

    /**
     * 第一个条件满足就停止，类似与switch case
     * @throws Exception
     */
    public static void active() throws Exception {
        DefaultRulesEngine rulesEngine = new DefaultRulesEngine();
        MVELRuleFactory ruleFactory  = new MVELRuleFactory(new YamlRuleDefinitionReader());
        Rules rules=   ruleFactory.createRules(new FileReader( new RuleExample().getClass().getResource("/rules/active-rule.yml").getFile()));
        Facts facts  = new Facts();
        facts.put("age",27);
        facts.put("sex",1);
        rulesEngine.fire(rules,facts);
    }

    /**
     * 当优先级最高的条件满足时，才去匹配其他的条件
     * @throws Exception
     */
    public static void condition() throws Exception {
        DefaultRulesEngine rulesEngine = new DefaultRulesEngine();
        MVELRuleFactory ruleFactory  = new MVELRuleFactory(new YamlRuleDefinitionReader());
        Rules rules=   ruleFactory.createRules(new FileReader( new RuleExample().getClass().getResource("/rules/condition-rule.yml").getFile()));
        Facts facts  = new Facts();
        facts.put("age",27);
        facts.put("sex",1);
        facts.put("con",true);
        rulesEngine.fire(rules,facts);
    }


    /**
     * 生成yam文件
     *
     */

    public static String yaml(){
        Yaml yaml  = new Yaml();



        RuleDefinition definition = new RuleDefinition();
        definition.setName("config");
        definition.setDescription("如果基金的连续收益为正超过5天");
        definition.setCondition("rain==true");
        List<String> actions = new ArrayList<>();
        actions.add("System.out.println(\"haha\")");
        definition.setActions(actions);

        RuleDefinition definition2 = new RuleDefinition();
        definition2.setName("config2");
        definition2.setDescription("1");
        definition2.setCondition("config==true");
        List<String> actions2 = new ArrayList<>();
        actions2.add("System.out.println(\"haha222222222222222222\")");
        definition2.setActions(actions2);


        List<RuleDefinition> definitions = new ArrayList<>();
        definitions.add(definition);
        definitions.add(definition2);


        RuleDefinition unitDefinition = new RuleDefinition();
        unitDefinition.setName("unit");
        unitDefinition.setDescription("its me");
        unitDefinition.setPriority(1);
        unitDefinition.setCompositeRuleType("UnitRuleGroup");
        unitDefinition.setComposingRules(definitions);

        System.out.println(yaml.dumpAsMap(unitDefinition));


        //生成的字符串可以保存在数据库中作为一个规则
        return  yaml.dumpAsMap(unitDefinition);
    }


}
