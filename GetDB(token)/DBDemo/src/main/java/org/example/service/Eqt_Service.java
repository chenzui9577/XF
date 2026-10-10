package org.example.service;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Sys_equideti;
import org.example.entity.Sys_equitype;

import java.util.List;

public interface Eqt_Service {
    Sys_equitype queryByName_eqt(String Name_eqt);
    List<Sys_equitype> selectAll();
    int deleteSys_equitype(int id);//删除
    List<Sys_equitype> queryAllSystype();//查询所有系统类型
    int updateSys_equitype(Sys_equitype eqty);//修改
    void deleteBatch(List<Integer> ids);
    int addSys_equitype(Sys_equitype eqt);//增加
    Sys_equitype queryByid(int id);//根据id查看详细信息
}
