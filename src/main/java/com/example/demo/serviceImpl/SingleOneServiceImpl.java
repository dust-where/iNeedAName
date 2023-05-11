package com.example.demo.serviceImpl;

import com.example.demo.bean.SingleOneBean;
import com.example.demo.mapper.SingleOneMapper;
import com.example.demo.service.SingleOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingleOneServiceImpl implements SingleOneService {

    @Autowired
    private SingleOneMapper singleOneMapper;


    @Override
    public List<SingleOneBean> findByQid(String qid) {
        return singleOneMapper.findByqId(qid);
    }

    @Override
    public Boolean insertByqid(String qid, String sname) {
        return singleOneMapper.insertByqid(qid, sname);
    }

    @Override
    public Boolean deleteByQid(String qid) {
        return singleOneMapper.deleteByQid(qid);
    }
}
