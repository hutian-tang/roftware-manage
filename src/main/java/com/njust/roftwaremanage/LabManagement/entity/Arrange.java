package com.njust.roftwaremanage.LabManagement.entity;
import java.util.Date;

/** 排课信息实体**/
public class Arrange {
    private String arrange_id;
    private int week;               //周次
    private int day;                //日期
    private int start;              //开始节次
    private int end;                //结束节次
    private String name_exp;       //实验名称
    private String address;        //房间号
    private String teacher_id;     //所属教师id
    private int number_use;        //使用机器数（开放性实验不填）
    private int number_selected;   //已选人数
    private boolean isShared;      //是否共享，true为可共享
    private String type;           //实验类型

    public Arrange() {
    }

    public Arrange( int week, int day, int start, int end, String name_exp, String address, String teacher_id, int number_use, boolean isShared) {

        this.week = week;
        this.day = day;
        this.start = start;
        this.end = end;
        this.name_exp = name_exp;
        this.address = address;
        this.teacher_id = teacher_id;
        this.number_use = number_use;
        this.isShared = isShared;

        number_selected = 0;
    }

    public Arrange(String arrange_id, int week, int day, int start, int end, String name_exp, String address, String teacher_id, int number_use, int number_selected, boolean isShared, String type) {
        this.arrange_id = arrange_id;
        this.week = week;
        this.day = day;
        this.start = start;
        this.end = end;
        this.name_exp = name_exp;
        this.address = address;
        this.teacher_id = teacher_id;
        this.number_use = number_use;
        this.number_selected = number_selected;
        this.isShared = isShared;
        this.type = type;
    }

    public String getArrange_id() {
        return arrange_id;
    }

    public void setArrange_id(String arrange_id) {
        this.arrange_id = arrange_id;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getName_exp() {
        return name_exp;
    }

    public void setName_exp(String name_exp) {
        this.name_exp = name_exp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getNumber_use() {
        return number_use;
    }

    public void setNumber_use(int number_use) {
        this.number_use = number_use;
    }

    public int getNumber_selected() {
        return number_selected;
    }

    public void setNumber_selected(int number_selected) {
        this.number_selected = number_selected;
    }

    public boolean isShared() {
        return isShared;
    }

    public void setShared(boolean shared) {
        isShared = shared;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
