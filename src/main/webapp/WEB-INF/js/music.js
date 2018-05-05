$(document).ready(function(){
    var localObj = window.location;

    var contextPath = localObj.pathname.split("/")[1];

    var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;

    var server_context=basePath;

    new jPlayerPlaylist({
        jPlayer: "#jquery_jplayer_1",
        cssSelectorAncestor: "#jp_container_1"
    }, [
        {
            title:"我们",
            mp3:server_context+"/auto/we.mp3",
        },
        {
            title:"纸短情长",
            mp3:server_context+"/auto/纸短情长.mp3",
        },
        {
            title:"裙下之臣",
            mp3:server_context+"/auto/裙下之臣.mp3",
        },
        {
            title:"Hidden",
            mp3:"http://www.jplayer.org/audio/mp3/Miaow-02-Hidden.mp3",
            oga:"http://www.jplayer.org/audio/ogg/Miaow-02-Hidden.ogg"
        },
        {
            title:"Lentement",
            free:true,
            mp3:"http://www.jplayer.org/audio/mp3/Miaow-03-Lentement.mp3",
            oga:"http://www.jplayer.org/audio/ogg/Miaow-03-Lentement.ogg"
        },
        {
            title:"Lismore",
            mp3:"http://www.jplayer.org/audio/mp3/Miaow-04-Lismore.mp3",
            oga:"http://www.jplayer.org/audio/ogg/Miaow-04-Lismore.ogg"
        },
        {
            title:"The Separation",
            mp3:"http://www.jplayer.org/audio/mp3/Miaow-05-The-separation.mp3",
            oga:"http://www.jplayer.org/audio/ogg/Miaow-05-The-separation.ogg"
        },
        {
            title:"Beside Me",
            mp3:"http://www.jplayer.org/audio/mp3/Miaow-06-Beside-me.mp3",
            oga:"http://www.jplayer.org/audio/ogg/Miaow-06-Beside-me.ogg"
        },
        {
            title:"Bubble",
            free:true,
            mp3:"http://www.jplayer.org/audio/mp3/Miaow-07-Bubble.mp3",
            oga:"http://www.jplayer.org/audio/ogg/Miaow-07-Bubble.ogg"
        },
        {
            title:"Stirring of a Fool",
            mp3:"http://www.jplayer.org/audio/mp3/Miaow-08-Stirring-of-a-fool.mp3",
            oga:"http://www.jplayer.org/audio/ogg/Miaow-08-Stirring-of-a-fool.ogg"
        },
        {
            title:"Partir",
            free: true,
            mp3:"http://www.jplayer.org/audio/mp3/Miaow-09-Partir.mp3",
            oga:"http://www.jplayer.org/audio/ogg/Miaow-09-Partir.ogg"
        },
        {
            title:"Thin Ice",
            mp3:"http://www.jplayer.org/audio/mp3/Miaow-10-Thin-ice.mp3",
            oga:"http://www.jplayer.org/audio/ogg/Miaow-10-Thin-ice.ogg"
        }
    ], {
        /*swfPath: "../../dist/jplayer",*/
        swfPath: server_context+"/js/jplayer",
        supplied: "oga, mp3",
        wmode: "window",
        useStateClassSkin: true,
        autoBlur: false,
        smoothPlayBar: true,
        keyEnabled: true
    });
});