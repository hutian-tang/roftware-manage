package com.njust.roftwaremanage.LabManagement.controller;


import com.njust.roftwaremanage.LabManagement.dao.ArrangeDAO;
import com.njust.roftwaremanage.LabManagement.entity.Arrange;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 展示教师实验课表的servlet
 * 响应路径：待定
 * */
@WebServlet(name = "TeacherShowExperiment" , urlPatterns = "/TeacherShowExperiment")
public class TeacherShowExperiment extends HttpServlet {
    /**
     * 显示教师待上课的实验课表
     * 输入参数:教师id(String)
     * 输出参数:List<Message>对象(可能为空)
     *          data属性:arrange对象
     * */
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request,response);
    }
    /**
     * 教师查看某一实验的详细选课情况(查看已经选择的学生姓名和座位号)
     * 输入参数:教师id(String),实验id(String)
     * 输出参数:List<Message>对象(可能为空)
     *          data属性:Student
     *          data2属性:Table(对应学生的座位号)
     * */
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        //request.getSession().setAttribute("teacher_id",1);
        String teacher_id = request.getSession().getAttribute("teacher_id").toString();
        //request.getSession().removeAttribute("teacher_id");
        ArrangeDAO dao = new ArrangeDAO();
        List<Arrange> list1 = dao.findArrangeByteacherId(teacher_id);
        request.setAttribute("list1", list1);
        request.getRequestDispatcher("teacher/experimentshow.jsp").forward(request, response);
    }
}

