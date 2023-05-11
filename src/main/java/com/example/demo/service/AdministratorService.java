package com.example.demo.service;

import com.example.demo.bean.AdministratorBean;
import org.apache.ibatis.annotations.Select;

public interface AdministratorService {

    AdministratorBean loginIn(String name, String password);

}
