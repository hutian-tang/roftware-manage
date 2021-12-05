package com.njust.roftwaremanage.LabManagement.entity;

public class Mag {
    private String id;           //消息的id号
    private String message;      //存储具体的信息内容
    private String type;         //指定消息的发送对象
    private String targetId;     //指定消息的发送对象的id

    public Mag() {
    }

    public Mag(String id, String message, String type, String targetId) {
        this.id = id;
        this.message = message;
        this.type = type;
        this.targetId = targetId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }
}
