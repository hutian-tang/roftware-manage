<%@ page import="com.njust.roftwaremanage.LabManagement.entity.Mag" %><%--
  Created by IntelliJ IDEA.
  User: 31920
  Date: 2021/12/11
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    String studentId;
    Mag mag;
%>
<html>
<head>
    <title>学生主页</title>
    <jsp:include page="/studentMag"/>
</head>
<body>
<%
    studentId = request.getParameter("studentId");
%>
<h1><%=studentId%>的主页</h1>
<%
    mag = (Mag) request.getAttribute("mag");
    if(mag != null){
%>
<h2>不会写JS，假装我是系统消息提示框。</h2>
<h2>提示信息：<%=mag.getMessage()%></h2>
<%
    }
%>
<a href="showExp.jsp?studentId=<%=studentId%>">查看课表</a>
<a href="viewExp.jsp?studentId=<%=studentId%>">查看实验</a>
</body>
</html>
