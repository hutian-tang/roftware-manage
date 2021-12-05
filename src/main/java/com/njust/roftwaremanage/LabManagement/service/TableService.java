package com.njust.roftwaremanage.LabManagement.service;

import com.njust.roftwaremanage.LabManagement.dao.TableDAO;
import com.njust.roftwaremanage.LabManagement.entity.Table;

public class TableService {

    /** 为学生分配选课时的座位
     *  输入:StudentId(String),arrangeId(String),教室名classroom(String),当前已选人数(int)
     *  输出:Table
     * */
    public Table assignSeats(String studentId,String arrangeId, String classroom, int selectedNumber){
        //由于系统为顺序分配，为了提供效率，可以从当前已选人数开始分配位置
        int num = selectedNumber + 1;
        boolean flag = false;       //是否成功分配座位
        while(!flag && num < 200){      //避免死循环
            //判断该机器是否有人
            Table table = TableDAO.findTableByTableIdAndArrangeId(String.valueOf(num),arrangeId);
            if(table == null){
                //如果该实验的座位号返回为空，则说明该位置没有人
                //判断机器是否损坏
                if(MachineService.checkCondition(classroom, String.valueOf(num))){
                    //没有损坏
                    flag = true;
                    //分配座位
                    Table t = new Table();
                    t.setAddress(classroom);
                    t.setCondition("正常");
                    t.setArrange_id(arrangeId);
                    t.setStudent_id(studentId);
                    return t;
                }
            }
            num ++;
        }
        return null;
    }
}
