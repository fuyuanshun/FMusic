<%@page isELIgnored="false"%>
<%@   page contentType="text/html;charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<jsp:include page="header.jsp"></jsp:include>
<%request.setCharacterEncoding("utf-8");%>
<%
    String email = request.getParameter("email");
%>
<html>
<head>
    <title>重置密码</title>
    <%--表单验证插件--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.validate.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/resetpage.js"></script>
</head>
<body class="container">
    <form action="" method="post" id="resetForm" class="form-horizontal">
        <input type="hidden" value="<%=email%>" name="email">
        <label class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-10">
            <input type="text" name="username" class="form-control">
        </div>
        <label class="col-sm-2 control-label">用户密码</label>
        <div class="col-sm-10">
            <input type="password" name="password" id="password" class="form-control">
        </div>
        <label class="col-sm-2 control-label">确认密码</label>

        <div class="col-sm-10">
            <input type="password" name="password2" class="form-control">
        </div>
        <input type="submit" value="修改" class="btn btn-default">
    </form>
</body>
</html>
