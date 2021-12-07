package com.njust.roftwaremanage.LabManagement.dao;

import com.njust.roftwaremanage.LabManagement.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class StudentDAO {

    /**
     * 根据学生id查找数据库中的学生
     * 输入：学生id
     * 输出：学生对象，未找到则为null
     * */
    public Student findStudentById(String stduent_id){
        String resource = "mybatis-config.bak";
        SqlSession sqlSession = null;
        Student student = null;
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession();
            student=sqlSession.selectOne("main.java.com.njust.roftwaremanage.LabManagement.dao.StudentMapper.findstudentbyid", stduent_id);

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
        return student;
    }
}
