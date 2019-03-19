<%--
  Created by IntelliJ IDEA.
  User: 付元顺
  Date: 2019/2/10
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登陆</title>
    <%-- jquery --%>
    <script type="text/javascript" src="js/jquery/jquery.min.js"></script>
    <%-- bootstrap css文件 --%>
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
    <%-- bootstrap js文件 --%>
    <script type="text/javascript" src="js/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/adminLogin.js"></script>
    <link rel="stylesheet" href="css/adminLogin.css">
</head>
<body class="loginbg">
   <div class="container">
       <div class="row row-centered">
           <div class="well col-md-6 col-centered">
               <h2 class="text-center text-danger">管理员登陆</h2>
               <form action="/login" method="post" id="form">
                   <div class="input-group input-group-md">
                       <input type="text" class="form-control" id="username" name="username" placeholder="用户名"/>
                   </div>
                   <div class="input-group input-group-md">
                       <input type="password" class="form-control" id="password" name="password" placeholder="用户密码"/>
                   </div>
                   <br/>
                   <button type="button" class="btn btn-success btn-block" id="adminbtn">登录</button>
               </form>
           </div>
       </div>
   </div>

</body>
</html>
