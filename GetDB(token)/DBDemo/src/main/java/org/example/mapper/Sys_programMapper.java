package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.Sys_controller;
import org.example.entity.Sys_program;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface Sys_programMapper {
    int deleteSys_program(int id);//删除

    int updateSys_program(Sys_program sysp);//修改

    int addSys_program(Sys_program spg);//增加控制器
    void deleteBatchByIds(@Param("ids") List<Integer> ids);
    Sys_program queryByid(@Param("id")int id);//根据id查看控制器详细信息

    List<Sys_program> queryAllClient();//通过隶属消防机构查项目名称
    List<Sys_program> queryByEnginame(@Param("Enginame") String Enginame);//通过项目名称查询项目代码（控制器编码）

    List<Sys_program> queryByClient(@Param("Client") String Client);//通过隶属消防机构查项目名称
    List<Sys_program> selectAllEnginame();

    List<Sys_program> selectAll();
}
