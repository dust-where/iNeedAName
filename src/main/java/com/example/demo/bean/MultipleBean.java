package com.example.demo.bean;

import java.util.List;

public class MultipleBean {
    private String mName;
    private String mId;

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    private List<MultipleTwoBean> multipleTwoBeans;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public List<MultipleTwoBean> getMultipleTwoBeans() {
        return multipleTwoBeans;
    }

    public void setMultipleTwoBeans(List<MultipleTwoBean> multipleTwoBeans) {
        this.multipleTwoBeans = multipleTwoBeans;
    }

    public MultipleBean(String mName, String mId, List<MultipleTwoBean> multipleTwoBeans) {
        this.mName = mName;
        this.mId = mId;
        this.multipleTwoBeans = multipleTwoBeans;
    }
}
