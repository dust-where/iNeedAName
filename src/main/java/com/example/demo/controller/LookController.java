package com.example.demo.controller;

import com.example.demo.bean.*;
import com.example.demo.service.MultipleOneService;
import com.example.demo.service.MultipleTwoService;
import com.example.demo.service.SingleOneService;
import com.example.demo.service.SingleTwoService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LookController {

    @Autowired
    SingleOneService singleOneService;

    @Autowired
    SingleTwoService singleTwoService;

    @Autowired
    MultipleOneService multipleOneService;

    @Autowired
    MultipleTwoService multipleTwoService;

    @GetMapping("/look")
    public String home() {
        return "look";
    }

    @GetMapping("/doSingles")
    @ResponseBody
    public String doSingleForm(HttpServletRequest request) {
        String qid = request.getParameter("qid");
//        System.out.println(qid);
        List<SingleOneBean> lists = singleOneService.findByQid(qid);
//        System.out.println(lists);
        Gson gson = new Gson();
        List<SingleBean> singleBeans = new ArrayList<>();
        for (SingleOneBean singleOneBean : lists) {
            List<SingleTwoBean> singleTwoBeans = singleTwoService.findBySid(Integer.toString(singleOneBean.getsId()));
            SingleBean singleBean = new SingleBean(singleOneBean.getsName(), singleOneBean.getsId() + "", singleTwoBeans);
            singleBeans.add(singleBean);
        }
        String string = gson.toJson(singleBeans);
        System.out.println(string);
        return string;
    }

    @GetMapping("/doMultiples")
    @ResponseBody
    public String doMultipleForm(HttpServletRequest request) {
        String qid = request.getParameter("qid");
        System.out.println(qid);
        List<MultipleOneBean> lists= multipleOneService.findByQid(qid);
        Gson gson = new Gson();
        List<MultipleBean> multipleBeans = new ArrayList<>();
        for (MultipleOneBean multipleOneBean : lists) {
            List<MultipleTwoBean> multipleTwoBeans = multipleTwoService.findByMid(Integer.toString(multipleOneBean.getmId()));
            MultipleBean multipleBean = new MultipleBean(multipleOneBean.getmName(), multipleOneBean.getmId() + "", multipleTwoBeans);
            multipleBeans.add(multipleBean);
        }
        String string = gson.toJson(multipleBeans);
        System.out.println(string);
        return string;
    }

    @PostMapping("/insertSingleOne")
    @ResponseBody
    public String doInsertByqid(HttpServletRequest request) {
        String qid = request.getParameter("qid");
        System.out.println(qid);
        String sname = request.getParameter("sname");
        System.out.println(sname);
        Boolean bool = singleOneService.insertByqid(qid, sname);
        return bool.toString();
    }

    @PostMapping("/insertMultipleOne")
    @ResponseBody
    public String doInsertMultipleByqid(HttpServletRequest request) {
        String qid = request.getParameter("qid");
        System.out.println(qid);
        String mname = request.getParameter("mname");
        System.out.println(mname);
        Boolean bool = multipleOneService.insertByQid(qid, mname);
        return bool.toString();
    }

    @PostMapping("/insertSingleTwo")
    @ResponseBody
    public String doInsertSingleTwo(HttpServletRequest request) {
        String sid = request.getParameter("sid");
        System.out.println(sid);
        String sname = request.getParameter("sname");
        System.out.println(sname);
        Boolean bool = singleTwoService.insertBySid(sid, sname);
        return bool.toString();
        // TODO: 没测试
    }

    @PostMapping("/insertMultipleTwo")
    @ResponseBody
    public String doInsertMultiple(HttpServletRequest request) {
        String mid = request.getParameter("mid");
        System.out.println(mid);
        String mname = request.getParameter("mname");
        System.out.println(mname);
        Boolean bool = multipleTwoService.insertByMid(mid, mname);
        return bool.toString();
        // TODO: 没测试
    }
}
