<%@ page import="com.fys.music.model.Music" %>
<%@ page import="java.util.List" %>
<%@page isELIgnored="false"%>
<%@ page pageEncoding="utf-8" %>
<jsp:include page="header.jsp"></jsp:include>
<%request.setCharacterEncoding("utf-8");%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的收藏</title>
    <link rel="stylesheet" href="css/favoritemusic.css">
</head>
<%
    List<Music> musicList = (List<Music>) request.getAttribute("musicList");
    String userId = (String)request.getAttribute("userId");
%>
<script type="text/javascript">
    $(function(){
        $("div div.list .music_list button.playbtn").click(function(){
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

        $("div div.list .music_list button.delete").click(function(){
            var id = $(this).val();
            var userId = $("#userId").val();
            if(confirm('确定要取消收藏吗?')) {
                $.ajax({
                    url : "/FMusic/deleteFav",
                    type : "POST",
                    data : id + "&userId=" + userId,
                    success : function(data){
                        if (data === "success") {
                            alert("取消成功!")
                            location.reload();
                        } else {
                            alert("取消失败!")
                        }
                    }
                })
            }
        })
    })
</script>
<body>
<input type="hidden" value="<%=userId%>" id="userId">
<div class="content">
    <div class="left">
        <ul>
            <li class="first"><h5>我的歌单</h5></li>
            <li>
                <a href="#">
                    <div class="leftimg">
                        <img src="images/bg.jpg">
                    </div>
                    <span>我喜欢的音乐</span>
                    <span> <%if(null != musicList ){%><%=musicList.size()%><%}%>首</span>
                </a>
            </li>
        </ul>
    </div>
    <div class="right">
        <div class="top"></div>
        <div class="music">
            <div class="info">
                <h3><span>歌曲列表</span></h3>
                <span> <%if(null != musicList ){%><%=musicList.size()%><%}%>首歌</span>
            </div>
            <div class="list">
                <table>
                    <thead>
                    <tr>
                        <th class="first"><div>&nbsp</div></th>
                        <th class="second"><div>歌曲标题</div></th>
                        <th class="_3"><div>时长</div></th>
                        <th class="_4"><div>歌手</div></th>
                        <th class="_5"><div>专辑</div></th>
                    </tr>
                    <%if(null != musicList && musicList.size() != 0){
                        for(Music music : musicList){
                    %>
                    <tr class="music_list">
                        <th><div><button class="delete" value="id=<%=music.getId()%>"><img title="取消收藏" src="images/d.png" height="17px" width="20px"></button>&nbsp;&nbsp;<button value="id=<%=music.getId()%>" class="playbtn"><img src="images/play.jpg" height="17px" width="20px"></button></div></th>
                        <th><div><%=music.getName()%></div></th>
                        <th><div>--</div></th>
                        <th><div><%=music.getAuthor()%></div></th>
                        <th><div>--</div></th>
                    </tr>
                    <%}}%>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>
<audio id="audio" src=""></audio>
</body>
</html>
