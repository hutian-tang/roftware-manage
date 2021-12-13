package com.njust.roftwaremanage.LabManagement.service;

import com.njust.roftwaremanage.LabManagement.dao.MagDAO;
import com.njust.roftwaremanage.LabManagement.entity.Mag;

public class MagService {

    /**
     * 根据身份类型和id获取数据库中的mag对象
     * 输入：type,id
     * 输出：Mag对象
     * */
    public static Mag getMagById(String type,String id){
        Mag mag = MagDAO.findMag(type,id);
        if(mag != null){
            //输出mag，避免重复提示
            MagDAO.deleteMag(mag.getId());
        }
        return mag;
    }
}
