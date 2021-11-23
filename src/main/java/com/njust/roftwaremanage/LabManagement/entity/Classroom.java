package com.njust.roftwaremanage.LabManagement.entity;

/** 实验室实体**/
public class Classroom {
    private String address;     //房间号
    private String manager_id;
    private int number_valid;
    private int number_total;

    public Classroom() {
    }

    public Classroom(String address, String manager_id, int number_valid, int number_total) {
        this.address = address;
        this.manager_id = manager_id;
        this.number_valid = number_valid;
        this.number_total = number_total;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getManager_id() {
        return manager_id;
    }

    public void setManager_id(String manager_id) {
        this.manager_id = manager_id;
    }

    public int getNumber_valid() {
        return number_valid;
    }

    public void setNumber_valid(int number_valid) {
        this.number_valid = number_valid;
    }

    public int getNumber_total() {
        return number_total;
    }

    public void setNumber_total(int number_total) {
        this.number_total = number_total;
    }
}
