package org.example.service.Impl;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Sys_program;
import org.example.mapper.Sys_programMapper;
import org.example.service.Spg_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Spg_ServiceImpl implements Spg_Service {
    //调用Sys_controllerMapper查询数据
    //@Resource或者@Autowired注解都可
    @Resource
    @Autowired
    private Sys_programMapper sys_prgMapper;

    @Override
    public List<Sys_program> selectAll() {
        List<Sys_program> sta = sys_prgMapper.selectAll();
        return sta;
    }
    @Override
    public List<Sys_program> selectAllEnginame() {
        List<Sys_program> spa = sys_prgMapper.selectAllEnginame();
        return spa;
    }
    @Override
    public List<Sys_program> queryByEnginame(@Param("Enginame") String Enginame) {
        return sys_prgMapper.queryByEnginame(Enginame);
    }

    @Override
    public List<Sys_program> queryByClient(@Param("Client") String Client) {
        return sys_prgMapper.queryByClient(Client);
    }
    @Override
    public int deleteSys_program(int id) {
        return sys_prgMapper.deleteSys_program(id);

    }
    @Override
    public List<Sys_program> queryAllClient() {
        List<Sys_program> sta = sys_prgMapper.queryAllClient();
        return sta;
    }
    @Override
    public int updateSys_program(Sys_program sysp) {
        return sys_prgMapper.updateSys_program(sysp);
    }

    @Override
    public int addSys_program(Sys_program spg) {
        return sys_prgMapper.addSys_program(spg);
    }

    @Override
    public Sys_program queryByid(int id) {
        return sys_prgMapper.queryByid(id);
    }
    @Override
    public void deleteBatch(List<Integer> ids) {
        sys_prgMapper.deleteBatchByIds(ids);
    }


}
