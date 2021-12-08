package com.njust.roftwaremanage.LabManagement.controller;


import com.njust.roftwaremanage.LabManagement.dao.MachineDAO;
import com.njust.roftwaremanage.LabManagement.entity.Machine;
import com.njust.roftwaremanage.LabManagement.entity.Table;
import com.njust.roftwaremanage.LabManagement.service.MachineService;
import com.njust.roftwaremanage.LabManagement.tools.Message;

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
     *      code属性:0-成功,-1-失败
     *      mag属性:对应的code内容
     * */
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        //获取参数
        String tableId = request.getParameter("tableId");
        String address = request.getParameter("address");
        Machine machine = MachineService.findMachineByAddressAndId(tableId,address);
        MachineService machineService = new MachineService();
        Boolean flag = machineService.machineFeedBack(machine);
        Message message = new Message();
        if(flag){
            message.setCode(0);
            message.setMsg("报修成功");
        }
        else{
            message.setCode(-1);
            message.setMsg("报修失败！机器已经损坏！请联系管理员修复！");
        }
        request.setAttribute("message",message);
    }
}
