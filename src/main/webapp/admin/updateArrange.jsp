
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="../assets/style.css" rel="stylesheet">
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String id = request.getParameter("id");
    session.setAttribute("id",id);
    String operatecode3 = "operatecode3";
    session.setAttribute("operatecode3",operatecode3);
%>
<html>
<head>
    <meta charset="utf-8">
    <title>管理员修改实验安排</title>
    <style type="text/css">
        body{

            margin: 0;
            padding: 0;
            font-family: sans-serif;
            background-size: cover;
            -webkit-background-size: cover;
            -o-background-size: cover;
            -moz-background-size: cover;
            -ms-background-size: cover;




        }

    </style>

</head>
<body>

<div>
    <br><br><br>
    <form action="${pageContext.request.contextPath}/AdminOperateArrange" method="post" class="form-horizontal" role="form">
        <br><br><br>
        <h1 align="center" style="color: darkorange">请填写相关信息</h1>
        <br><br><br><br><br><br>
        <div class="form-group">
            <label  class="control-label col-md-2 col-md-offset-2"style="color: whitesmoke">实验安排序号</label>
            <div class="col-md-4">
                <input type="text" name="arrange_idadd" class="form-control" placeholder="请输入安排序号"/>
            </div>
        </div>
        <br>
        <div class="form-group">
            <label  class="control-label col-md-2 col-md-offset-2"style="color: whitesmoke">申请人</label>
            <div class="col-md-4">
                <input type="text" name="teacher_id" class="form-control" placeholder="请输入申请人"/>
            </div>
        </div>
        <br>
        <div class="form-group">
            <label  class="control-label col-md-2 col-md-offset-2"style="color: whitesmoke">周次</label>
            <div class="col-md-4">
                <input type="text" name="weekadd" class="form-control" placeholder="请输入周次"/>
            </div>
        </div>
        <br>
        <div class="form-group">
            <label  class="control-label col-md-2 col-md-offset-2" style="color: whitesmoke">天次</label>
            <div class="col-md-4">
                <input type="text" name="dayadd" class="email form-control" placeholder="请输入天次"/>
            </div>

        </div>
        <br>
        <br>
        <div class="form-group">
            <label  class="control-label col-md-2 col-md-offset-2"style="color: whitesmoke">开始时间</label>
            <div class="col-md-4">
                <input type="text" name="starttimeadd" class="code" placeholder="请输入开始时间"/>
            </div>

        </div>
        <br><br>
        <div class="form-group">
            <label  class="control-label col-md-2 col-md-offset-2"style="color: whitesmoke">结束时间</label>
            <div class="col-md-4">
                <input type="text" name="endtimeadd" class="code" placeholder="请输入结束时间"/>
            </div>

        </div>
        <br>
        <div class="form-group">
            <label  class="control-label col-md-2 col-md-offset-2" style="color: whitesmoke">人数</label>
            <div class="col-md-4">
                <input type="text" name="number_useadd" class="form-control" placeholder="请输入人数"/>
            </div>

        </div>
        <br>
        <br>
        <div class="form-group">
            <label  class="control-label col-md-2 col-md-offset-2" style="color: whitesmoke">实验类型</label>
            <div class="col-md-4">
                <input type="radio" name="isshared" value ="share" >共享
                <input type="radio" name="isshared" value="noshare">不共享

            </div>

        </div>
        <div class="form-group">
            <label  class="control-label col-md-2 col-md-offset-2" style="color: whitesmoke">实验类型</label>
            <div class="col-md-4">
                <input type="radio" name="type" value ="开放性实验" >开放性实验
                <input type="radio" name="type" value="普通实验">普通实验

            </div>

        </div>
        <div class="form-group">
            <label  class="control-label col-md-2 col-md-offset-2" style="color: whitesmoke">实验室id</label>
            <div class="col-md-4">
                <input type="text" name="addressadd" class="email form-control" placeholder="请输入实验室id"/>
            </div>

        </div>
        <div class="form-group">
            <label  class="control-label col-md-2 col-md-offset-2" style="color: whitesmoke">实验名</label>
            <div class="col-md-4">
                <input type="text" name="name_expadd" class="email form-control" placeholder="请输入实验室名"/>
            </div>

        </div>
        <br>
        <br>
        <br>
        <br>
        <div class="form-group">
            <input class="btn btn-default col-md-1 col-md-offset-4" type="submit" value="提交">

            <input class="btn btn-default col-md-1 col-md-offset-1" type="reset" value="清空">
        </div>
    </form>
</div>


</body>
</html>

