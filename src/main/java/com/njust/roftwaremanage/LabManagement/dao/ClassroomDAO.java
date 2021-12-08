package com.njust.roftwaremanage.LabManagement.dao;

import com.njust.roftwaremanage.LabManagement.entity.Classroom;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class ClassroomDAO {
    /**
     * 根据address找到对应的教室
     * 输入:address(String)
     * 输出:Classroom对象
     */
    public static Classroom findClassroomByAddress(String address) {
        String resource = "mybatis-config.xml";
        SqlSession sqlSession = null;
        Classroom classroom = new Classroom();
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession();
            classroom = sqlSession.selectOne("findClassroomByAddress", address);

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
        return classroom;
    }

    public static void main(String[] args) {
        ClassroomDAO c = new ClassroomDAO();
        System.out.println("------------------------");
        System.out.println("根据房间名查找房间：");
        Classroom c2 = c.findClassroomByAddress("ss");
        System.out.println(c2.getManager_id());

    }
}
