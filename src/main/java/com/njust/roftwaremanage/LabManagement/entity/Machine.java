package com.njust.roftwaremanage.LabManagement.entity;

/** 机器实体**/
public class Machine {
    private String machine_id;
    private String address;
    private String condition;

    public Machine() {
    }

    public Machine(String machine_id, String address, String condition) {
        this.machine_id = machine_id;
        this.address = address;
        this.condition = condition;
    }

    public String getMachine_id() {
        return machine_id;
    }

    public void setMachine_id(String machine_id) {
        this.machine_id = machine_id;
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
}
