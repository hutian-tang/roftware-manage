package com.njust.roftwaremanage.LabManagement.service;

import com.njust.roftwaremanage.LabManagement.dao.ArrangeDAO;
import com.njust.roftwaremanage.LabManagement.dao.StudentDAO;
import com.njust.roftwaremanage.LabManagement.dao.TableDAO;
import com.njust.roftwaremanage.LabManagement.entity.Arrange;
import com.njust.roftwaremanage.LabManagement.entity.Student;
import com.njust.roftwaremanage.LabManagement.entity.Table;

import java.util.HashMap;
import java.util.List;

public class StudentService {
    private final static StudentDAO studentDAO = new StudentDAO();

    /**
     * 用户登录
     * 输入：id,password
     * 输出: 成功：Student对象
     *      失败：null
     * */
    public static Student login(String id,String password){
        Student student = studentDAO.findById(id);
        if(student != null){
            if(!password.equals(student.getPassword())){
                return null;
            }
        }
        return student;
    }

    /**
     * 获取该学生的实验列表
     * 传入参数：学生id
     * 传出参数：HashMap<String,Boolean>对象
     *         String为实验的名字
     *         Boolean对该实验学生是否已经选择，true为已经选择
     * */
    public HashMap<String,Boolean> getArranges(String id){
        HashMap<String,Boolean> names = new HashMap<>();
        //获取所有的实验列表
        List<String> arrangeNames = ArrangeService.getArrangeNames();
        //初始化HashMap
        if (arrangeNames != null) {
            for(String s: arrangeNames){
                names.put(s,false);
            }
        }
        //遍历选课信息，查看学生选了哪些实验
        List<Table> tableList = TableDAO.findTableByStudentId(id);
        if (tableList != null) {
            for(Table t:tableList){
                //查找对应的实验
                String arrangeId = t.getArrange_id();
                Arrange arrange = ArrangeDAO.findArrangeById(arrangeId);
                if (arrange != null) {
                    names.put(arrange.getName_exp(),true);
                }
            }
        }
        return names;
    }
}
