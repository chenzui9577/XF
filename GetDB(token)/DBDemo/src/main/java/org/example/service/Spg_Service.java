package org.example.service;


import org.apache.ibatis.annotations.Param;
import org.example.entity.Sys_equitype;
import org.example.entity.Sys_program;

import java.util.List;

public interface Spg_Service {
    List<Sys_program> selectAll();
    int deleteSys_program(int id);//删除

    int updateSys_program(Sys_program sysp);//修改
    void deleteBatch(List<Integer> ids);
    int addSys_program(Sys_program spg);//增加
    Sys_program queryByid(int id);
    List<Sys_program> queryAllClient();
    List<Sys_program> queryByEnginame(@Param("Enginame") String Enginame);//通过项目名称查询项目代码（控制器编码）
    List<Sys_program> selectAllEnginame();//通过项目名称查询项目代码（控制器编码）
    List<Sys_program> queryByClient(@Param("Client") String Client);//通过隶属消防机构查项目名称
}
