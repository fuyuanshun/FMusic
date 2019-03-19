<%@ page import="com.fys.music.model.Music" %>
<%@ page import="java.util.List" %>
<%@   page contentType="text/html;charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<%@include file="header.jsp"%>
<%request.setCharacterEncoding("utf-8");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>搜索结果</title>
    <script src="js/jquery/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
    <script type="text/javascript" src="js/bootstrap/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
    $(function(){
        $("table button.playbtn").click(function(){
            var id = $(this).val();
            $.ajax({
                url : "/FMusic/play",
                async : true,
                type : "POST",
                data : id,
                success : function(data){
                    $("#audio").attr("src", data);
                    if($("#audio")[0].paused){
                        $("#audio")[0].play();
                    } else {
                        $("#audio")[0].pause();
                    }
                },
                error : function() {
                    alert("服务器出了点问题~~请稍后再试哦~~嘤嘤嘤");
                },
                complete : function(xhr, status){
                    var REDIRECT = xhr.getResponseHeader("REDIRECT");
                    if(REDIRECT === "REDIRECT"){
                        alert("请先进行登陆！");
                        $(window).attr("location", "/FMusic/login");
                    }
                }
            })
        })
    })
</script>
<body>
<table class="table table-hover danger">
    <tr>
        <th>歌曲名称</th>
        <th>演唱者</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${sessionScope.musicList}" var="music">
        <tr>
            <th>
                <c:out value="${music.name}"/>
            </th>
            <th>
                <c:out value="${music.author}"/>
            </th>
            <th>
                <button value="id=${music.id}" class="playbtn"><img src="images/play.jpg" height="17px" width="20px"></button>
            </th>
        </tr>
    </c:forEach>
</table>
<audio id="audio" src=""></audio>
</body>
</html>
