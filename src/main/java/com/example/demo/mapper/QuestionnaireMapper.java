package com.example.demo.mapper;

import com.example.demo.bean.QuestionnaireBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionnaireMapper {

    @Select("select * from questionnaire")
    List<QuestionnaireBean> findAll();

    @Select("select * from questionnaire where aid = #{aid}")
    List<QuestionnaireBean> findByAId(@Param("aid") String aid);

    @Select("select * from questionnaire where qid = #{qid}")
    QuestionnaireBean findByQid(@Param("qid") String qid);

    @Insert("insert into questionnaire (aid, qlasttime, qname) values (#{aid}, #{qlasttime}, #{qname})")
    Boolean insertQuestionnaire(@Param("aid") String aid, @Param("qlasttime") String qlasttime, @Param("qname") String qname);

    @Delete("delete from questionnaire where qid = #{qid}")
    Boolean deleteQuestionnaire(@Param("qid") String qid);
}
