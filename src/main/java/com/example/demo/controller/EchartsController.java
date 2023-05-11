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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EchartsController {

    @Autowired
    SingleOneService singleOneService;

    @Autowired
    SingleTwoService singleTwoService;

    @Autowired
    MultipleOneService multipleOneService;

    @Autowired
    MultipleTwoService multipleTwoService;

    @GetMapping("/echarts")
    public String home() {
        return "echarts";
    }

    @GetMapping("/doSingleEcharts")
    @ResponseBody
    public String doSingleForm(HttpServletRequest request) {
        String qid = request.getParameter("qid");
        List<SingleOneBean> lists = singleOneService.findByQid(qid);
        Gson gson = new Gson();
        List<SingleBean> singleBeans = new ArrayList<>();
        for (SingleOneBean singleOneBean : lists) {
            List<SingleTwoBean> singleTwoBeans = singleTwoService.findBySid(Integer.toString(singleOneBean.getsId()));
            SingleBean singleBean = new SingleBean(singleOneBean.getsName(),singleOneBean.getsId() + "", singleTwoBeans);
            singleBeans.add(singleBean);
        }
        String string = gson.toJson(singleBeans);
        System.out.println(string);
        return string;
    }

    @GetMapping("/doMultipleEcharts")
    @ResponseBody
    public String doMultipleForm(HttpServletRequest request) {
        String qid = request.getParameter("qid");
        List<MultipleOneBean> lists= multipleOneService.findByQid(qid);
        Gson gson = new Gson();
        List<MultipleBean> multipleBeans = new ArrayList<>();
        for (MultipleOneBean multipleOneBean : lists) {
            List<MultipleTwoBean> multipleTwoBeans = multipleTwoService.findByMid(Integer.toString(multipleOneBean.getmId()));
            MultipleBean multipleBean = new MultipleBean(multipleOneBean.getmName(),multipleOneBean.getmId() + "", multipleTwoBeans);
            multipleBeans.add(multipleBean);
        }
        String string = gson.toJson(multipleBeans);
        System.out.println(string);
        return string;
    }
}
