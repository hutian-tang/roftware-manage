package com.njust.roftwaremanage.LabManagement.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 展示学生实验课表的servlet
 * 响应路径：待定
 * */
public class StudentShowExperiment extends HttpServlet {
    /**
     * 显示学生待做的实验课表
     * 输入：学生id(String)
     * 输出：List<Message>对象(可能为null)
     *          data属性：Table（选课和座位信息）
     *          data2属性：Arrange（实验信息）
     *          data3属性：Teacher（实验对应的教师信息）
     * */
    public void doGet(HttpServletRequest request, HttpServletResponse response){

    }
}
