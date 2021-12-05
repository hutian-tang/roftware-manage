package com.njust.roftwaremanage.LabManagement.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
     *        code属性：
     *        mag属性：
     *        data属性：Table对象(如果为选课失败则为null)
     * */
    public void doPost(HttpServletRequest request,HttpServletResponse response){
        String studentId = request.getParameter("studentId");
        String arrangeId = request.getParameter("arrangeId");
        //学生选课
        
    }
}
