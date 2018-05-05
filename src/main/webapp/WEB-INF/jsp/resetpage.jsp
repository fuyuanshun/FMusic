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
    <form action="" method="post" id="resetForm">
        <input type="hidden" value="<%=email%>" name="email">
        <p>
            <label>用户名</label>
            <input type="text" name="username">
        </p>
        <p>
            <label>用户密码</label>
            <input type="password" name="password" id="password">
        </p>

        <p>
            <label>确认密码</label>
            <input type="password" name="password2">
        </p>

        <p>
            <input type="submit" value="修改">
        </p>
    </form>
</body>
</html>
