package org.example.service;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Sys_equideti;
import org.example.entity.Sys_equitype;

import java.util.List;

public interface Ssc_Service {


   /* List<Sys_equideti> queryAllByTypecode_bak(String Typecode_bak);//通过筛选的设备类型查询信息
    List<Sys_equideti> queryByTypecode_bak(String Typecode_bak);//通过筛选的设备类型查询设备名称
    List<Sys_equideti> queryByName(String Name);//通过筛选的设备名称查询信息*/
    List<Sys_equideti> queryAllSystype();//查询该项目包含的所有系统类型
    List<Sys_equideti> queryAll();//查询该项目包含的所有系统类型
    List<Sys_equideti> queryAllName_eqt(@Param("Systype") String Systype);//通过筛选查看该项目中某个系统类型包含的所有部件类型
    List<Sys_equideti> queryAllBySystype(String Systype);//查看该项目中某个系统类型中的部件信息
    List<Sys_equideti> queryAllByName_eqt(String Name_eqt);//查看该项目中某个部件类型中的部件信息
    List<Sys_equideti> queryBySelection(String Systype,String Name_eqt);
}
