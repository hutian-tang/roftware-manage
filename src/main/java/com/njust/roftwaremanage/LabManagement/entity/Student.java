package com.njust.roftwaremanage.LabManagement.entity;

/** 学生实体 **/
public class Student {
    private String student_id;
    private String name;
    private String class_id;
    private String department;
    private String password;

    public Student() {
    }

    public Student(String student_id, String name, String class_id, String department, String password) {
        this.student_id = student_id;
        this.name = name;
        this.class_id = class_id;
        this.department = department;
        this.password = password;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
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
