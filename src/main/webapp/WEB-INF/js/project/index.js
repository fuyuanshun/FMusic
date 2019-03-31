$(function(){
    $(".content .music button.collect").click(function(){
        var id = $(this).val();
        $.ajax({
            url : "/FMusic/collect",
            async : true,
            type : "POST",
            data : id,
            success : function(data){
                if (data === "success") {
                    $(this).addClass('collected');
                    $(this).removeClass('btn-danger');
                    alert("收藏成功 请去我的音乐查看!")
                } else if (data === "exist") {
                    alert("收藏失败，该歌曲已经被收藏过了")
                }
            },
            error : function() {
                alert("服务器出了点问题~~请稍后再试哦~~嘤嘤嘤");
            },
            complete : function(xhr, status){
                var REDIRECT = xhr.getResponseHeader("REDIRECT");
                if(REDIRECT === "REDIRECT"){
                    alert("请先进行登陆！");
                    $(window).attr("location", "/FMusic/login");
                }
            }
        })
    })

    $(".content .music button.play").click(function(){
        var id = $(this).val();

        $.ajax({
            url : "/FMusic/play",
            async : true,
            type : "POST",
            data : id,
            success : function(data){
                if(data.length>120){
                    return;
                }
                $("#audio").attr("src", data);
                if($("#audio")[0].paused){
                    $("#audio")[0].play();
                } else {
                    $("#audio")[0].pause();
                }
            },
            error : function() {
                alert("服务器出了点问题~~请稍后再试哦~~嘤嘤嘤");
            },
            complete : function(xhr, status){
                var REDIRECT = xhr.getResponseHeader("REDIRECT");
                if(REDIRECT === "REDIRECT"){
                    alert("请先进行登陆！");
                    $(window).attr("location", "/FMusic/login");
                }
            }
        })
    })
})