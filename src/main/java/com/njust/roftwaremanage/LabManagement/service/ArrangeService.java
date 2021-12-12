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
        return names;
    }

    /**
     * 根据实验名字查找实验列表
     * 输入:实验名字(String)
     * 输出:实验对象(List<Arrange>)
     */
    public static List<Arrange> getArrangesByName(String name){
        List<Arrange> arrangeList = new ArrayList<>();
        arrangeList = ArrangeDAO.findArrangeByName(name);
        return arrangeList;
    }

    /**
     * 根据实验id查找实验
     * 输入:实验id(String)
     * 输出:实验对象(Arrange)
     */
    public static Arrange getArrangesById(String id){
        return ArrangeDAO.findArrangeById(Integer.parseInt(id));
    }
}
