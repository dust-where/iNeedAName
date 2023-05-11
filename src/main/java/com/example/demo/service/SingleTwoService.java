package com.example.demo.service;

import com.example.demo.bean.SingleTwoBean;

import java.util.List;

public interface SingleTwoService {

    List<SingleTwoBean> findBySid(String sid);

    int updateBySt(String st);

    Boolean insertBySid(String sid, String sissue);

    Boolean deleteBySid(String sid);
}
