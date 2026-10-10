package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.Sys_equistate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface Sys_equistateMapper {
    /**Sys_equistate selectById(@Param("f_id") Integer f_id);

     Sys_equistate selectByUsername(@Param("f_name") String f_name);

     List<Sys_equistate> selectAll();*/
    Sys_equistate queryTypecode(@Param("Typecode") String Typecode,@Param("Retstate")String Retstate);//
    void deleteBatchByIds(@Param("ids") List<Integer> ids);
    List<Sys_equistate> selectAll();
    int deleteSys_equistate(@Param("id") int id);//删除

    int updateSys_equistate(Sys_equistate eqste);//修改

    int addSys_equistate(Sys_equistate eqs);//增加
    Sys_equistate queryByid(@Param("id") int id);

}
