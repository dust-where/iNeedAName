package com.example.demo.controller;

import com.example.demo.bean.MultipleOneBean;
import com.example.demo.bean.QuestionnaireBean;
import com.example.demo.bean.SingleOneBean;
import com.example.demo.service.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ManageController {

    @Autowired
    QuestionnaireService questionnaireService;

    @Autowired
    SingleOneService singleOneService;

    @Autowired
    SingleTwoService singleTwoService;

    @Autowired
    MultipleOneService multipleOneService;

    @Autowired
    MultipleTwoService multipleTwoService;

    @GetMapping("/manage")
    public String home() {
        return "manage";
    }

    @GetMapping("/onload")
    @ResponseBody
    public String onLoad(HttpServletRequest request) {
        String aId = request.getParameter("aid");
        List<QuestionnaireBean> list = questionnaireService.findByAId(aId);
        Gson gson = new Gson();
        String string = gson.toJson(list);
        System.out.println(string);
        return string;
    }

    @PostMapping("/deleteQuestionnaire")
    @ResponseBody
    public String deleteQuestionnaire(HttpServletRequest request) {
        // TODO:这里的删除有问题
        String qid = request.getParameter("qid");
        List<SingleOneBean> list1 = singleOneService.findByQid(qid);
        for (SingleOneBean singleOneBean: list1) {
            // sid
            Boolean bool = singleTwoService.deleteBySid(singleOneBean.getsId() + "");
            if (bool == false) return bool.toString();
            bool = singleOneService.deleteByQid(qid);
            if (bool == false) return bool.toString();
        }
        List<MultipleOneBean> list2 = multipleOneService.findByQid(qid);
        for (MultipleOneBean multipleOneBean: list2) {
            Boolean bool = multipleTwoService.deleteByMid(multipleOneBean.getmId() + "");
            if (bool == false) return bool.toString();
            bool = multipleOneService.deleteByQid(qid);
            if (bool == false) return bool.toString();
        }
        Boolean bool = questionnaireService.deleteQuestionnaire(qid);
        return bool.toString();
    }

    @PostMapping("/insertQuestionnaire")
    @ResponseBody
    public String insertQuestionnaires(HttpServletRequest request) {
        String aid = request.getParameter("aid");
        String qlasttime = request.getParameter("qlasttime");
        String qname = request.getParameter("qname");
        Boolean bool = questionnaireService.insertQuestionnaire(aid, qlasttime, qname);
        return bool.toString();
    }
}
