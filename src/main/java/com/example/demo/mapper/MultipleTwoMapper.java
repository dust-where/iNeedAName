package com.example.demo.mapper;

import com.example.demo.bean.MultipleTwoBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MultipleTwoMapper {

    @Select("select * from multipletwo where mid = #{mid}")
    List<MultipleTwoBean> findByMid(@Param("mid") String mid);

    @Update("update multipletwo set mSum = mSum + 1 where mt = #{mt}")
    int updateByMt(@Param("mt") String mt);

    @Insert("insert into multipletwo (mid, missue, mSum) values (#{mid}, #{missue}, 0)")
    Boolean insertByMid(@Param("mid") String mid,@Param("missue") String missue);

    @Delete("delete from multipletwo where mid = #{mid}")
    Boolean deleteByMid(@Param("mid") String mid);
}
