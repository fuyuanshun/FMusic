$(function () {
    /**
     * 自定义手机号校验规则
     */
    $.validator.addMethod("isNumber", function (value, element, param) {
        if(/^[0-9]{11}$/.test(value)) {
            return true;
        } else {
            return false;
        }
    }, "请输入11位数字的手机号码");

    /**
     * 自定义年龄校验规则
     */
    $.validator.addMethod("checkAge", function (value, element, param) {
        if(/^[0-9]+$/.test(value)) {
            if (value == 0) {
                return false;
            } else if (value > 250) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }, "请正确的输入您的年龄");

    /**
     * 生日校验规则
     */
    $.validator.addMethod("checkBirthday", function (data, element, param) {
        if(/^[0-9]{4}\-(0[1-9]|[1-9]|1[0-2])\-([0][0-9]|[1][0-9]|[2][0-9]|[3][0-1])$/.test(data)) {
            return true;
        } else {
            return false;
        }
    }, "生日格式为xxxx-xx-xx. 例: 1999-11-11");

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
            var json = $("#myform").serialize();

            $.ajax({
                url : method.getPath() +"/registerDeal.action",
                type : "post",
                async : true,
                data : json,
                success : function (data, textStatus) {
                    var json2 = eval("("+data+")");
                    var result = json2[0].rresult;
                    if(result == "用户名已经存在") {
                        alert("用户名已经存在");
                    } else if (result == "注册成功") {
                        alert("注册成功!");
                        $(window).attr('location', server_context +'/login.action');
                    } else if (result == "registerfail") {
                        alert("邮箱已经被使用!");
                    }
                },
                error : function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("请求出错啦。。请重试")
                }
            })
        }
    });


    $("#myform").validate({
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
            email : {
                required : true,
                email : true
            },
            sex : {
                required : true
            },
            age : {
                required : true,
                checkAge : true
            },
            phone : {
                required : true,
                isNumber : true
            },
            birthday : {
                required : true,
                checkBirthday : true
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
            },
            email : {
                required : "此选项为必填项",
                email : "请输入您的邮箱地址"
            },
            sex : {
                required : "",
            },
            age : {
                required : "此选项为必填项",
            },
            phone : {
                required : "此选项为必填项",
            },
            birthday : {
                required : "此选项为必填项",
            },
            address : {
                required : "此选项为必填项",
            },
            hobby : {
                required : "此选项为必填项",
            }
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