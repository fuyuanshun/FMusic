$(function(){
    $("#adminbtn").click(function(){
        var json = $("#form").serialize();
        console.info(json);
        $.ajax({
            url : "/FMusic/admin/login",
            type : "POST",
            data : json,
            success: function (data) {
                if (data === "success") {
                    alert("登陆成功!");
                    $(window).attr("location", "/FMusic/admin/index");
                } else {
                    alert(data);
                }
            }
        })

    })
})