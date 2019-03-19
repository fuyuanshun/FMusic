<%@page isELIgnored="false"%>
<%@   page contentType="text/html;charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<%request.setCharacterEncoding("utf-8");%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html charset=utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1" />
    <%--jquery--%>
    <script src="js/jquery/jquery.min.js"></script>
    <%--bootstarp--%>
    <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap/bootstrap.min.js"></script>
    <%--导入css文件--%>
    <link href="css/header.css" rel="stylesheet" >
    <script type="text/javascript" src="js/header.js"></script>
</head>
<%
    String result = (String)request.getSession().getAttribute("username");
    if(null == result){
        result = "";
    }%>
<body>
<div>
<nav class="top">
    <span><a href="${pageContext.request.contextPath}/">首页</a></span>
    <span><a href="/FMusic/hotmusic">发现音乐</a> </span>
    <span><a href="${pageContext.request.contextPath}/favoriteMusic">我的音乐</a> </span>
    <span><a href="#">朋友</a> </span>
    <span><a href="#">商城</a> </span>
    <span><a href="#">音乐人</a> </span>

    <span class="float-right">
            <%
                if(result.equals("")){
            %>
            <a href="${pageContext.request.contextPath}/login">请登陆</a>
            <%--判断用户是否登陆，如果已经登陆就显示用户名和退出按钮--%>
            <%}else if(null != result && !result.equals("")) {%>
        <span><a href ="${pageContext.request.contextPath}/myInfo?username=<%=result%>" title="个人中心"><%out.print(result);%></a></span>
            <a href="${pageContext.request.contextPath}/logout">退出</a>
            <%}%>
            <a href="${pageContext.request.contextPath}/register">
                还没有用户名?免费注册一个吧
            </a>
        </span>
</nav>
</div>
</body>
</html>
