package com.example.demo.mapper;

import com.example.demo.bean.SingleOneBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SingleOneMapper {

    @Select("select * from singleone where qid = #{qid}")
    List<SingleOneBean> findByqId(@Param("qid") String qid);

    @Insert("insert into singleone (qid, sname) values (#{qid}, #{sname})")
    Boolean insertByqid(@Param("qid") String qid, @Param("sname") String sname);

    @Delete("delete from singleone where qid = #{qid}")
    Boolean deleteByQid(@Param("qid") String qid);
}
