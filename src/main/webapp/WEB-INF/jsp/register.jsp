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
    <%--导入css文件--%>
    <link href="${pageContext.request.contextPath}/css/register.css" rel="stylesheet" >
</head>

<body>
<div class="container">
<div class="wrap">
    <div class="form-group">
        <span class="title">请填写您的信息</span>
        <form method="post" action="" id="myform" >
            <p class="btn-group">
                <label for="username">用户名</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text" placeholder="请输入用户名" name="username" id="username" required/>
            </p><br>
            <p class="btn-group">
                <label for="password">用户密码</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="password" placeholder="请输入您的登陆密码" name="password" id="password" required/>
            </p><br>

            <p class="btn-group">
                <label for="password">确认密码</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="password" placeholder="请重新输入一遍您的密码" name="password2" id="password2" required/>
            </p> <br>

            <p class="btn-group">
                <label for="username">邮箱</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text" placeholder="请输入邮箱地址" name="email" id="email" required/>
            </p><br>

            <p class="btn-group">
                <label for="username">性别</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                男<input type="radio" value="男" name="sex" required>
                女<input type="radio" value="女" name="sex" required>
            </p><br>

            <p class="btn-group">
                <label for="username">年龄</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text" placeholder="请输入您的年龄" name="age" id="age" required />
            </p><br>

            <p class="btn-group">
                <label for="username">电话</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text" placeholder="不得多于11个字" name="phone" id="phone" required/>
            </p><br>

            <p class="btn-group">
                <label for="username">生日</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text"  name="birthday" id="birthday"  required/>
            </p><br>

            <p class="btn-group">
                <label for="username">爱好</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text"  name="hobby" id="hobby"  required/>
            </p><br>

            <p class="btn-group">
                <label for="username">地址</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text" name="address" id="address"  required/>
            </p><br>

            <p class="btn-group">
                <input type="submit" value="注册" id="submit" />
            </p><br>
            <p class="btn-group">
                <a class="goindex" href="${pageContext.request.contextPath}/login.action">已经有账号啦~ 去登陆</a>
            </p><br>
        </form>
    </div>
</div>
</div>
</body>
</html>

