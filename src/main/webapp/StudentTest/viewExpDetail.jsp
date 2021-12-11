<%@ page import="com.njust.roftwaremanage.LabManagement.tools.Message" %>
<%@ page import="java.util.List" %>
<%@ page import="com.njust.roftwaremanage.LabManagement.entity.Arrange" %><%--
  Created by IntelliJ IDEA.
  User: 31920
  Date: 2021/12/11
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String studentId;
    String expName;
    List<Message> messageList;
    Arrange arrange;
    String teacherName;
    String teacherDepart;
%>
<html>
<head>
    <title>Title</title>
    <jsp:include page="/expDetail"/>
</head>
<body>
<%
    studentId = request.getParameter("id");
    expName = request.getParameter("name");

%>
<h1><%=studentId%>的<%=expName%>的详细信息</h1>
<a href="viewExp.jsp?studentId=<%=studentId%>">返回实验列表</a>
<table>
    <tr>
        <td>实验名称</td>
        <td>教室</td>
        <td>任课老师</td>
        <td>所属学院</td>
        <td>周次</td>
        <td>星期</td>
        <td>开始节次</td>
        <td>结束节次</td>
        <td>操作</td>
    </tr>
    <%
        messageList = (List<Message>) request.getAttribute("ExperimentDetail");
        if(messageList != null){
            for(Message m:messageList){
                arrange = (Arrange) m.getData();
                teacherName = (String) m.getData2();
                teacherDepart = (String) m.getData3();
    %>
    <tr>
        <td><%=arrange.getName_exp()%></td>
        <td><%=arrange.getAddress()%></td>
        <td><%=teacherName%></td>
        <td><%=teacherDepart%></td>
        <td><%=arrange.getWeek()%></td>
        <td><%=arrange.getDay()%></td>
        <td><%=arrange.getStart()%></td>
        <td><%=arrange.getEnd()%></td>
        <td><%=m.getMsg()%></td>
    </tr>
    <%

            }
        }
    %>
</table>
</body>
</html>
