package com.njust.roftwaremanage.LabManagement.service;

import com.njust.roftwaremanage.LabManagement.dao.ArrangeDAO;
import com.njust.roftwaremanage.LabManagement.entity.Arrange;

import java.util.ArrayList;
import java.util.List;

public class ArrangeService {

    /**
     * 获取所有实验的名字
     * 输出：List<String>
     * */
    public static List<String> getArrangeNames(){
        List<String> names = new ArrayList<>();
        names = ArrangeDAO.getArrangeNames();
        return null;
    }
}
