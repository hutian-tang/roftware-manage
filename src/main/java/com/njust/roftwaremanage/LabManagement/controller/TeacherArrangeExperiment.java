package com.njust.roftwaremanage.LabManagement.controller;

import com.njust.roftwaremanage.LabManagement.dao.ArrangeDAO;
import com.njust.roftwaremanage.LabManagement.entity.Arrange;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 教师安排实验的servlet
 * 响应路径:待定
 * */

public class TeacherArrangeExperiment extends HttpServlet {
    /**
     * 教师在安排实验前应当先查询该时间段是否存在可以选择的实验室
     * 输入参数:周次week(int),星期day(int),开始的节次start(int),结束的节次end(int)
     * 返回参数:List<Message>对象(可能为空)
     *          data属性:classroom对象
     *          data2属性:Boolean(True表示该实验室已经有开放性实验选择，教师如果选择必须共享)
     *
     * */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException  {
    doPost(request,response);
    }

    /**
     * 教师安排实验
     * 输入参数:教师id(String),周次week(int),星期day(int),开始的节次start(int),结束的节次end(int)
     *         实验人数num(int),实验类型type(String)是否共享(Boolean),实验室id(List<String>)
     * 输出参数:Message对象
     *          code属性:
     *          mag属性:
     * */
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException  {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String weeksearch = request.getParameter("weeksearch");
        String daysearch = request.getParameter("daysearch");
        String weekadd = request.getParameter("weekadd");
        String dayadd = request.getParameter("dayadd");
        String starttimeadd = request.getParameter("starttimeadd");
        String endtimeadd = request.getParameter("endtimeadd");
        String name_expadd = request.getParameter("name_expadd");
        String addressadd = request.getParameter("addressadd");
        String number_useadd = request.getParameter("number_useadd");
        String isshared = request.getParameter("ishared");
        String teacher_idadd = request.getParameter("teacher_id");
        PrintWriter out = response.getWriter();
        if(weeksearch!=null&&daysearch!=null){
            ArrangeDAO dao = new ArrangeDAO();
            List<Arrange> list1 = dao.findArrangeAllinoneday(weeksearch,daysearch);
            request.setAttribute("list1", list1);
            request.getRequestDispatcher("teacher/experimentshow.jsp").forward(request, response);
                }
        else if(weekadd!=null&&dayadd!=null){
            ArrangeDAO dao = new ArrangeDAO();
            boolean flag = true;
            List<Arrange> list = dao.findArrangeAllinoneday(weekadd,dayadd);
            for(int i = 0;i<list.size();i++){
                out.println(list.get(i).getAddress());
                if(list.get(i).getAddress()==addressadd){
                    if(     (Integer.parseInt(starttimeadd) <= list.get(i).getStart()
                                    && Integer.parseInt(starttimeadd) >= list.get(i).getEnd())
                            ||
                            (Integer.parseInt(endtimeadd) <= list.get(i).getStart()
                                    && Integer.parseInt(endtimeadd) >= list.get(i).getEnd())
                      ){
                        flag = false;
                        out.println("<script language = 'javascript'> alert('await the administrator to check!');</script>");
                        break;
                    }
                }
            }
            if(flag){
                    boolean share;
                    if(isshared=="share"){
                         share = true;
                    }
                    else{
                         share = false;
                    }
                    Arrange arrange = new Arrange(Integer.parseInt(weekadd),Integer.parseInt(dayadd),
                            Integer.parseInt(starttimeadd),Integer.parseInt(endtimeadd),name_expadd,addressadd,
                            teacher_idadd,Integer.parseInt(number_useadd),share);
                    ArrangeDAO dao1 = new ArrangeDAO();
                    dao1.addArrange(arrange);
            }

        }




    }
}
