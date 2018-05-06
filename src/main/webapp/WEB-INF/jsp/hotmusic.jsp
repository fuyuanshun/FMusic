<!--本页面从http://www.codebasehero.com下载， 具体下载链接:http://www.codebasehero.com/download/?file=music-player-->
<%@page isELIgnored="false"%>
<%@   page contentType="text/html;charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<jsp:include page="header.jsp"></jsp:include>
<%request.setCharacterEncoding("utf-8");%>
<html>
<head>
    <title>热门音乐</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hotmusic/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hotmusic/demo.css">

    <%--JQuery jplayer插件--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jplayer/jquery.jplayer.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jplayer/ttw-music-player-min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/hotmusic.js"></script>
</head>
<body>
<div id="title"></div>
<a href="#" id="download">返回首页</a>
</body>
</body>
</html>
