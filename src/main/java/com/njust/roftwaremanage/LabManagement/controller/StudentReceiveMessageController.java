package com.njust.roftwaremanage.LabManagement.controller;

import com.njust.roftwaremanage.LabManagement.entity.Mag;
import com.njust.roftwaremanage.LabManagement.service.MagService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentReceiveMessageController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response){
        //获取学生id
        String studentId = request.getParameter("studentId");
        //查找数据库中对应的msg
        Mag mag = MagService.getMagById("student",studentId);
        request.setAttribute("mag", mag);
    }
}
