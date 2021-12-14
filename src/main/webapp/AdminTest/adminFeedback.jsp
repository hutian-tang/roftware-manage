<%@ page import="java.util.List" %>
<%@ page import="com.njust.roftwaremanage.LabManagement.entity.Machine" %>
<%@ page import="com.njust.roftwaremanage.LabManagement.tools.Message" %><%--
  Created by IntelliJ IDEA.
  User: 31920
  Date: 2021/12/14
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    String adminId;
    List<Machine> machineList;
    Message message;
%>
<html>
<head>
    <title>机器维护</title>
    <jsp:include page="/AdminTest/machine"/>
</head>
<body>
<a href="adminHome.jsp?adminId=<%=adminId%>">返回主页</a>
<%
    message = (Message) session.getAttribute("message");
    if(message != null){
%>
<h2>不会写JS，假装我是报修提示框。</h2>
<h2>提示信息：<%=message.getMsg()%></h2>
<%
        //避免重复提示
        session.setAttribute("message",null);
    }
%>
<table>
    <tr>
        <td>房间号</td>
        <td>机器编号</td>
        <td>操作</td>
    </tr>
    <%
        adminId = request.getParameter("adminId");
        machineList = (List<Machine>) request.getAttribute("machine");
        if(machineList != null){
            for(Machine m:machineList){
    %>
    <tr>
        <td><%=m.getAddress()%></td>
        <td><%=m.getMachine_id()%></td>
        <form method="post" action="machine">
            <input type="hidden" id="adminId" name="adminId" value="<%=adminId%>">
            <input type="hidden" id="machineId" name="machineId" value="<%=m.getMachine_id()%>">
            <input type="hidden" id="address" name="address" value="<%=m.getAddress()%>">
            <td><input type="submit" value="确认修复"></td>
        </form>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
