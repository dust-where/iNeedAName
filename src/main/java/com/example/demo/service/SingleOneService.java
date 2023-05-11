package com.example.demo.service;

import com.example.demo.bean.SingleOneBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SingleOneService {

    List<SingleOneBean> findByQid(String qid);

    Boolean insertByqid(String qid, String sname);

    Boolean deleteByQid(String qid);
}
