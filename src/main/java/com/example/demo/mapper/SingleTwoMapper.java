package com.example.demo.mapper;

import com.example.demo.bean.SingleTwoBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SingleTwoMapper {

    @Select("select * from singletwo where sid = #{sid}")
    List<SingleTwoBean> findBySid(@Param("sid") String sid);

    @Update("update singletwo set sSum = sSum + 1 where st = #{st}")
    int updateBySt(@Param("st") String st);

    @Insert("insert into singletwo (sid, sissue, sSum) values (#{sid}, #{sissue}, 0)")
    Boolean insertBySid(@Param("sid") String sid, @Param("sissue") String sissue);

    @Delete("delete from singletwo where sid = #{sid}")
    Boolean deleteBySid(@Param("sid") String sid);
}
