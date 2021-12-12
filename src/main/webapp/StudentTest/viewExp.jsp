<%@ page import="java.util.List" %>
<%@ page import="com.njust.roftwaremanage.LabManagement.tools.Message" %><%--
  Created by IntelliJ IDEA.
  User: 31920
  Date: 2021/12/11
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    List<Message> messageList;
    String studentId;
    String name;
    String type;
    Boolean isChoose;
%>
<html>
<head>
    <title>查看实验列表</title>
    <jsp:include page="/viewExp"/>
</head>
<body>
<%
    studentId = request.getParameter("studentId");
%>
<h1><%=studentId%>的实验列表</h1>
<a href="home.jsp?studentId=<%=studentId%>">返回主页</a>
<table>
    <tr>
        <td>实验名称</td>
        <td>实验类型</td>
        <td>状态</td>
        <td>操作</td>
    </tr>
    <%
        messageList = (List<Message>) request.getAttribute("experiments");
        if(messageList != null){
            for(Message m:messageList){
                name = (String) m.getData();
                type = (String) m.getData2();
                isChoose = (Boolean) m.getData3();
    %>
    <tr>
        <td><%=name%></td>
        <td><%=type%></td>
        <%
        if(isChoose){
        %>
        <td>已经选课</td>
        <%
        }else{
        %>
        <td>尚未选课</td>
        <%
        }
        %>
        <td><a href="viewExpDetail.jsp?id=<%=studentId%>&name=<%=name%>">详细信息</a></td>
    </tr>
    <%

            }
        }
    %>
</table>
</body>
</html>
