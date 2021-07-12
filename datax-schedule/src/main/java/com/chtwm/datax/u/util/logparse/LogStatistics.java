package com.chtwm.datax.u.util.logparse;

import java.io.Serializable;

/**
 *  这个类是抄的datax-web ,源码中没有写作者！
 */
public class LogStatistics implements Serializable {


    /**
     * DataX任务启动时刻
     */
    private String taskStartTime;

    /**
     * DataX任务结束时刻
     */
    private String taskEndTime;

    /**
     * DataX任务总计耗时
     */
    private String taskTotalTime;

    /**
     * DataX任务平均流量
     */
    private String taskAverageFlow;

    /**
     * DataX记录写入速度
     */
    private String taskRecordWritingSpeed;

    /**
     * DataX读出记录总数
     */
    private int taskRecordReaderNum;
    /**
     * DataX读写失败总数
     */
    private int taskRecordWriteFailNum;


    public String getTaskStartTime() {
        return taskStartTime;
    }

    public void setTaskStartTime(String taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    public String getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(String taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

    public String getTaskTotalTime() {
        return taskTotalTime;
    }

    public void setTaskTotalTime(String taskTotalTime) {
        this.taskTotalTime = taskTotalTime;
    }

    public String getTaskAverageFlow() {
        return taskAverageFlow;
    }

    public void setTaskAverageFlow(String taskAverageFlow) {
        this.taskAverageFlow = taskAverageFlow;
    }

    public String getTaskRecordWritingSpeed() {
        return taskRecordWritingSpeed;
    }

    public void setTaskRecordWritingSpeed(String taskRecordWritingSpeed) {
        this.taskRecordWritingSpeed = taskRecordWritingSpeed;
    }

    public int getTaskRecordReaderNum() {
        return taskRecordReaderNum;
    }

    public void setTaskRecordReaderNum(int taskRecordReaderNum) {
        this.taskRecordReaderNum = taskRecordReaderNum;
    }

    public int getTaskRecordWriteFailNum() {
        return taskRecordWriteFailNum;
    }

    public void setTaskRecordWriteFailNum(int taskRecordWriteFailNum) {
        this.taskRecordWriteFailNum = taskRecordWriteFailNum;
    }

    @Override
    public String toString() {
        return "\nLogStatistics{" +
                "  \n           taskStartTime=" + taskStartTime +
                ", \n           taskEndTime=" + taskEndTime +
                ", \n           taskTotalTime=" + taskTotalTime +
                ", \n           taskAverageFlow=" + taskAverageFlow +
                ", \n           taskRecordWritingSpeed=" + taskRecordWritingSpeed +
                ", \n           taskRecordReaderNum=" + taskRecordReaderNum +
                ", \n           taskRecordWriteFailNum=" + taskRecordWriteFailNum +
                "\n             }";
    }
}
