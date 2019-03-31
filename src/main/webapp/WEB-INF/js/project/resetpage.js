$(function () {
    /**
     * 用户名校验规则
     */
    $.validator.addMethod("checkUsername", function (value, element, param) {
        if(/^[a-zA-Z0-9]{8,15}/.test(value)) {
            return true;
        } else {
            return false;
        }
    }, "用户名只能为大小写英文字符和数字组成");

    /**
     * 用户密码校验规则
     */
    $.validator.addMethod("checkPassword", function (value, element, param) {
        if(/^[a-zA-Z0-9\^\%\&\'\,\;\=\?\$\*]{8,15}/.test(value)) {
            return true;
        } else {
            return false;
        }
    }, "用户密码不能出现非法字符.合法特殊字符为: ^ % & ' , ; = ? $ *");

    /**
     * 回调函数
     */
    $.validator.setDefaults({
        submitHandler: function() {
            var json = $("#resetForm").serialize();
            $.ajax({
                url: "/FMusic/updatePassword",
                type: "post",
                data: json,
                async: true,
                success: function (data, textStatus) {
                    if(data == "updateSuccess") {
                        alert("修改用户密码成功!");
                        $(window).attr('location', '/FMusic/login');
                    } else if (data == "updateError") {
                        alert("用户名与邮箱不一致!");
                    }
                },
                error: function () {
                    alert("请求出错啦。。请稍后重试");
                }
            })
        }
    })

    /**
     * 表单验证规则
     */
    $("#resetForm").validate({
        rules : {
            username : {
                required : true,
                minlength : 8,
                maxlength : 15,
                checkUsername :true
            },
            password : {
                required : true,
                minlength : 8,
                maxlength : 15,
                checkPassword :true
            },
            password2 :{
                required : true,
                equalTo : "#password"
            },
        },
        messages : {
            username : {
                required : "此选项为必填项",
                minlength : "用户名最小长度为8位",
                maxlength : "最大长度为15位"
            },
            password : {
                required : "此选项为必填项",
                minlength : "密码最小长度为8位",
                maxlength : "最大长度为15位"

            },
            password2 :{
                required : "此选项为必填项",
                equalTo : "两次输入密码不一致"
            }
        }
    })
})