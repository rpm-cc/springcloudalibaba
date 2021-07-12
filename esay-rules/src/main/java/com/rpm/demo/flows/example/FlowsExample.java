package com.rpm.demo.flows.example;

import com.rpm.demo.config.ThreadPool;
import com.rpm.demo.flows.example.work.DefaultWork;
import com.rpm.demo.rules.example.RuleExample;
import org.jeasy.flows.engine.WorkFlowEngine;
import org.jeasy.flows.engine.WorkFlowEngineBuilder;
import org.jeasy.flows.work.WorkContext;
import org.jeasy.flows.work.WorkReportPredicate;
import org.jeasy.flows.workflow.ConditionalFlow;
import org.jeasy.flows.workflow.ParallelFlow;
import org.jeasy.flows.workflow.RepeatFlow;
import org.jeasy.flows.workflow.SequentialFlow;
import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: Piming Ren
 * @date: 2021/7/9 10:29
 * @version: 1.0
 * @description:
 */
public class FlowsExample {
    static ThreadPoolExecutor executor = ThreadPool.instance();

    public static void main(String[] args) throws FileNotFoundException {

        //conditionFlow();
        //sequentialFlow();
//        for (int i=0;i<100;i++) {
//            parallelFlow();
//            System.out.println("now is :" + i);
//        }
//        System.out.println("end ============");
//        executor.shutdown();
        //repeatFlow();
        readYaml();
    }

    /**
     * 条件流
     */
    public static void conditionFlow() {

        DefaultWork work1 = new DefaultWork("worker1");
        DefaultWork work2 = new DefaultWork("worker2");
        DefaultWork work3 = new DefaultWork("worker3");
        ConditionalFlow conditionalFlow = ConditionalFlow.Builder.aNewConditionalFlow()
                .named("my conditional flow")
                .execute(work1)
                .when(WorkReportPredicate.COMPLETED)
                .then(work2)
                .otherwise(work3)
                .build();
        WorkFlowEngine engine = WorkFlowEngineBuilder.aNewWorkFlowEngine().build();
        engine.run(conditionalFlow, new WorkContext());

    }

    /**
     * 顺序执行流
     */
    public static void sequentialFlow() {
        DefaultWork work1 = new DefaultWork("worker1");
        DefaultWork work2 = new DefaultWork("worker2");
        DefaultWork work3 = new DefaultWork("worker3");
        SequentialFlow sequentialFlow = SequentialFlow.Builder.aNewSequentialFlow()
                .named("my sequential flow ")
                .execute(work1)
                .then(work2)
                .then(work3)
                .build();
        WorkFlowEngine engine = WorkFlowEngineBuilder.aNewWorkFlowEngine().build();
        engine.run(sequentialFlow, new WorkContext());
    }

    /**
     * 并行执行流
     */

    public static void parallelFlow() {


        DefaultWork work1 = new DefaultWork("worker1");
        DefaultWork work2 = new DefaultWork("worker2");
        DefaultWork work3 = new DefaultWork("worker3");
        ParallelFlow parallelFlow = ParallelFlow.Builder.aNewParallelFlow()
                .named("my parallel flow")
                .execute(work1, work2, work3)
                .with(executor)
                .build();
        WorkFlowEngine engine = WorkFlowEngineBuilder.aNewWorkFlowEngine().build();
        engine.run(parallelFlow, new WorkContext());


    }

    public static void repeatFlow() {
        DefaultWork work1 = new DefaultWork("worker1");
        RepeatFlow repeatFlow = RepeatFlow.Builder.aNewRepeatFlow()
                .named("excute work 3 toime ")
                .repeat(work1)
                //次数条件
                .times(3)
                //循环条件
                //.until(WorkReportPredicate.ALWAYS_TRUE)
                .build();
        WorkFlowEngine engine = WorkFlowEngineBuilder.aNewWorkFlowEngine().build();
        engine.run(repeatFlow, new WorkContext());


    }

    public static void readYaml() throws FileNotFoundException {
        Yaml yaml = new Yaml();
        Object object = yaml.load(new FileReader(new RuleExample().getClass().getResource("/flow/sequential-flow.yml").getFile()));

        System.out.println(object);


    }

}
