package com.njust.roftwaremanage.LabManagement.dao;

import com.njust.roftwaremanage.LabManagement.entity.Arrange;
import com.njust.roftwaremanage.LabManagement.entity.Mag;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MagDAO {

    /**
     * 根据身份类型和id获取数据库中的mag对象
     * 输入：type,id
     * 输出：Mag对象
     * */
    public static Mag findMag(String type, String id){
        Mag mag = null;
        String resource = "mybatis-config.xml";
        SqlSession sqlSession = null;
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession();
            Mag m = new Mag();
            m.setType(type);
            m.setTargetId(id);
            mag = sqlSession.selectOne("findMag",m);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return mag;
    }

    public static void deleteMag(String magId){
        String resource = "mybatis-config.xml";
        SqlSession sqlSession = null;
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession();
            sqlSession.delete("deleteMag",magId);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public static void main(String[] args){
        Mag m = MagDAO.findMag("student","919106840101");
        System.out.println(m.getMessage());
        MagDAO.deleteMag("1");
    }
}
