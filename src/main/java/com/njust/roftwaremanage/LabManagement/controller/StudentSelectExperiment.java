package com.njust.roftwaremanage.LabManagement.controller;

import com.njust.roftwaremanage.LabManagement.service.StudentService;
import com.njust.roftwaremanage.LabManagement.tools.Message;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 响应学生选课的servlet
 * 路径：暂未设置
 * */
public class StudentSelectExperiment extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){}

    /**
     * 学生选课
     * 输入:学生id(String),实验id(String)
     * 输出：Message对象
     *          code属性：0为成功，-1为人数已满，-2为已过时间，-3为系统错误
     *          mag属性：存储了code对应的具体错误信息
     *          data属性：Table(选课错误时为null)
     * */
    public void doPost(HttpServletRequest request,HttpServletResponse response){
        System.out.println("执行");
        String studentId = request.getParameter("studentId");
        String arrangeId = request.getParameter("arrangeId");
        //学生选课
        StudentService studentService = new StudentService();
        Message message = studentService.selectExperiment(studentId,arrangeId);
        HttpSession session = request.getSession();
        session.setAttribute("selectMessage",message);
        //TODO:前后端相连时注意更改此处
        try {
            response.sendRedirect("showExp.jsp?studentId="+studentId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
