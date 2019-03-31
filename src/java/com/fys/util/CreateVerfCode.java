package com.fys.util;

import java.util.Random;

/**
 * 生成四位随机验证码
 */
public class CreateVerfCode {
    public static String getVerfCode() {
        Random random = new Random();
        return (random.nextInt(8999) + 1000)+"";
    }
}