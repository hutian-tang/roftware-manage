package com.njust.roftwaremanage.LabManagement.entity;

/** 管理员实体**/
public class Manager {
    private String manager_id;
    private String name;
    private String password;

    public Manager() {
    }

    public Manager(String manager_id, String name, String password) {
        this.manager_id = manager_id;
        this.name = name;
        this.password = password;
    }

    public String getManager_id() {
        return manager_id;
    }

    public void setManager_id(String manager_id) {
        this.manager_id = manager_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
