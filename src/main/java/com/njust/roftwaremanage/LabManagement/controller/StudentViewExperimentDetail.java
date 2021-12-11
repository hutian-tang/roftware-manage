package com.njust.roftwaremanage.LabManagement.controller;

import com.njust.roftwaremanage.LabManagement.entity.Arrange;
import com.njust.roftwaremanage.LabManagement.service.StudentService;
import com.njust.roftwaremanage.LabManagement.service.TeacherService;
import com.njust.roftwaremanage.LabManagement.tools.Message;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 学生选课的servlet
 * 响应路径：待定
 * */
public class StudentViewExperimentDetail extends HttpServlet {

    /**
     * 获取一个实验（实验名相同即视为同一个实验）的不同排课时间段
     * 传入参数：学生id,实验名name
     * 传出参数：List<Message>对象
     *          code属性:该实验的状态，1为可选，0为已经选择，-1为人数已满，-2为已过时间，-3为已选其它实验
     *          注意：学生不能选择同名的2个实验，当学生已经选择一个实验时，其它实验的状态均为-3
     *          mag属性:实验状态对应的具体错误信息
     *          data属性:该实验对象(Arrange)
     *          data2属性:该实验的任课教师名字(String)
     *          data3属性：该实验的任课教师所属学院(String)
     * */
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        //获取信息
        String experimentName = request.getParameter("name");
        String studentId = request.getParameter("id");
        //查看该学生的实验选择信息
        StudentService studentService = new StudentService();
        HashMap<String, Message> arrangeDetails = studentService.getArrangeDetails(studentId,experimentName);
        List<Message> messageList = new ArrayList<>();
        //遍历HashMap获取信息,重新封装
        for(HashMap.Entry<String,Message> map : arrangeDetails.entrySet()){
            Message origin = map.getValue();
            Message result = new Message();
            result.setCode(origin.getCode());
            result.setMsg(origin.getMsg());
            Arrange originArrange = (Arrange) origin.getData();
            result.setData(originArrange);
            result.setData2(TeacherService.getNameById(originArrange.getTeacher_id()));
            result.setData3(TeacherService.getDepartmentById(originArrange.getTeacher_id()));
            messageList.add(result);
        }
        //传出信息
        request.setAttribute("ExperimentDetail",messageList);
    }
}
