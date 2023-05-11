package com.example.demo.controller;

import com.example.demo.bean.QuestionnaireBean;
import com.example.demo.service.QuestionnaireService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    QuestionnaireService questionnaireService;

    @GetMapping("/user")
    public String home() {
        return "user";
    }

    @PostMapping("/do")
    @ResponseBody
    public String login(HttpServletRequest request) {
        String qid = request.getParameter("qid");
        QuestionnaireBean questionnaireBean = questionnaireService.findByQId(qid);
        Gson gson = new Gson();
        String string = gson.toJson(questionnaireBean);
        System.out.println(string);
        return string;
    }
}
