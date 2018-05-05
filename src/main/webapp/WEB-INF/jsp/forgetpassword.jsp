<%@page isELIgnored="false"%>
<%@   page contentType="text/html;charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<jsp:include page="header.jsp"></jsp:include>
<%request.setCharacterEncoding("utf-8");%>
<html>
<head>
    <title>找回密码</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/forgetpassword.js"></script>
    <%--表单验证插件--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.validate.js"></script>
</head>

<style>
    .container {
        position: absolute;
        top : 200px;
        left : 300px;
    }
</style>

<body>
    <div class="container">
        <div class="btn-group">
            <form action="" method="post" name="getPassword" id="getPassword">
                <label>请输入您的邮箱</label>
                <input type="text" name="email" id="email"/>
                <input type="submit" value="提交">
            </form>
        </div>
    </div>
</body>
</html>
