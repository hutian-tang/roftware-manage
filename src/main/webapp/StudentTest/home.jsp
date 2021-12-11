<%--
  Created by IntelliJ IDEA.
  User: 31920
  Date: 2021/12/11
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    String studentId;
%>
<html>
<head>
    <title>学生主页</title>
</head>
<body>
<%
    studentId = request.getParameter("studentId");
%>
<h1><%=studentId%>的主页</h1>
</body>
    <a href="showExp.jsp?studentId=<%=studentId%>">查看课表</a>
    <a href="viewExp.jsp?studentId=<%=studentId%>">查看实验</a>
</html>
