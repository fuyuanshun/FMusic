$(document).ready(function(){
    var localObj = window.location;

    var contextPath = localObj.pathname.split("/")[1];

    var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;

    var server_context=basePath;

    var description = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce id tortor nisi. Aenean sodales diam ac lacus elementum scelerisque. Suspendisse a dui vitae lacus faucibus venenatis vel id nisl. Proin orci ante, ultricies nec interdum at, iaculis venenatis nulla. ';

    var myPlaylist = [
        {
            mp3:'auto/we.mp3',
            title:'我们-陈奕迅',
            artist:'FMusic',
            rating:4,
            buy:'#',
            duration:'2:30',
            cover:'auto/1.png'
        },
        {
            mp3:'auto/纸短情长.mp3',
            title:'纸短情长',
            artist:'FMusic',
            rating:4,
            buy:'#',
            duration:'2:31',
            cover:'auto/1.png'
        },
        {
            mp3:'auto/裙下之臣.mp3',
            title:'裙下之臣-陈奕迅',
            artist:'FMusic',
            rating:4,
            buy:'#',
            duration:'2:10',
            cover:'auto/1.png'
        },
    ];

    $('body').ttwMusicPlayer(myPlaylist, {
        autoPlay:false,
        description:description,
        jPlayer:{
            swfPath:server_context+'/js/jplayer' //You need to override the default swf path any time the directory structure changes
        }
    });
});