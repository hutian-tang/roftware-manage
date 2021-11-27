package com.njust.roftwaremanage.LabManagement.dao;

import com.njust.roftwaremanage.LabManagement.entity.Arrange;

import java.util.List;

public class ArrangeDAO {


    /**
     * 根据id返回对应的实验
     * 输入:id
     * 输出:id对应的Arrange
     * */
    public static Arrange findArrangeById(String id){
        //TODO:
        return null;
    }

    /**
     * 访问数据库，获取所有实验的名字（消除重复）
     * 输出：List<String>
     * */
    public static List<String> getArrangeNames(){
        //TODO:访问数据库
        //TODO:务必使用DISTINCT消除重复
        return null;
    }
}
