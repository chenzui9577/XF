package org.example.service;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Sys_controller;
import org.example.entity.Sys_equitype;
import org.example.entity.Sys_state;

import java.util.List;

public interface Sta_Service {
    Sys_state queryByStates(String States);
    List<Sys_state> selectAll();
    int deleteSys_state(int id);//删除
    void deleteBatch(List<Integer> ids);
    int updateSys_state(Sys_state stat);//修改

    int addSys_state(Sys_state sta);//增加
    Sys_state queryByid(@Param("id")int id);
}
