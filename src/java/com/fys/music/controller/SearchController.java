package com.fys.music.controller;

import com.fys.music.dao.FMusicDao;
import com.fys.music.model.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class SearchController {
    @Autowired FMusicDao userDao;

    /**
     * 搜索
     */
    @RequestMapping("/search")
    public String search(HttpServletRequest req, HttpServletResponse resp) {
        String searchContent = req.getParameter("searchContent");
        if (searchContent.trim().equals("")) {
            return "redirect:/";
        } else {
            List<Music> musicList = userDao.search(searchContent);
            req.getSession().setAttribute("musicList", musicList);
            return "search";
        }
    }
}