package com.njust.roftwaremanage.LabManagement.dao;

import com.njust.roftwaremanage.LabManagement.entity.Manager;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class ManagerDAO {

    /**
     * 根据管理员id查找数据库中的学生
     * 输入：管理员id
     * 输出：管理员对象，未找到则为null
     * */
    public Manager findManagerById(String manager_id){
        String resource = "mybatis-config.bak";
        SqlSession sqlSession = null;
        Manager manager = null;
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession();
            manager=sqlSession.selectOne("main.java.com.njust.roftwaremanage.LabManagement.dao.ManagerMapper.findmanagerbyid", manager_id);

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
        return manager;
    }
}

