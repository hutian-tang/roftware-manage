<%--
  Created by IntelliJ IDEA.
  User: 31920
  Date: 2021/12/14
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    String adminId;
%>
<html>
<head>
    <title>管理员首页</title>
</head>
<body>
<%
    adminId = request.getParameter("adminId");
%>
<h1><%=adminId%>的主页</h1>
<a href="adminFeedback.jsp?adminId=<%=adminId%>">机器维护</a>
</body>
</html>
