<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员页面</title>
    <script type="text/javascript" src="js/jquery/jquery.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
</head>

<a href="">退出</a><span>
<script type="text/javascript">
    $(function(){
        $("#uploadBtn").click(function(){
            $.ajax({
                url : "/FMusic/admin/upload/",
                type : "POST",
                processData: false,
                contentType: false,
                data : new FormData($("#uploadForm")[0]),
                success : function(data){
                    alert(data.msg);
                }
            })
        });
    });
</script>
<body>
<div>
    <span>文件上传</span>
    <form action="" method="POST" id="uploadForm" enctype="multipart/form-data">
        <input type="file" name="file">
        <button type="button" id="uploadBtn">上传</button>
    </form>
</div>
</body>
</html>
