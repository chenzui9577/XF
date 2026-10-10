package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.Sys_state;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface Sys_stateMapper {
    /**
     * Sys_state selectById(@Param("id") Integer id);
     * <p>
     * Sys_state selectByname(@Param("name") String name);
     * <p>
     * List<Sys_state> selectAll();
     */
    Sys_state queryByStates(@Param("States") String States);//
    void deleteBatchByIds(@Param("ids") List<Integer> ids);
    List<Sys_state> selectAll();
    int deleteSys_state(@Param("id") int id);//删除

    int updateSys_state(Sys_state stat);//修改

    int addSys_state(Sys_state sta);//增加
    Sys_state queryByid(@Param("id")int id);
}
