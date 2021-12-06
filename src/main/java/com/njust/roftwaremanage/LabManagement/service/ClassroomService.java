package com.njust.roftwaremanage.LabManagement.service;

import com.njust.roftwaremanage.LabManagement.dao.ClassroomDAO;
import com.njust.roftwaremanage.LabManagement.entity.Classroom;

public class ClassroomService {
    /**
     * 根据address找到对应的教室
     * 输入:address(String)
     * 输出:Classroom对象
     * */
    public static Classroom findByAddress(String address){
        return ClassroomDAO.findClassroomByAddress(address);
    }
}
