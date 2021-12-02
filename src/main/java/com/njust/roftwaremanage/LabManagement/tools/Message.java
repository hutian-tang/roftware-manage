package com.njust.roftwaremanage.LabManagement.tools;


/**
 * 返回给前端的消息类
 * */
public class Message {
    private int code;   //错误码，1表示无错误
    private String msg; //错误信息
    private Object data = "";   //额外包含在message中的对象
    private Object data2 = "";   //额外包含在message中的对象
    private Object data3 = "";   //额外包含在message中的对象
    private Object data4 = "";   //额外包含在message中的对象

    public Message() {
    }

    public Message(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Message(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Object getData2() {
        return data2;
    }

    public void setData2(Object data2) {
        this.data2 = data2;
    }

    public Object getData3() {
        return data3;
    }

    public void setData3(Object data3) {
        this.data3 = data3;
    }

    public Object getData4() {
        return data4;
    }

    public void setData4(Object data4) {
        this.data4 = data4;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
