package com.fys.music.controller;

import com.fys.util.DrawCheckImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 生成验证码图片
 */
@Controller
public class DrawImageController {

    public static final int WIDTH = 150;
    public static final int HEIGHT = 50;

    @RequestMapping("/drawImage")
    public void drawImage(HttpServletRequest req, HttpServletResponse resp) {
        //接收客户端传来的createTypeFlag
        String createTypeFlag = req.getParameter("createTypeFlag");

        //在内存中创建一张图片
        BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        DrawCheckImageUtil.setBackground(graphics, WIDTH, HEIGHT);
        DrawCheckImageUtil.setBorder(graphics, WIDTH, HEIGHT);
        DrawCheckImageUtil.drawRandomLine(graphics, WIDTH, HEIGHT);

        //根据客户端传递的createTypeFlag标识生成验证码图片
        String random = DrawCheckImageUtil.drawRandomNum((Graphics2D) graphics, createTypeFlag);

        //将随机数存在session中
        req.getSession().setAttribute("checkCode", random);
        //设置响应头信息为图片
        resp.setContentType("image/jpeg");
        //设置响应头控制浏览器不要缓存
        resp.setDateHeader("expries", -1);
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");
        //将图片写给浏览器
        try {
            ImageIO.write(bufferedImage, "jpg", resp.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}