package com.njust.roftwaremanage.LabManagement.controller;


import com.njust.roftwaremanage.LabManagement.entity.Table;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理学生对实验的反馈
 * 响应路径:待定
 * */
public class StudentFeedbackExperiment extends HttpServlet {
    /**
     * 处理学生对机器的报修功能
     * 输入:座位号tableId(int),房间号address(String)
     * 输出:Message对象
     *      code属性:
     *      mag属性:
     * */
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        //获取参数
        String tableId = request.getParameter("tableId");
        String address = request.getParameter("address");
        
    }
}
