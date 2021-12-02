package com.njust.roftwaremanage.LabManagement.service;

import com.njust.roftwaremanage.LabManagement.dao.TeacherDAO;
import com.njust.roftwaremanage.LabManagement.entity.Teacher;


public class TeacherService {
    private final static TeacherDAO teacherDAO = new TeacherDAO();

    /**
     * 用户登录
     * 输入：id,password
     * 输出: 成功：Teacher对象
     *      失败：null
     * */
    public static Teacher login(String id ,String password){
        Teacher teacher = teacherDAO.findTeacherById(id);
        if(teacher != null){
            if(!password.equals(teacher.getPassword())){
                return null;
            }
        }
        return teacher;
    }

    /**
     * 根据id查找教师
     * 输入：id
     * 输出: 成功：Teacher对象
     *      失败：null
     * */
    public static Teacher findById(String id){
        return teacherDAO.findTeacherById(id);
    }

    /**
     * 根据id获取教师姓名
     * 输入：id
     * 输出: 成功：String
     *      失败："NULL"
     * */
    public static String getNameById(String id){
        Teacher teacher = teacherDAO.findTeacherById(id);
        if(teacher == null){
            return "NULL";
        }
        else{
            return teacher.getName();
        }
    }

    /**
     * 根据id获取教师所属学院
     * 输入：id
     * 输出: 成功：String
     *      失败："NULL"
     * */
    public static String getDepartmentById(String id){
        Teacher teacher = teacherDAO.findTeacherById(id);
        if(teacher == null){
            return "NULL";
        }
        else{
            return teacher.getDepartment();
        }
    }
}
