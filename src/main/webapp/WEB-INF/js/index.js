$(function () {
    $(".top2 ul li").mouseenter(function () {
        var index = $(this).index();
        $(".top3 div:eq("+index+")").show();
        $(".new0").hide();
    }).mouseleave(function () {
        $(".new0").show();
        var index = $(this).index();
        $(".top3 div:eq("+index+")").hide();
    });

    (function(doc){var addEvent='addEventListener',type='gesturestart',qsa='querySelectorAll',scales=[1,1],meta=qsa in doc?doc[qsa]('meta[name=viewport]'):[];function fix(){meta.content='width=device-width,minimum-scale='+scales[0]+',maximum-scale='+scales[1];doc.removeEventListener(type,fix,true);}if((meta=meta[meta.length-1])&&addEvent in doc){fix();scales=[.25,1.6];doc[addEvent](type,fix,true);}}(document));
})