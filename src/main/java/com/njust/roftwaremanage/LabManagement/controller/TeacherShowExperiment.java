package com.njust.roftwaremanage.LabManagement.controller;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 展示教师实验课表的servlet
 * 响应路径：待定
 * */
public class TeacherShowExperiment extends HttpServlet {
    /**
     * 显示教师待上课的实验课表
     * 输入参数:教师id(String)
     * 输出参数:List<Message>对象(可能为空)
     *          data属性:arrange对象
     * */
    public void doGet(HttpServletRequest request, HttpServletResponse response){

    }
    /**
     * 教师查看某一实验的详细选课情况(查看已经选择的学生姓名和座位号)
     * 输入参数:教师id(String),实验id(String)
     * 输出参数:List<Message>对象(可能为空)
     *          data属性:Student
     *          data2属性:Table(对应学生的座位号)
     * */
    public void doPost(HttpServletRequest request,HttpServletResponse response){}
}

