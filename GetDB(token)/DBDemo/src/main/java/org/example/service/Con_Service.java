package org.example.service;

import org.example.entity.Sys_controller;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Con_Service {

    int deleteSys_controller(int id);//删除

    int updateSys_controller(Sys_controller contro);//修改

    int addSys_controller(Sys_controller con);//增加控制器
    void deleteBatch(List<Integer> ids);
    Sys_controller queryByid(int id);//根据id查看控制器详细信息

    Sys_controller queryByCcode(String Ccode);//通过控制器返回码查询

    Sys_controller selectByEnginame(String Enginame);

    List<Sys_controller> selectAll();
    List<Sys_controller> selectEngicodeAndEnginame();

}
