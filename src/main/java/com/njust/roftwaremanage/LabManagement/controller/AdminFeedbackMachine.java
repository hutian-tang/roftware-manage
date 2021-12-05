package com.njust.roftwaremanage.LabManagement.controller;

import com.njust.roftwaremanage.LabManagement.entity.Machine;
import com.njust.roftwaremanage.LabManagement.service.MachineService;
import com.njust.roftwaremanage.LabManagement.tools.Message;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 管理员进行损坏的机器维修的servlet
 *
 * */
public class AdminFeedbackMachine extends HttpServlet {
    /**
     * 显示已经报修但还未进行处理的机器
     * 输出:List<Machine>(可能为null)
     * */
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        List<Machine> brokenMachines = MachineService.getBrokenMachines();
        request.setAttribute("machine",brokenMachines);
    }

    /**
     * 对已经修复完成的机器进行处理
     * 输入:machineId,Address
     * 输出:Message对象
     *      code:0成功；-1失败
     *      msg:code状态属性的详细说明
     * */
    public void doPost(HttpServletRequest request,HttpServletResponse response){
        //获取输出
        String machineId = request.getParameter("machineId");
        String address = request.getParameter("address");
        //对机器状态进行更新
        MachineService machineService = new MachineService();
        Boolean flag = machineService.repairMachine(machineId,address);
        Message message = new Message();
        if(flag){
            message.setCode(0);
            message.setMsg("成功");
        }
        else{
            message.setCode(-1);
            message.setMsg("更新状态失败！该机器可能已经修复");
        }
        request.setAttribute("message",message);
    }
}
