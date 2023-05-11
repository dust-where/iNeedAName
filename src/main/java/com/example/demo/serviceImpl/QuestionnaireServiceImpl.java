package com.example.demo.serviceImpl;


import com.example.demo.bean.QuestionnaireBean;
import com.example.demo.mapper.QuestionnaireMapper;
import com.example.demo.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    @Override
    public List<QuestionnaireBean> send() {
        return questionnaireMapper.findAll();
    }

    @Override
    public List<QuestionnaireBean> findByAId(String aid) {
        return questionnaireMapper.findByAId(aid);
    }

    @Override
    public QuestionnaireBean findByQId(String qid) {
        return questionnaireMapper.findByQid(qid);
    }

    @Override
    public Boolean insertQuestionnaire(String aid, String qlasttime, String qname) {
        return questionnaireMapper.insertQuestionnaire(aid, qlasttime, qname);
    }

    @Override
    public Boolean deleteQuestionnaire(String qid) {
        return questionnaireMapper.deleteQuestionnaire(qid);
    }
}
