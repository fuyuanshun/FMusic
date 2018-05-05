$(function () {
    var localObj = window.location;

    var contextPath = localObj.pathname.split("/")[1];

    var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;

    var server_context=basePath;

    /**
     * 回调函数
     */
    $.validator.setDefaults({
        submitHandler: function() {
            var json = $("#getPassword").serialize();
            $.ajax({
                url : server_context+"/forgetPasswordDeal",
                data : json,
                type : "post",
                async : true,
                success : function (data, textStatus) {
                    var json2 = eval("(" + data + ")");
                    var ret = json2[0].rresult;
                    if(ret == "exist") {
                        alert("邮箱还没有注册用户！请先注册!");
                    } else if(ret == "success"){
                        alert("重置密码邮件已经发送，请登陆邮箱进行重置!")
                        $(window).attr('location', method.getPath() +'/login');
                    }
                },
                error : function () {
                    alert("访问出错啦。。请稍后重试")
                }
            })
        }
    })

    /**
     * 验证规则
     */
    $("#getPassword").validate({
        rules : {
            email : {
                required : true,
                email : true
            }
        },
        messages : {
            required : "请填写您的邮箱，以便验证",
            email: "请正确填写您的邮箱"
        }
    })

})

/*可以获得当前项目的路径*/
var method  = {
    getPath : function getPath() {
        var localObj = window.location;

        var contextPath = localObj.pathname.split("/")[1];

        var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;

        var server_context=basePath;

        return server_context;
    }
}