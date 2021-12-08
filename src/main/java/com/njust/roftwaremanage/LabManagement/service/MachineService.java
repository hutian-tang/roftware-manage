package com.njust.roftwaremanage.LabManagement.service;

import com.njust.roftwaremanage.LabManagement.dao.MachineDAO;
import com.njust.roftwaremanage.LabManagement.entity.Machine;

import java.util.List;

public class MachineService {
    /**
     * 根据机器所在教室和机器id判断该机器是否可用
     * 输入:address,machineId
     * 输出:可用则输出true,不可用则输出false
     * */
    public static Boolean checkCondition(String address,String machineId){
        Machine machine = MachineDAO.getMachineByAddressAndId(address,machineId);
        if(machine != null){
            if(machine.getCondition().equals("正常")){
                return true;
            }
            else if(machine.getCondition().equals("损坏")){
                return false;
            }
        }
        return false;
    }

    /**
     * 获取所有损坏的机器
     * 输出:List<Machine>
     * */
    public static List<Machine> getBrokenMachines(){
        return MachineDAO.getBrokenMachines();
    }

    /**
     * 修复已经损坏的机器
     * 输入:machineId,Address
     * 输出:Boolean(true为修复成功)
     * */
    public Boolean repairMachine(String machineId,String address){
        //查找对应的机器
        Machine machine = MachineDAO.getMachineByAddressAndId(address,machineId);
        if(machine != null){
            if(machine.getCondition().equals("损坏")){
                machine.setCondition("正常");
                MachineDAO.updateMachine(machine);
                return true;
            }
        }
        return false;
    }

    /**
     * 根据机器所在教室和机器id查找机器
     * 输入:address,machineId
     * 输出:Machine
     * */
    public static Machine findMachineByAddressAndId(String id,String address){
        return MachineDAO.getMachineByAddressAndId(address,id);
    }
}
