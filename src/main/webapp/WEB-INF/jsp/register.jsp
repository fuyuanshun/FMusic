<%@page isELIgnored="false" %>
<%@   page contentType="text/html;charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<%@include file="header.jsp"%>
<%request.setCharacterEncoding("utf-8");%>
<html>
<head>
    <title>注册用户</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/register.js"></script>
    <%--表单验证插件--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.validate.js"></script>
</head>

<body>
<div class="container">
<div class="wrap">
    <div class="form-group">
        <form method="post" action="" id="myform" class="form-horizontal" >
            <label for="username" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-offset-2 col-sm-10">
                <input type="text" placeholder="请输入用户名" name="username" id="username" required class="form-control"/>
            </div>
                <label for="password" class="col-sm-2 control-label">用户密码</label>
            <div class="col-sm-10">
                <input type="password" placeholder="请输入您的登陆密码" name="password" id="password" class="form-control" required/>
            </div>
                <label for="password" class="col-sm-2 control-label">确认密码</label>
            <div class="col-sm-10">
                <input type="password" placeholder="请重新输入一遍您的密码" name="password2" id="password2" class="form-control" required/>
            </div>
                <label for="username" class="col-sm-2 control-label">邮箱</label>
            <div class="col-sm-10">
                <input type="text" placeholder="请输入邮箱地址" name="email" id="email" class="form-control" required/>
            </div>
            <label for="username" class="col-sm-2">性别</label>
            <div class="col-sm-10">
                男<input type="radio" value="男" name="sex"  required>
                女<input type="radio" value="女" name="sex"  required>
            </div>

                <label for="username" class="col-sm-2 control-label">年龄</label>
            <div class="col-sm-10">
                <input type="text" placeholder="请输入您的年龄" name="age" id="age" class="form-control" required />
            </div>
                <label for="username" class="col-sm-2 control-label">电话</label>
            <div class="col-sm-10">
                <input type="text" placeholder="不得多于11个字" name="phone" id="phone"  class="form-control" required/>
            </div>
                <label for="username" class="col-sm-2 control-label">生日</label>
            <div class="col-sm-10">
                <input type="text"  name="birthday" id="birthday" class="form-control" required/>
            </div>
                <label for="username" class="col-sm-2 control-label">爱好</label>
            <div class="col-sm-10">
                <input type="text"  name="hobby" id="hobby" class="form-control"  required/>
            </div>
                <label for="username">居住地址</label>
            <div class="col-sm-10">
                <input type="text" name="address" id="address" class="form-control"  required/>
            </div>
            <div class="col-sm-10">
                <input type="submit" value="注册" id="submit" class="btn btn-default" />
            </div>
            <div class="col-sm-10">
                <a class="btn btn-default" href="${pageContext.request.contextPath}/login">已经有账号啦~ 去登陆</a>
            </div>
        </form>
    </div>
</div>
</div>
</body>
</html>

