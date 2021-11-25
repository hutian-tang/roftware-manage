package com.njust.roftwaremanage.LabManagement.service;

import com.njust.roftwaremanage.LabManagement.dao.TeacherDAO;
import com.njust.roftwaremanage.LabManagement.entity.Teacher;

public class TeacherService {
    private final static TeacherDAO teacherDAO = new TeacherDAO();

    public static Teacher login(String id ,String password){
        Teacher teacher = teacherDAO.findById(id);
        if(teacher != null){
            if(!password.equals(teacher.getPassword())){
                return null;
            }
        }
        return teacher;
    }
}
