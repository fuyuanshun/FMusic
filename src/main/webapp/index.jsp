<%@page isELIgnored="false"%>
<%@   page   contentType="text/html;charset=utf-8"%>
<%@ page   pageEncoding="utf-8"%>
<jsp:include page="WEB-INF/jsp/header.jsp"></jsp:include>
<%response.setCharacterEncoding("utf8");%>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>

    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lato:400,700" />
    <link rel="shortcut icon" href="../favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/musicdemo/reset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/musicdemo/demo.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/musicdemo/audioplayer.css" />
</head>
<body>
<%--<div class="top2">
    <br><br><br>
    <ul>
        <li><a href="${pageContext.request.contextPath}/music.action">推荐</a></li>
        <li><a href="${pageContext.request.contextPath}/hotmusic.action">热门音乐</a></li>
        <li><a href="${pageContext.request.contextPath}/music.action">流行音乐</a></li>
    </ul>
</div>--%>
<div class="top3">
    <div class="new1 main">
        <a href="${pageContext.request.contextPath}/music.action">播放</a>
    </div>

    <div class="new2 main">
        <a href="${pageContext.request.contextPath}/music.action">播放2</a>
    </div>

    <div class="new3 main">
        <a href="${pageContext.request.contextPath}/music.action">播放3</a>
    </div>
</div>

<div class="new0">
    <a href="${pageContext.request.contextPath}/music.action">更多音乐1</a><br><br>
    <a href="${pageContext.request.contextPath}/hotmusic.action">更多音乐2</a><br><br>
    <a href="${pageContext.request.contextPath}/resource.action?currentPage=1">福利</a><br><br>
    <br><br><br><br>
    <div id="wrapper">
        <span>登陆才可以听音乐哦~~</span>
        <audio preload="auto" controls>
            <source src="${pageContext.request.contextPath}/auto/we.mp3">
        </audio>
        <script src="${pageContext.request.contextPath}/js/musicdemo/audioplayer.min.js"></script>
        <script>$( function() { $( 'audio' ).audioPlayer(); } );</script>
    </div>

</div>
</body>
</html>
