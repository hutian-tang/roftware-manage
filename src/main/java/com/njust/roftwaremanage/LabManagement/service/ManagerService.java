package com.njust.roftwaremanage.LabManagement.service;

import com.njust.roftwaremanage.LabManagement.dao.ManagerDAO;
import com.njust.roftwaremanage.LabManagement.entity.Manager;

public class ManagerService {
    private final static ManagerDAO managerDAO = new ManagerDAO();

    public static Manager login(String id,String password){
        Manager manager = managerDAO.findById(id);
        if(manager != null){
            if(!password.equals(manager.getPassword()))
                return null;
        }
        return manager;
    }
}
