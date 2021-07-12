package com.tencent.wework.domain;

/**
 * @Author PimingRen
 * @Date 2021/5/7
 * @Version 1.0
 * 企业微信填表消息
 */
public class Collect {
    /**
     * 填表消息所在的群名称。String类型
     */
    private String roomName;
    /**
     * 创建者在群中的名字。String类型
     */
    private String creator;
    /**
     * 创建的时间。String类型
     */
    private String createTime;
    /**
     * 表名。String类型
     */
    private String title;
    /**
     * 表内容。json数组类型
     * 包含  id ques type 三个字段
     * todo
     * 可能需要拆分这个类
     */
    private String details;
    /**
     * 表项id。Uint64类型
     */
    private int id;
    /**
     * 表项名称。String类型
     */
    private String ques;
    /**
     * 表项类型，有Text(文本),Number(数字),Date(日期),Time(时间)。String类型
     */
    private String type;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "roomName='" + roomName + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime='" + createTime + '\'' +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", id=" + id +
                ", ques='" + ques + '\'' +
                ", type='" + type + '\'' +
                '}';
    }


}
