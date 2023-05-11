package com.example.demo.service;

import com.example.demo.bean.MultipleTwoBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MultipleTwoService {

    List<MultipleTwoBean> findByMid(String mid);

    int updateByMt(String mt);

    Boolean insertByMid(String mid, String missue);

    Boolean deleteByMid(String mid);
}
