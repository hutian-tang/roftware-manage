package com.njust.roftwaremanage.LabManagement.dao;

import com.njust.roftwaremanage.LabManagement.entity.Machine;

import java.util.List;

public class MachineDAO {
    /**
     * 根据机器所在教室和机器id寻找机器
     * 输入:address,machineId
     * 输出:Machine
     * */
    public static Machine getMachineByAddressAndId(String address,String machineId){
        //TODO:
        return null;
    }

    /**
     * 获取所有损坏的机器
     * 输出:List<Machine>
     * */
    public static List<Machine> getBrokenMachines(){
        //TODO:查找数据库中condition字段值为"损坏"的机器
        return null;
    }

    /**
     * 更新机器信息
     * 输入:Machine(新的机器信息)
     * */
    public static void updateMachine(Machine machine){
        //TODO:
    }
}
