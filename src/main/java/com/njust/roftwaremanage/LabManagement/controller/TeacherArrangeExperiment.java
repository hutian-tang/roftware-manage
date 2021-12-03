package com.njust.roftwaremanage.LabManagement.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 教师安排实验的servlet
 * 响应路径:待定
 * */
public class TeacherArrangeExperiment extends HttpServlet {
    /**
     * 教师在安排实验前应当先查询该时间段是否存在可以选择的实验室
     * 输入参数:周次week(int),星期day(int),开始的节次start(int),结束的节次end(int)
     * 返回参数:List<Message>对象(可能为空)
     *          data属性:classroom对象
     *          data2属性:Boolean(True表示该实验室已经有开放性实验选择，教师如果选择必须共享)
     *
     * */
    public void doGet(HttpServletRequest request, HttpServletResponse response){

    }

    /**
     * 教师安排实验
     * 输入参数:教师id(String),周次week(int),星期day(int),开始的节次start(int),结束的节次end(int)
     *         实验人数num(int),实验类型type(String)是否共享(Boolean),实验室id(List<String>)
     * 输出参数:Message对象
     *          code属性:
     *          mag属性:
     * */
    public void doPost(HttpServletRequest request,HttpServletResponse response){}
}
