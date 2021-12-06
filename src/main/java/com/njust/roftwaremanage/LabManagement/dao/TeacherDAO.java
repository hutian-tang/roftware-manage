package com.njust.roftwaremanage.LabManagement.dao;

import com.njust.roftwaremanage.LabManagement.entity.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class TeacherDAO {

    /**
     * 根据教师id查找数据库中的教师
     * 输入：教师id
     * 输出：教师对象，未找到则为null
     * */
    public Teacher findTeacherById(String teacher_id){
        //TODO:
        String resource = "mybatis-config.xml";
        SqlSession sqlSession = null;
        Teacher teacher = null;
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession();
            teacher=sqlSession.selectOne("main.java.com.njust.roftwaremanage.LabManagement.dao.TeacherMapper.findteacherbyid", teacher_id);

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
        return teacher;
    }
}
