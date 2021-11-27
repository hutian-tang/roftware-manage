package com.njust.roftwaremanage.LabManagement.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 学生选课的servlet
 * 响应路径：待定
 * */
public class ViewExperimentDetail extends HttpServlet {

    /**
     * 获取一个实验（实验名相同即视为同一个实验）的不同排课时间段
     * 传入参数：学生id,实验名name
     * 传出参数：HashMap<String,Message>对象
     *          String为该实验的id
     *          Message对象的data属性为Arrange对象，包含该实验的具体信息
     *                      code属性为该实验的状态，1为可选，0为已经选择，-1为人数已满，-2为已过时间，-3为已选其它实验
     *                      mag中存储了实验状态对应的具体错误信息
     *                      注意：学生不能选择同名的2个实验，当学生已经选择一个实验时，其它实验的状态均为-3
     * */
    public void doGet(HttpServletRequest request, HttpServletResponse response){

    }
}
