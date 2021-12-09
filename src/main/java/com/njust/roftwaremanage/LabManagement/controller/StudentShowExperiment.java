package com.njust.roftwaremanage.LabManagement.controller;

import com.njust.roftwaremanage.LabManagement.entity.Arrange;
import com.njust.roftwaremanage.LabManagement.entity.Table;
import com.njust.roftwaremanage.LabManagement.entity.Teacher;
import com.njust.roftwaremanage.LabManagement.service.ArrangeService;
import com.njust.roftwaremanage.LabManagement.service.TableService;
import com.njust.roftwaremanage.LabManagement.service.TeacherService;
import com.njust.roftwaremanage.LabManagement.tools.Message;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


/**
 * 展示学生实验课表的servlet
 * 响应路径：待定
 * */
public class StudentShowExperiment extends HttpServlet {
    /**
     * 显示学生待做的实验课表
     * 输入：学生id(String)
     * 输出：List<Message>对象(可能为null)
     *          data属性：Table（选课和座位信息）
     *          data2属性：Arrange（实验信息）
     *          data3属性：Teacher（实验对应的教师信息）
     * */
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        String studentId = request.getParameter("studentId");
        List<Message> messageList = new ArrayList<>();
        //根据studentId查找验对应的实
        List<Table> tableList = TableService.findTableByStudentId(studentId);
        if(tableList!= null){
            //此时的table可能包含了已经做过的实验，需要去查table对应的arrange判断时间
            for(Table table:tableList){
                Arrange arrange = ArrangeService.getArrangesById(table.getArrange_id());
                //todo:判断系统时间是否超过了实验结束时间
                Teacher teacher = TeacherService.findById(arrange.getTeacher_id());
                Message message = new Message();
                message.setData(table);
                message.setData2(arrange);
                message.setData3(teacher);
            }
        }
        //传递数据
        request.setAttribute("message",messageList);
    }
}
