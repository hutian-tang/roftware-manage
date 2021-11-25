package com.njust.roftwaremanage.LabManagement.service;

import com.njust.roftwaremanage.LabManagement.dao.StudentDAO;
import com.njust.roftwaremanage.LabManagement.entity.Student;

public class StudentService {
    private final static StudentDAO studentDAO = new StudentDAO();

    public static Student login(String id,String password){
        Student student = studentDAO.findById(id);
        if(student != null){
            if(!password.equals(student.getPassword())){
                return null;
            }
        }
        return student;
    }
}
