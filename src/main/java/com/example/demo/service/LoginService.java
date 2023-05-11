package com.example.demo.service;

import com.example.demo.bean.AdministratorBean;

public interface LoginService {

    AdministratorBean getInfo(String name, String password);
}
