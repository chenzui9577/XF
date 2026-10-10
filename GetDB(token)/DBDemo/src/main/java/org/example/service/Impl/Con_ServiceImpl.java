package org.example.service.Impl;


import org.example.entity.Sys_controller;
import org.example.mapper.Sys_controllerMapper;
import org.example.service.Con_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

//@Primary
@Service
public class Con_ServiceImpl implements Con_Service {

    //调用Sys_controllerMapper查询数据
    //@Resource或者@Autowired注解都可
    @Resource
    @Autowired
    private Sys_controllerMapper sys_conMapper;
    @Override
    public Sys_controller queryByCcode(String Ccode) {
        return sys_conMapper.queryByCcode(Ccode);
    }

    @Override
    public Sys_controller selectByEnginame(String Enginame) {
        return sys_conMapper.selectByEnginame(Enginame);
    }

    @Override
    public List<Sys_controller> selectAll() {
        List<Sys_controller> con = sys_conMapper.selectAll();
        return con;
    }
    @Override
   public List<Sys_controller> selectEngicodeAndEnginame(){
        List<Sys_controller> con = sys_conMapper.selectEngicodeAndEnginame();
        return con;
    }
    @Override
    public Sys_controller queryByid(int id){
        return  sys_conMapper.queryByid(id);
    }
    @Override
    public  int deleteSys_controller(int id){
        return sys_conMapper.deleteSys_controller(id);

    }
    @Override
    public int updateSys_controller(Sys_controller sysContro) {
        return sys_conMapper.updateSys_controller(sysContro);
    }
    @Override
    public int addSys_controller(Sys_controller con) {
        return sys_conMapper.addSys_controller(con);
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        sys_conMapper.deleteBatchByIds(ids);
    }
}
