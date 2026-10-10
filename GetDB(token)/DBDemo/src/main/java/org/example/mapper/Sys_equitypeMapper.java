package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.Sys_equitype;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface Sys_equitypeMapper {
    /**Sys_equitype selectById(@Param("f_id") Integer f_id);

     Sys_equitype selectByUsername(@Param("f_name") String f_name);

     List<Sys_equitype> selectAll();*/
    Sys_equitype queryByName_eqt(@Param("Name_eqt") String Name_eqt);//
    List<Sys_equitype> selectAll();
    int deleteSys_equitype(@Param("Id") int id);//删除
    void deleteBatchByIds(@Param("ids") List<Integer> ids);
    int updateSys_equitype(Sys_equitype eqty);//修改
    List<Sys_equitype> queryAllSystype();//查询所有系统类型
    int addSys_equitype(Sys_equitype eqt);//增加
    Sys_equitype queryByid(@Param("Id") int id);//根据id查看详细信息
}
