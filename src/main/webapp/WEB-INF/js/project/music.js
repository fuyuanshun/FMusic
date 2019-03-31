var titles = new Array();
var mp3s = new Array();

//获取json文件的数据
function getJson() {
    getTitles(titles, mp3s);
    var json = "[";
    for(var i=0; i<titles.length; i++){
        json += '{"mp3":"'+mp3s[i]+'" , "title":"'+titles[i]+'"},'
    }
    return json;
};

//初始化数组内容
function getTitles(titles, mp3s) {
    $.getJSON("/FMusic/json/list.json", function (data) {
        $.each(data, function (infoIndex, info) {
            titles[infoIndex] = info["title"];
            mp3s[infoIndex] = info["mp3"];
        })
    })
};

$(function(){
    getTitles(titles, mp3s);
    //休眠500毫秒，为了确保数组初始化完成
    setTimeout(function () {
        var json = getJson();
        json = json.substr(0, json.length - 1);
        json = json + "]";
        //将json字符串转化为json对象
        json = JSON.parse(json);
        new jPlayerPlaylist({
            jPlayer: "#jquery_jplayer_1",
            cssSelectorAncestor: "#jp_container_1"
        }, [{"mp3":"//139.199.198.151:8080/repo/music/陈奕迅-陀飞轮.mp3" , "title":"陈奕迅-陀飞轮.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/薛之谦-丑八怪.mp3" , "title":"薛之谦-丑八怪.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/薛之谦-刚刚好.mp3" , "title":"薛之谦-刚刚好.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/Joey_Montana-Picky.mp3" , "title":"Joey_Montana-Picky.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/TheWeeknd-TheHills.mp3" , "title":"TheWeeknd-TheHills.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/ArianaGrande,NickiMinaj-SideToSide.mp3" , "title":"ArianaGrande,NickiMinaj-SideToSide.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/陈奕迅-陀飞轮.mp3" , "title":"陈奕迅-陀飞轮.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/The_Weeknd-The_Hills.mp3" , "title":"The_Weeknd-The_Hills.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/陈奕迅-一丝不挂.mp3" , "title":"陈奕迅-一丝不挂.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/陈奕迅-富士山下.mp3" , "title":"陈奕迅-富士山下.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/陈奕迅-落花流水.mp3" , "title":"陈奕迅-落花流水.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/薛之谦-演员.mp3" , "title":"薛之谦-演员.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/陈奕迅-红玫瑰.mp3" , "title":"陈奕迅-红玫瑰.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/薛之谦-绅士.mp3" , "title":"薛之谦-绅士.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/薛之谦-我好像在哪见过你.mp3" , "title":"薛之谦-我好像在哪见过你.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/薛之谦-丑八怪.mp3" , "title":"薛之谦-丑八怪.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/陈奕迅-苦瓜.mp3" , "title":"陈奕迅-苦瓜.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/薛之谦-演员.mp3" , "title":"薛之谦-演员.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/陈奕迅-红玫瑰.mp3" , "title":"陈奕迅-红玫瑰.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/Ariana_Grande,Nicki_Minaj-Side_To_Side.mp3" , "title":"Ariana_Grande,Nicki_Minaj-Side_To_Side.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/陈奕迅-苦瓜.mp3" , "title":"陈奕迅-苦瓜.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/薛之谦-绅士.mp3" , "title":"薛之谦-绅士.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/ss.mp3" , "title":"ss.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/JoeyMontana-Picky.mp3" , "title":"JoeyMontana-Picky.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/薛之谦-刚刚好.mp3" , "title":"薛之谦-刚刚好.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/twentyonepilots-StressedOut.mp3" , "title":"twentyonepilots-StressedOut.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/twenty_one_pilots-Stressed_Out.mp3" , "title":"twenty_one_pilots-Stressed_Out.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/陈奕迅-一丝不挂.mp3" , "title":"陈奕迅-一丝不挂.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/陈奕迅-富士山下.mp3" , "title":"陈奕迅-富士山下.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/薛之谦-我好像在哪见过你.mp3" , "title":"薛之谦-我好像在哪见过你.mp3"},{"mp3":"//139.199.198.151:8080/repo/music/陈奕迅-落花流水.mp3" , "title":"陈奕迅-落花流水.mp3"}], {
            /*swfPath: "../../dist/jplayer",*/
            swfPath: "/js/jplayer",
            supplied: "oga, mp3",
            wmode: "window",
            useStateClassSkin: true,
            autoBlur: false,
            smoothPlayBar: true,
            keyEnabled: true
        });
    }, 500);
});