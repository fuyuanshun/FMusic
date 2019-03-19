package com.fys.util;

import java.io.Serializable;

/**
 * 辅助类  返回json数据
 */
public class ResultUtil implements Serializable {
    private String code;
    private String msg;
    private Object data;

    @Override
    public String toString() {
        return "ResultUtil{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public ResultUtil(){

    }

    public ResultUtil(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
