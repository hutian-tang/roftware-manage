package com.njust.roftwaremanage.LabManagement.dao;

import com.njust.roftwaremanage.LabManagement.entity.Table;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TableDAO {

    /**
     * 根据学生id返回对应的排课信息
     * 输入:studentId
     * 输出:id对应的List<Table>
     * */
    public static List<Table> findTableByStudentId(String student_id){
        List<Table> tableList=new ArrayList<>();
        String resource = "mybatis-config.bak";
        SqlSession sqlSession = null;
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession();
            tableList=sqlSession.selectList("main.java.com.njust.roftwaremanage.LabManagement.dao.TableMapper.findTablebyid",student_id);
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
        return tableList;
    }

    /**
     * 根据学生id和实验id返回对应的排课信息
     * 输入:studentId,arrangeId
     * 输出:Table
     * */
    public static Table findTableByStudentIdAndArrangeId(String student_id,String arrange_id){
        String resource = "mybatis-config.bak";
        SqlSession sqlSession = null;
        Table table = new Table();
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession();
            Table temp=new Table();
            temp.setStudent_id(student_id);
            temp.setArrange_id(arrange_id);
            table=sqlSession.selectOne("main.java.com.njust.roftwaremanage.LabManagement.dao.TableMapper.findTableByStudentIdAndArrangeId", temp);
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
        return table;
    }

    /**
     * 根据学生座位号和实验id返回对应的排课信息
     * 输入:tableId,arrangeId
     * 输出:Table
     * */
    public static Table findTableByTableIdAndArrangeId(int table_id,String arrange_id){
        //TODO:通过学生座位号和实验id找到对应的Table
        String resource = "mybatis-config.bak";
        SqlSession sqlSession = null;
        Table table = new Table();
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession();
            Table temp=new Table();
            temp.setTable_id(table_id);
            temp.setArrange_id(arrange_id);
            table=sqlSession.selectOne("main.java.com.njust.roftwaremanage.LabManagement.dao.TableMapper.findTableByTableIdAndArrangeId", temp);
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
        return table;
    }

    /**
     * 将学生实验的座位信息写入数据库
     * 输入:Table
     * 注意:Table_id由数据库生成
     */
    public static void InsertTable(Table table){
        //TODO:生成tableId
        //TODO:写入数据库
        String resource = "mybatis-config.bak";

        SqlSession openSession=null;
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            openSession = sqlSessionFactory.openSession();


            openSession.insert("main.java.com.njust.roftwaremanage.LabManagement.dao.TableMapper.InsertTable",table);

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
