package com.fys.music.controller;

import com.fys.music.model.Music;
import com.fys.music.service.FMusicService;
import com.fys.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *   Test Github Push
 */

@Controller
public class MusicController {
    @Autowired FMusicService userService;

    boolean b = true;

    /**
     * 主页
     */
    @RequestMapping("/")
    public String index(HttpServletRequest req) {
        List<Music> musicList = userService.selectMusic();
        req.setAttribute("musicList", musicList);

        String addr = req.getRemoteAddr();
        if (b) {
            if (!(addr.equals("127.0.0.1")) && !(addr.equals("117.159.12.38"))) {
                MailUtil.sendTo("有人访问你的的网站了~~ IP是： " + addr, "849485789@qq.com", "有人访问您的FMusic网站啦。嘤嘤嘤");
                b = false;
            }
        }

        return "index";
    }

    /**
     * 播放音乐
     */
    @RequestMapping("/music")
    public String music() {
        return "music";
    }

    /**
     * 热门音乐
     */
    @RequestMapping("/hotmusic")
    public String hotmusic() {
        return "hotmusic";
    }

    /**
     * 收藏音乐
     */
    @RequestMapping("/collect")
    @ResponseBody
    public String collected(@RequestParam("id")String id, @RequestParam("userId")String userId){
        return userService.collect(id, userId);
    }

    /**
     *
     */
    @RequestMapping("/favoriteMusic")
    public String favoriteMusic(HttpServletRequest req) {
        String id = (String) req.getSession().getAttribute("userId");
        List<Music> musicList = userService.selectAllMusic(id);
        req.setAttribute("musicList", musicList);
        req.setAttribute("userId", id);
        return "favoritemusic";
    }

    @RequestMapping("/play")
    @ResponseBody
    public String playMusic(@RequestParam("id")String musicId) {
        Music music = userService.selectMusicById(musicId);
        return music.getPath();
    }

    /**
     * 取消收藏音乐
     */
    @RequestMapping("/deleteFav")
    public @ResponseBody String deleteFav(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getParameter("userId");

        String id = req.getParameter("id");
        return userService.deleteFav(userId, id);
    }
}
