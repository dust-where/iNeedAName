package com.example.demo.serviceImpl;

import com.example.demo.bean.MultipleOneBean;
import com.example.demo.mapper.MultipleOneMapper;
import com.example.demo.service.MultipleOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultipleOneServiceImpl implements MultipleOneService {

    @Autowired
    private MultipleOneMapper multipleOneMapper;

    @Override
    public List<MultipleOneBean> findByQid(String qid) {
        return multipleOneMapper.findByqId(qid);
    }

    @Override
    public Boolean insertByQid(String qid, String mname) {
        return multipleOneMapper.insertByQid(qid, mname);
    }

    @Override
    public Boolean deleteByQid(String qid) {
        return multipleOneMapper.deleteByQid(qid);
    }
}
