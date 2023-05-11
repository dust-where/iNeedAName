package com.example.demo.bean;

import java.sql.Date;

public class QuestionnaireBean {
    private int qId;
    private int aId;
    private Date qLastTime;
    private String qName;

    public int getqId() {
        return qId;
    }

    public void setqId(int qId) {
        this.qId = qId;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public Date getqLastTime() {
        return qLastTime;
    }

    public void setqLastTime(Date qLastTime) {
        this.qLastTime = qLastTime;
    }

    public String getqName() {
        return qName;
    }

    public void setqName(String qName) {
        this.qName = qName;
    }
}
