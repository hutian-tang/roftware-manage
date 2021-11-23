package com.njust.roftwaremanage.LabManagement.entity;

/** 教师实体  **/
public class Teacher {
    private String teacher_id;
    private String name;
    private String department;
    private String password;

    public Teacher() {
    }

    public Teacher(String teacher_id, String name, String department, String password) {
        this.teacher_id = teacher_id;
        this.name = name;
        this.department = department;
        this.password = password;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
