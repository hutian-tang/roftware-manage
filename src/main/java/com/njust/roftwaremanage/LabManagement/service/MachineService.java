package com.njust.roftwaremanage.LabManagement.service;

import com.njust.roftwaremanage.LabManagement.dao.MachineDAO;
import com.njust.roftwaremanage.LabManagement.entity.Machine;

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
}
