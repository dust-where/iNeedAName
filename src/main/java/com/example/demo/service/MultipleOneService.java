package com.example.demo.service;

import com.example.demo.bean.MultipleOneBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MultipleOneService {

    List<MultipleOneBean> findByQid(String qid);

    Boolean insertByQid(String qid, String mname);

    Boolean deleteByQid(String qid);
}
