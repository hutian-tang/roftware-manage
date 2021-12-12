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

@WebServlet(name = "AdminOperateArrange" , urlPatterns = "/AdminOperateArrange")
public class AdminOperateArrange extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String arrange_id = request.getParameter("arrange_id");
        String operatecode1 = null;
        if(arrange_id!=null) {
            operatecode1 = "1";//查
        }
        String operatecode2 = request.getParameter("operatecode2");//删
        if(operatecode1!=null){
            //System.out.println(arrange_id);
            ArrangeDAO dao = new ArrangeDAO();
            List<Arrange> list=new ArrayList<>();
            list.add(dao.findArrangeById(Integer.parseInt(arrange_id)));
            System.out.println(list.get(0).getArrange_id());
            request.setAttribute("list1", list);
            request.getRequestDispatcher("admin/AdminPage.jsp").forward(request, response);


        }
        else if(operatecode2!=null){
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
           // PrintWriter pw=response.getWriter();
//        String cName = request.getParameter("cName");
//        System.out.println("name is ");
//        System.out.println(cName);
//        new WikiController().deleteCharacter(request.getParameter(cName));
            int i = Integer.parseInt(request.getParameter("id"));
//            System.out.println(i);
            new ArrangeDAO().deleteArrange(i);
            response.sendRedirect("AdminOperateArrange");
        //    pw.flush();
          //  pw.close();

        }else{
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
