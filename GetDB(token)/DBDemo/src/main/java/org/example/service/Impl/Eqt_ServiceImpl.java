package org.example.service.Impl;

import org.example.entity.Sys_equitype;
import org.example.mapper.Sys_equitypeMapper;
import org.example.service.Eqt_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Eqt_ServiceImpl implements Eqt_Service {
    //调用Sys_controllerMapper查询数据
    //@Resource或者@Autowired注解都可
    @Resource
    @Autowired
    private Sys_equitypeMapper sys_eqtMapper;
    @Override
    public Sys_equitype queryByName_eqt(String Name_eqt) {
        return sys_eqtMapper.queryByName_eqt(Name_eqt);
    }
    @Override
    public List<Sys_equitype> selectAll() {
        List<Sys_equitype>  eqt = sys_eqtMapper.selectAll();
        return eqt;
    }
    @Override//查询所有系统类型
    public List<Sys_equitype> queryAllSystype() {
        List<Sys_equitype> eqt = sys_eqtMapper.queryAllSystype();
        return eqt;
    }
    @Override
    public Sys_equitype queryByid(int id){
        return  sys_eqtMapper.queryByid(id);
    }
    @Override
    public  int deleteSys_equitype(int id){
        return sys_eqtMapper.deleteSys_equitype(id);
    }
    @Override
    public int updateSys_equitype(Sys_equitype eqty) {
        return sys_eqtMapper.updateSys_equitype(eqty);
    }
    @Override
    public int addSys_equitype(Sys_equitype eqt) {
        return sys_eqtMapper.addSys_equitype(eqt);
    }
    @Override
    public void deleteBatch(List<Integer> ids) {
        sys_eqtMapper.deleteBatchByIds(ids);
    }
}
