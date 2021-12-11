package com.njust.roftwaremanage.LabManagement.controller;

import com.njust.roftwaremanage.LabManagement.dao.TableDAO;
import com.njust.roftwaremanage.LabManagement.entity.Arrange;
import com.njust.roftwaremanage.LabManagement.entity.Table;
import com.njust.roftwaremanage.LabManagement.service.ArrangeService;
import com.njust.roftwaremanage.LabManagement.service.TableService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 响应学生退课的servlet
 * 路径：暂未设置
 * */
public class
StudentCancelExperiment extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){}

    /**
     * 学生退选实验
     * 输入：学生id(String),实验id(String)
     * 输出: 没有输出
     * */
    public void doPost(HttpServletRequest request,HttpServletResponse response){
        String studentId = request.getParameter("studentId");
        String arrangeId= request.getParameter("arrangeId");
        //找到对应的table
        Table table = TableService.findTableByStudentIdAndArrangeId(studentId,arrangeId);
        //删除预定的座位
        TableService.cancelTable(table);
        try {
            response.sendRedirect("showExp.jsp?studentId="+studentId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
