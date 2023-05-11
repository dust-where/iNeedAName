package com.example.demo.controller;

import com.example.demo.bean.AdministratorBean;
import com.example.demo.service.AdministratorService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@Controller
public class loginController {

    @Autowired
    AdministratorService administratorService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/getCode")
    @ResponseBody
    public String getCode(HttpServletRequest request) {
        String random = getRandomCode();
        System.out.println(random);
        return "aaaaa";
//        return random;
    }

    @PostMapping("/login")
    @ResponseBody
    public String doLogin(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        // mapper
        AdministratorBean administratorBean = administratorService.loginIn(name, password);
        Gson gson = new Gson();
        String string = gson.toJson(administratorBean);
        return string;
    }


    public String getRandomCode() {
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder code=new StringBuilder(5);
        for(int i=0;i<5;i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            code.append(ch);
        }
        return code.toString();
    }

}
