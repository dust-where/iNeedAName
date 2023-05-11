package com.example.demo.mapper;

import com.example.demo.bean.AdministratorBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

    @Select("SELECT * FROM administrator WHERE aname = #{name} AND aPwd = #{password}")
    AdministratorBean getInfo(@Param("name") String name, @Param("password") String password);
}
