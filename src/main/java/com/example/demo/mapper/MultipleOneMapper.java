package com.example.demo.mapper;

import com.example.demo.bean.MultipleOneBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MultipleOneMapper {

    @Select("select * from multipleone where qid = #{qid}")
    List<MultipleOneBean> findByqId(@Param("qid") String qid);

    @Insert("insert into multipleone (qid, mname) values (#{qid}, #{mname})")
    Boolean insertByQid(@Param("qid") String qid, @Param("mname") String mname);

    @Delete("delete from multipleone where qid = #{qid}")
    Boolean deleteByQid(@Param("qid") String qid);
}
