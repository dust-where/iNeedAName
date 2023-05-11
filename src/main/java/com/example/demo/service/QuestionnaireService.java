package com.example.demo.service;

import com.example.demo.bean.QuestionnaireBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionnaireService {

    List<QuestionnaireBean> send();

    List<QuestionnaireBean> findByAId(String aid);

    QuestionnaireBean findByQId(String qid);

    Boolean insertQuestionnaire(String aid, String qlasttime, String qname);

    Boolean deleteQuestionnaire(String qid);
}
