package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.Sys_controller;
import org.example.entity.Sys_equideti;
import org.example.entity.Sys_equitype;
import org.example.entity.Sys_program;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Sys_searchMapper {

    List<Sys_equideti> queryAllName_eqt(@Param("Systype") String Systype);//通过筛选查看该项目中某个系统类型包含的所有部件类型

    List<Sys_equideti> queryAllSystype();//查询该项目包含的所有系统类型
    List<Sys_equideti> queryAll();//查询该项目包含的所有系统类型

    List<Sys_equideti> queryAllBySystype(String Systype);//查看该项目中某个系统类型中的部件信息
    List<Sys_equideti> queryAllByName_eqt(@Param("Name_eqt") String Name_eqt);//查看该项目中某个部件类型中的部件信息
    List<Sys_equideti> queryBySelection(@Param("Systype") String Systype,@Param("Name_eqt") String Name_eqt);

}
