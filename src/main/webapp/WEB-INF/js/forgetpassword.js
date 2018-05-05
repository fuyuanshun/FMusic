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
                url : server_context+"/forgetPasswordDeal.action",
                data : json,
                type : "post",
                async : true,
                success : function (data, textStatus) {
                    alert(data);
                    alert("the email is send success!")
                },
                error : function () {
                    alert("send email is error ! please try again later")
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