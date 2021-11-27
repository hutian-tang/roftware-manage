package com.njust.roftwaremanage.LabManagement.dao;

import com.njust.roftwaremanage.LabManagement.entity.Table;

import java.util.List;

public class TableDAO {

    /**
     * 根据学生id返回对应的排课信息
     * 输入:studentId
     * 输出:id对应的List<Table>
     * */
    public static List<Table> findTableByStudentId(String studentId){
        //TODO:通过学生id对应的Table
        return null;
    }

    /**
     * 根据学生id和实验id返回对应的排课信息
     * 输入:studentId,arrangeId
     * 输出:Table
     * */
    public static Table findTableByStudentIdAndArrangeId(String studentId,String arrangeId){
        //TODO:通过学生id和实验id找到对应的Table
        return null;
    }
}
