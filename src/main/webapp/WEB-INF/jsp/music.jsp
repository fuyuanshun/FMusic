<%@page isELIgnored="false"%>
<%@   page contentType="text/html;charset=utf-8" %>
<%@ page pageEncoding="utf-8" %>
<jsp:include page="header.jsp"></jsp:include>
<%request.setCharacterEncoding("utf-8");%>
 <!DOCTYPE html>
<html>
<head>
  <title>音乐列表</title>
 <link href="${pageContext.request.contextPath}/css/jplayer.blue.monday.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jplayer/jquery.jplayer.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jplayer/jplayer.playlist.min.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/music.js"></script>
</head>

<style type="text/css">
  .cl{
   clear : both;
   height : 8px;
  }

  #jp_container_1{
   margin : 0 auto;
  }
    body div.wrap {
     background: url(/FMusic/images/login.jpg) no-repeat center top;
    }
</style>

 <body>
 <div class="cl"></div>
 <%--<div class="play_box">
 </div>--%>
 <div class="wrap">
  <div id="jquery_jplayer_1" class="jp-jplayer"></div>
  <div id="jp_container_1" class="jp-audio" role="application" aria-label="media player">
   <div class="jp-type-playlist">
    <div class="jp-gui jp-interface">

     <%--播放控制键--%>
     <div class="jp-controls">
      <button class="jp-previous" role="button" tabindex="0">previous</button>
      <button class="jp-play" role="button" tabindex="0">play</button>
      <button class="jp-next" role="button" tabindex="0">next</button>
      <button class="jp-stop" role="button" tabindex="0">stop</button>
     </div>

     <%--进度条--%>
     <div class="jp-progress">
      <div class="jp-seek-bar">
       <div class="jp-play-bar"></div>
      </div>
     </div>

     <%--音量控制键--%>
     <div class="jp-volume-controls">
      <button class="jp-mute" role="button" tabindex="0">mute</button>
      <button class="jp-volume-max" role="button" tabindex="0">max volume</button>
      <div class="jp-volume-bar">
       <div class="jp-volume-bar-value"></div>
      </div>
     </div>

     <%--视频时间和重复播放按钮--%>
     <%--<div class="jp-time-holder">
      <div class="jp-current-time" role="timer" aria-label="time">&nbsp;</div>
      <div class="jp-duration" role="timer" aria-label="duration">&nbsp;</div>
     </div>--%>

     <%--循环播放和随机播放按钮--%>
     <div class="jp-toggles">
      <button class="jp-repeat" role="button" tabindex="0">repeat</button>
      <button class="jp-shuffle" role="button" tabindex="0">shuffle</button>
     </div>
    </div>
    <%--播放列表--%>
    <div class="jp-playlist">
     <ul>
      <li>&nbsp;</li>
     </ul>
    </div>
    <div class="jp-no-solution">
     <span>Update Required</span>
     To play the media you will need to either update your browser to a recent version or update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>.
    </div>
   </div>
  </div>
 </div>
 </body>
 </html>

