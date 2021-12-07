package com.njust.roftwaremanage.LabManagement.dao;

import com.njust.roftwaremanage.LabManagement.entity.Machine;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MachineDAO {
    /**
     * 根据机器所在教室和机器id寻找机器
     * 输入:address,machineId
     * 输出:Machine
     * */
    public static Machine getMachineByAddressAndId(String address,String machineId){
        String resource = "mybatis-config.xml";
        SqlSession sqlSession = null;
        Machine machine = new Machine();
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession();
            Machine temp = new Machine(machineId,address,"");
            machine=sqlSession.selectOne("searchmachine", temp);

            sqlSession.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        }
        finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return machine;
    }


    /**
     * 获取所有损坏的机器
     * 输出:List<Machine>
     * */
    public static List<Machine> getBrokenMachines(){
        List<Machine> machineList=new ArrayList<>();
        String resource = "mybatis-config.xml";
        SqlSession sqlSession = null;
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession();
            machineList=sqlSession.selectList("brokenmachine");
            sqlSession.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        }
        finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return machineList;
    }

    /**
     * 更新机器信息
     * 输入:Machine(新的机器信息)
     * */
    public static void updateMachine(Machine machine){
        String resource = "mybatis-config.xml";
        SqlSession openSession=null;

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            openSession = sqlSessionFactory.openSession();
            openSession.update("updatemachine",machine);
            openSession.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            if (openSession != null) {
                openSession.rollback();
            }
        }
        finally {
            if (openSession != null) {
                openSession.close();
            }
        }

    }
}
