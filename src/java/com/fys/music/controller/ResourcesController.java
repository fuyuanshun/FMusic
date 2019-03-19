package com.fys.music.controller;

import com.fys.music.model.Resource;
import com.fys.music.server.FMusicService;
import com.fys.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.regex.Pattern;

@Controller
public class ResourcesController {
    @Autowired FMusicService userService;

    /**
     * 资源列表页面
     */
    @RequestMapping("/resource")
    public ModelAndView resource(HttpServletRequest res, HttpServletResponse resp) {
        String currentPageStr;
        if(null != res.getParameter("currentPage")) {
            currentPageStr = res.getParameter("currentPage");
        } else {
            currentPageStr = "1";
            res.setAttribute("currentPage", 1);
        }
        int currentPage = 1;
        if(null !=  currentPageStr && !currentPageStr.equals("")) {
            if (Pattern.matches("^[0-9]+$", currentPageStr)) {
                currentPage = Integer.parseInt(currentPageStr);
            } else {
                currentPage = 1;
            }
        }
        //所有的磁力链
        List<Resource> resources = userService.selectResource();

        Page page = new Page(resources.size(), currentPage);
        page.init();
        int pageSize = page.getPageSize();

        if(currentPage < 1) {
            currentPage = 1;
        }
        if(currentPage > page.getTotalPage()) {
            currentPage = page.getTotalPage();
        }

        //分页查询的磁力链
        List<Resource> paging = userService.selectResourceByPage(currentPage, pageSize);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("totalPage", page.getTotalPage());
        modelAndView.addObject("currentPage", currentPage);
        res.setAttribute("currentPage", currentPage);
        modelAndView.addObject("resources", paging);
        modelAndView.addObject("page1", page);
        modelAndView.setViewName("resource");
        return modelAndView;
    }
}
