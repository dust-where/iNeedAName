package com.example.demo.serviceImpl;

import com.example.demo.bean.MultipleTwoBean;
import com.example.demo.mapper.MultipleTwoMapper;
import com.example.demo.service.MultipleTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultipleTwoServiceImpl implements MultipleTwoService {

    @Autowired
    MultipleTwoMapper multipleTwoMapper;


    @Override
    public List<MultipleTwoBean> findByMid(String mid) {
        return multipleTwoMapper.findByMid(mid);
    }

    @Override
    public int updateByMt(String mt) {
        return multipleTwoMapper.updateByMt(mt);
    }

    @Override
    public Boolean insertByMid(String mid, String missue) {
        return multipleTwoMapper.insertByMid(mid, missue);
    }

    @Override
    public Boolean deleteByMid(String mid) {
        return multipleTwoMapper.deleteByMid(mid);
    }
}
