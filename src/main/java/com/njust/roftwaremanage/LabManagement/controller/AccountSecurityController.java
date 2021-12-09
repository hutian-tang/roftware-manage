package com.njust.roftwaremanage.LabManagement.controller;

import com.njust.roftwaremanage.LabManagement.entity.Manager;
import com.njust.roftwaremanage.LabManagement.entity.Student;
import com.njust.roftwaremanage.LabManagement.entity.Teacher;
import com.njust.roftwaremanage.LabManagement.service.ManagerService;
import com.njust.roftwaremanage.LabManagement.service.StudentService;
import com.njust.roftwaremanage.LabManagement.service.TeacherService;
import com.njust.roftwaremanage.LabManagement.tools.Message;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 账户安全相关的servlet
 * 响应路径：待定
 * */
public class AccountSecurityController extends HttpServlet {
    /**
     * 处理用户的修改密码请求
     * 输入:用户id(String),用户角色role(String),旧密码oldPassword(String),新密码newPassword(String)
     * 输出:Message对象
     *      code属性:0-成功,-1-原密码错误
     *      mag属性:对应的错误内容
     * */
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        String role = request.getParameter("role");
        String old = request.getParameter("oldPassword");
        String password = request.getParameter("newPassword");
        boolean flag = false;       //表示是否修改成功
        if(role.equals("student")){
            Student student = StudentService.login(id,old);
            //不为null则表示旧密码正确
            if(student != null){
                //修改密码
                StudentService.changePassword(student,password);
                flag = true;
            }
        }
        else if(role.equals("teacher")){
            Teacher teacher = TeacherService.login(id,old);
            if(teacher != null){
                TeacherService.changePassword(teacher,password);
                flag = true;
            }
        }
        else if(role.equals("manager")){
            Manager manager = ManagerService.login(id,old);
            if(manager != null){
                ManagerService.changePassword(manager,password);
                flag = true;
            }
        }
        Message message = new Message();
        if(flag){
            message.setCode(0);
            message.setMsg("修改密码成功");
        }
        else{
            message.setCode(-1);
            message.setMsg("原密码错误");
        }
        request.setAttribute("message",message);
        //TODO:重定向到登录界面
    }
}
