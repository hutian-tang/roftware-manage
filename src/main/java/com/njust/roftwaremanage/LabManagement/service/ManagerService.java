package com.njust.roftwaremanage.LabManagement.service;

import com.njust.roftwaremanage.LabManagement.dao.ManagerDAO;
import com.njust.roftwaremanage.LabManagement.entity.Manager;

public class ManagerService {
    private final static ManagerDAO managerDAO = new ManagerDAO();

    /**
     * 用户登录
     * 输入：id,password
     * 输出: 成功：Manager对象
     *      失败：null
     * */
    public static Manager login(String id,String password){
        Manager manager = managerDAO.findManagerById(id);
        if(manager != null){
            if(!password.equals(manager.getPassword()))
                return null;
        }
        return manager;
    }
}
