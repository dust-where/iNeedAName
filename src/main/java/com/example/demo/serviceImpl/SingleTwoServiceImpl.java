package com.example.demo.serviceImpl;

import com.example.demo.bean.SingleTwoBean;
import com.example.demo.mapper.SingleTwoMapper;
import com.example.demo.service.SingleTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingleTwoServiceImpl implements SingleTwoService {

    @Autowired
    private SingleTwoMapper singleTwoMapper;

    @Override
    public List<SingleTwoBean> findBySid(String sid) {
        return singleTwoMapper.findBySid(sid);
    }

    @Override
    public int updateBySt(String st) {
        return singleTwoMapper.updateBySt(st);
    }

    @Override
    public Boolean insertBySid(String sid, String sissue) {
        return singleTwoMapper.insertBySid(sid, sissue);
    }

    @Override
    public Boolean deleteBySid(String sid) {
        return singleTwoMapper.deleteBySid(sid);
    }
}
