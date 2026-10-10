package org.example.service;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Sys_controller;
import org.example.entity.Sys_equistate;

import java.util.List;

public interface Eqs_Service {
    Sys_equistate queryTypecode(String Typecode, String Retstate);
    List<Sys_equistate> selectAll();
    int deleteSys_equistate( int id);//删除

    int updateSys_equistate(Sys_equistate eqste);//修改
    void deleteBatch(List<Integer> ids);
    int addSys_equistate(Sys_equistate eqs);//增加
    Sys_equistate queryByid(int id);
}
