package com.example.demo.bean;

import java.util.List;

public class SingleBean {
    private String sName;
    private String sId;
    private List<SingleTwoBean> singleTwoBeans;

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public List<SingleTwoBean> getSingleTwoBeans() {
        return singleTwoBeans;
    }

    public void setSingleTwoBeans(List<SingleTwoBean> singleTwoBeans) {
        this.singleTwoBeans = singleTwoBeans;
    }

    public SingleBean(String sName, String sId, List<SingleTwoBean> singleTwoBeans) {
        this.sName = sName;
        this.sId = sId;
        this.singleTwoBeans = singleTwoBeans;
    }
}
