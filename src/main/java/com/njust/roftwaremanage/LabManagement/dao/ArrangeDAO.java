package com.njust.roftwaremanage.LabManagement.dao;

import com.njust.roftwaremanage.LabManagement.entity.Arrange;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ArrangeDAO {


    /**
     * 根据id返回对应的实验
     * 输入:id
     * 输出:id对应的Arrange
     * */
    public static Arrange findArrangeById(String arrange_id){
        String resource = "mybatis-config.xml";
        SqlSession sqlSession = null;
        Arrange arrange = new Arrange();
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession();
            arrange=sqlSession.selectOne("main.java.com.njust.roftwaremanage.LabManagement.dao.ArrangeMapper.searcharrange", arrange_id);

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
        return arrange;
    }

    /**
     * 根据name返回对应的实验
     * 输入:name
     * 输出:name对应的List<Arrange>
     * */
    public static List<Arrange> findArrangeByName(String name_exp){
        List<Arrange> arrangeList=new ArrayList<>();
        String resource = "mybatis-config.xml";
        SqlSession sqlSession = null;
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession();
            arrangeList=sqlSession.selectList("main.java.com.njust.roftwaremanage.LabManagement.dao.ArrangeMapper.findarrangebyname",name_exp);
            sqlSession.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }
        finally {
            sqlSession.close();
        }
        return arrangeList;
    }

    /**
     * 访问数据库，获取所有实验的名字（消除重复）
     * 输出：List<String>
     * */
    public static List<String> getArrangeNames(){
        List<String> arrangeList=new ArrayList<>();
        String resource = "mybatis-config.xml";
        SqlSession sqlSession = null;
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession();
            arrangeList=sqlSession.selectList("main.java.com.njust.roftwaremanage.LabManagement.dao.ArrangeMapper.getexpname");
            sqlSession.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }
        finally {
            sqlSession.close();
        }
        return arrangeList;
    }
}
