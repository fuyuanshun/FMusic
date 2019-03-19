$(function () {
    /**
     * 回调函数
     */
    $.validator.setDefaults({
        submitHandler: function() {
            var json = $("#getPassword").serialize();
            $.ajax({
                url : "/FMusic/forgetPasswordDeal",
                data : json,
                type : "post",
                async : true,
                success : function (data, textStatus) {
                    if(data == "emailIsNotRegister") {
                        alert("邮箱还没有注册用户！请先注册!");
                    } else if(data == "success"){
                        alert("重置密码邮件已经发送，请登陆邮箱进行重置!")
                        $(window).attr('location', '/FMusic/login');
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