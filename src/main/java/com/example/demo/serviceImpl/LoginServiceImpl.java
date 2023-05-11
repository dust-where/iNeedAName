package com.example.demo.serviceImpl;

import com.example.demo.bean.AdministratorBean;
import com.example.demo.mapper.LoginMapper;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public AdministratorBean getInfo(String name, String password) {
        return loginMapper.getInfo(name, password);
    }
}
