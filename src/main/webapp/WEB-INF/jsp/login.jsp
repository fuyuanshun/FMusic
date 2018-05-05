<%@page isELIgnored="false"%>
<%@   page contentType="text/html;charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<%--<%@include file="header.jsp" %>--%>
<jsp:include page="header.jsp"></jsp:include>
<%request.setCharacterEncoding("utf-8");%>
<html>
<head>
    <title>用户登陆</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/register.js"></script>
    <%--表单验证插件--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.validate.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
</head>

<body>
<div class="outer-wrap">
    <div class="login">
        <p>用户登录</p>
        <form method="post" action="" id="loginform">
            <div>
                <table>
                    <tr>
                        <td>用户名</td>
                        <td>
                            <input type="text" name="username" placeholder="请输入您的用户名" id="username"/>
                        </td>
                    </tr>
                    <tr>
                        <td>用户密码</td>
                        <td>
                            <input type="password" name="password" placeholder="请输入您的密码" id="password"/>
                        </td>
                    </tr>
                    <tr>
                        <td rowspan="2">
                            <input type="submit" value="登陆" class="button"/>
                        </td>
                        <td rowspan="2">
                            <a href="${pageContext.request.contextPath}/register">注册</a>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td colspan="2">
                            <a href="${pageContext.request.contextPath}/forgetPassword">忘记密码?</a>
                        </td>
                    </tr>
                </table>
            </div>
        </form>
    </div>
</div>
</body>
</html>
