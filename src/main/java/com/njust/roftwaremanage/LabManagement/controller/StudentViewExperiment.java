package com.njust.roftwaremanage.LabManagement.controller;


import com.njust.roftwaremanage.LabManagement.entity.Arrange;
import com.njust.roftwaremanage.LabManagement.service.ArrangeService;
import com.njust.roftwaremanage.LabManagement.service.StudentService;
import com.njust.roftwaremanage.LabManagement.tools.Message;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 学生选课的servlet
 * 响应路径：/StudentHome
 * */
public class StudentViewExperiment extends HttpServlet {

    /**
     * 获取实验列表（同名的实验会被归在一起）
     * 传入参数：学生id
     * 传出参数：List<Message>对象
     *          data属性：实验名字（String）
     *          data2属性：实验类型（String）
     *          data3属性：学生是否已经选择该实验(Boolean)，true为已经选择
     *
     * */
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        //获取表单数据
        String id = request.getParameter("id");
        //获取实验列表
        HashMap<String,Boolean> experiment = new HashMap<>();
        StudentService service = new StudentService();
        experiment = service.getArranges(id);
        List<Message> messageList = new ArrayList<>();
        for(Map.Entry<String,Boolean> map: experiment.entrySet()){
            //封装对象
            List<Arrange> tmpList = ArrangeService.getArrangesByName(map.getKey()); //获取实验对象列表
            if(tmpList != null){
                Arrange a = tmpList.get(0); //提取第一个实验封装
                Message message = new Message();
                message.setData(a.getName_exp());
                message.setData2(a.getType());
                message.setData3(map.getValue());
            }
        }
        //传出信息
        request.setAttribute("experiments",messageList);
    }
}
