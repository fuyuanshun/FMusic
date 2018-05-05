$(function () {
    $(".top span:lt(6)").mouseenter(function () {
        $(this).addClass("Item").siblings().removeClass("Item");
    }).mouseleave(function () {
        $(this).removeClass("Item");
    })

    $(".pull-right a").mouseenter(function () {
        $(this).addClass("Item").siblings().removeClass("Item");
    }).mouseleave(function () {
        $(this).removeClass("Item");
    })
})