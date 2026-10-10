package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.Sys_controller;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Sys_controllerMapper {

    int deleteSys_controller(int id);//删除

    int updateSys_controller(Sys_controller contro);//修改
    void deleteBatchByIds(@Param("ids") List<Integer> ids);
    int addSys_controller(Sys_controller con);//增加控制器

    Sys_controller queryByid(@Param("id")int id);//根据id查看控制器详细信息
    Sys_controller selectByEnginame(String Enginame);//通过项目名称查询

    Sys_controller queryByCcode(String Ccode);//通过控制器返回码查询

    List<Sys_controller> selectAll();
    List<Sys_controller> selectEngicodeAndEnginame();

}
