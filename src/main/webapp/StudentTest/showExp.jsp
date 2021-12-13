<%@ page import="java.util.List" %>
<%@ page import="com.njust.roftwaremanage.LabManagement.tools.Message" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.njust.roftwaremanage.LabManagement.entity.Arrange" %>
<%@ page import="com.njust.roftwaremanage.LabManagement.entity.Table" %>
<%@ page import="com.njust.roftwaremanage.LabManagement.entity.Teacher" %><%--
  Created by IntelliJ IDEA.
  User: 31920
  Date: 2021/12/11
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    List<Message> messageList = new ArrayList<>();
    int index = 0;
    int count = 0;
    Arrange arrange = new Arrange();
    Table table = new Table();
    Teacher teacher = new Teacher();
    String studentId;
    Message feedback;
    Message select;
%>

<html>
<head>
    <title>学生主页</title>
    <jsp:include page="/showExp"/>
</head>
<body>
<%
    studentId = request.getParameter("studentId");
%>
<h1><%=studentId%>的待上课实验</h1>
<a href="home.jsp?studentId=<%=studentId%>">返回主页</a>
<%
    feedback = (Message) session.getAttribute("feedbackMessage");
    if(feedback != null){
%>
    <h2>不会写JS，假装我是报修提示框。</h2>
    <h2>提示信息：<%=feedback.getMsg()%></h2>
<%
    //避免重复提示
    session.setAttribute("feedbackMessage",null);
    }
%>
<%
    select = (Message) session.getAttribute("selectMessage");
    if(select != null){
%>
<h2>不会写JS，假装我是选课提示框。</h2>
<h2>提示信息：<%=select.getMsg()%></h2>
<%
        //避免重复提示
        session.setAttribute("selectMessage",null);
    }
%>
<table>
    <tr>
        <td>实验名称</td>
        <td>教室</td>
        <td>座位号</td>
        <td>任课老师</td>
        <td>周次</td>
        <td>星期</td>
        <td>开始节次</td>
        <td>结束节次</td>
        <td>机器报修</td>
    </tr>
    <%
        List<Message> messageList = (List<Message>) request.getAttribute("message");
        if(messageList != null){
            for(Message m:messageList){
                table = (Table) m.getData();
                arrange = (Arrange) m.getData2();
                teacher = (Teacher) m.getData3();
    %>
    <tr>
        <td><%=arrange.getName_exp()%></td>
        <td><%=arrange.getAddress()%></td>
        <td><%=table.getTable_id()%></td>
        <td><%=teacher.getName()%></td>
        <td><%=arrange.getWeek()%></td>
        <td><%=arrange.getDay()%></td>
        <td><%=arrange.getStart()%></td>
        <td><%=arrange.getEnd()%></td>
        <form action="feedback" method="post">
            <input type="hidden" id="tableId" name="tableId" value="<%=table.getTable_id()%>">
            <input type="hidden" id="address" name="address" value="<%=arrange.getAddress()%>">
            <input type="hidden" id="studentId" name="studentId" value="<%=studentId%>">
            <td><input type="submit" value="报修"></td>
        </form>
    </tr>
    <%

            }
        }
    %>
</table>
</body>
</html>
