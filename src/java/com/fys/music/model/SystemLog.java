package com.fys.music.model;

import java.util.Date;

public class SystemLog {
    private String operator;
    private String content;
    private Date operatDate;

    public SystemLog(String operator, String content, Date operatDate) {
        this.operator = operator;
        this.content = content;
        this.operatDate = operatDate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getOperatDate() {
        return operatDate;
    }

    public void setOperatDate(Date operatDate) {
        this.operatDate = operatDate;
    }
}
