package com.njust.roftwaremanage.LabManagement.entity;

/** 学生选择实验的信息实体**/
public class Table {
    int table_id;       //学生座位号
    String address;     //房间号
    String condition;   //机器状况
    String arrange_id;  //排课编号
    String student_id;  //学生学号

    public Table() {
    }

    public Table(int table_id, String address, String condition, String arrange_id, String student_id) {
        this.table_id = table_id;
        this.address = address;
        this.condition = condition;
        this.arrange_id = arrange_id;
        this.student_id = student_id;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getArrange_id() {
        return arrange_id;
    }

    public void setArrange_id(String arrange_id) {
        this.arrange_id = arrange_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }
}
