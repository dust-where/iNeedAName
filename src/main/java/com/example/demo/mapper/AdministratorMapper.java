package com.example.demo.mapper;

import com.example.demo.bean.AdministratorBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdministratorMapper {

    @Select("select * from administrator where aName = #{name} AND aPwd = #{password}")
    AdministratorBean getInfo(@Param("name") String name,@Param("password") String password);

}
