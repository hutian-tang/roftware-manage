package com.njust.roftwaremanage.LabManagement.controller;

import com.njust.roftwaremanage.LabManagement.dao.ArrangeDAO;
import com.njust.roftwaremanage.LabManagement.entity.Arrange;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import com.njust.roftwaremanage.LabManagement.controller.TeacherArrangeExperiment;
@WebServlet(name = "AdminOperateArrange" , urlPatterns = "/AdminOperateArrange")
public class AdminOperateArrange extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String arrange_id = request.getParameter("arrange_id");
        String operatecode1 = null;
        Object operatecode3 = null;
        if(arrange_id!=null) {
            operatecode1 = "1";//查
        }
        String operatecode2 = request.getParameter("operatecode2");//删
        if(request.getSession().getAttribute("operatecode3")!=null){
        operatecode3 =request.getSession().getAttribute("operatecode3");
        request.getSession().removeAttribute("operatecode3");
        }
//        if(operatecode3!=null) {
//            operatecode3 = request.getSession().getAttribute("operatecode3").toString();//改
//        }
//        Operatecode1：增加实验安排
        if(operatecode1!=null){
            //System.out.println(arrange_id);
            ArrangeDAO dao = new ArrangeDAO();
            List<Arrange> list=new ArrayList<>();
            list.add(dao.findArrangeById(arrange_id));
          //  System.out.println(list.get(0).getArrange_id());
            request.setAttribute("list1", list);
            request.getRequestDispatcher("admin/AdminPage.jsp").forward(request, response);


        }
//        operatecode2：删除实验安排
        else if(operatecode2!=null){
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            int i = Integer.parseInt(request.getParameter("id"));
            new ArrangeDAO().deleteArrange(i);
            response.sendRedirect("AdminOperateArrange");
        //    pw.flush();
          //  pw.close();

        }
//      operatecode3：修改实验安排
        else if(operatecode3!=null){
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            String id = request.getSession().getAttribute("id").toString();
            String arrange_idadd = request.getParameter("arrange_idadd");
            String weekadd = request.getParameter("weekadd");
            String dayadd = request.getParameter("dayadd");
            String starttimeadd = request.getParameter("starttimeadd");
            String endtimeadd = request.getParameter("endtimeadd");
            String name_expadd = request.getParameter("name_expadd");
            String addressadd = request.getParameter("addressadd");
            String number_useadd = request.getParameter("number_useadd");
            String isshared = request.getParameter("isshared");
            String teacher_idadd = request.getParameter("teacher_id");
            String typeadd = request.getParameter("type");
            boolean share;
            if(isshared.equals("share")){
                share = true;
            }
            else{
                share = false;
            }
            Arrange arrange = new Arrange(arrange_idadd,Integer.parseInt(weekadd),Integer.parseInt(dayadd),
                    Integer.parseInt(starttimeadd),Integer.parseInt(endtimeadd),name_expadd,addressadd,
                    teacher_idadd,Integer.parseInt(number_useadd),share,typeadd);
            ArrangeDAO dao1 = new ArrangeDAO();
            dao1.updateArrange(arrange,id);
            response.sendRedirect("AdminOperateArrange");
        }
        else{
            ArrangeDAO dao = new ArrangeDAO();
            List<Arrange> list1 = dao.getArrangeAll();
            request.setAttribute("list1", list1);
            request.getRequestDispatcher("admin/AdminPage.jsp").forward(request, response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
