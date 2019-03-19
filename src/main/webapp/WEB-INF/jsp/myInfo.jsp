<%@ page import="com.fys.music.model.User" %>
<jsp:include page="header.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User user = (User)request.getSession().getAttribute("user");
%>

<html>
<head>
    <title>个人中心</title>
    <script type="text/javascript" src="js/jquery/jquery.min.js"></script>
    <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="js/myInfo.js"></script>
</head>
<body>
<h4 class="title text-danger text-center">个人中心</h4>
<table class="table table-hover danger" border="1">
    <tr>
        <th>用户名</th>
        <th><%=user.getUsername()%></th>
    </tr>
    <tr>
        <th>个性签名</th>
        <th>
            <input type="hidden" id="username" name="username" value="<%=user.getUsername()%>">
            <textarea id="signature" name="signature" style="height:50px; width:300px; resize : none" placeholder="还没有个性签名哦~"><%=user.getSignature()%></textarea>
            <button id="signature_btn" class="button btn-success">保存</button>
        </th>
    </tr>
    <tr>
        <th>性别</th>
        <th><%if(user.getSex().equals("男")){
            out.print("<img src='images/b.png' width=50px height=50px></img>");
        } else {
            out.print("<img src='images/girl.png' width=50px height=50px></img>");
        }%></th>
    </tr>
    <tr>
        <th>电子邮箱</th>
        <th><%=user.getEmail()%></th>
    </tr>
    <tr>
        <th>爱好</th>
        <th><%=user.getHobby()%></th>
    </tr>
    <tr>
        <th>手机号码</th>
        <th><%=user.getPhone()%></th>
    </tr>
    <tr>
        <th>地址</th>
        <th><%=user.getAddress()%></th>
    </tr>
    <tr>
        <th>最近登录时间</th>
        <th><%=user.getLastLoginTime()%></th>
    </tr>
</table>
</body>
</html>
