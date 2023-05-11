package com.example.demo.serviceImpl;

import com.example.demo.bean.AdministratorBean;
import com.example.demo.mapper.AdministratorMapper;
import com.example.demo.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public AdministratorBean loginIn(String name, String password) {
        return administratorMapper.getInfo(name, password);
    }
}
