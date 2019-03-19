var titles = new Array();
var mp3s = new Array();
//读取json文件
function getTitles () {
    $.getJSON("/FMusic/json/list.json", function (data) {
        $.each(data, function (infoIndex, info) {
            titles[infoIndex] = info["title"];
            mp3s[infoIndex] = info["mp3"];
        })
    })
};

//获得音乐列表
function getList() {
    //先初始化数组
    getTitles();
    //休眠500毫秒再进行下一步操作，为了确保数组初始化完成
    setTimeout(function () {
        var json = "[";
        for(var i=0; i<titles.length; i++){
            json += '{"mp3":"'+mp3s[i]+'" , "title":"'+titles[i]+'"},'
        }
        json = json.substr(0, json.length - 1);
        json = json + "]";
        //将json字符串转化为json对象
        json = JSON.parse(json);
        var description = 'Welcome FMusic';
        $('body').ttwMusicPlayer(json, {
            autoPlay:false,
            description:description,
            jPlayer:{
                swfPath: '/js/jplayer'
            }
        });
    }, 500)
};

$(document).ready(function(){
    getList();
});
