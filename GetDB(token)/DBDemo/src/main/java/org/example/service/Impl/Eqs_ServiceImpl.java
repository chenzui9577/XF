package org.example.service.Impl;

import org.example.entity.Sys_equistate;
import org.example.mapper.Sys_equistateMapper;
import org.example.service.Eqs_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Eqs_ServiceImpl implements Eqs_Service {
    //调用Sys_controllerMapper查询数据
    //@Resource或者@Autowired注解都可
    @Resource
    @Autowired
    private Sys_equistateMapper sys_eqsMapper;

    @Override
    public Sys_equistate queryTypecode(String Typecode, String Retstate) {
        return sys_eqsMapper.queryTypecode(Typecode, Retstate);
    }

    @Override
    public List<Sys_equistate> selectAll() {
        List<Sys_equistate> eqs = sys_eqsMapper.selectAll();
        return eqs;
    }
    @Override
    public Sys_equistate queryByid(int id){
        return  sys_eqsMapper.queryByid(id);
    }
    @Override
    public  int deleteSys_equistate(int id){
        return sys_eqsMapper.deleteSys_equistate(id);

    }
    @Override
    public int updateSys_equistate(Sys_equistate eqste) {
        return sys_eqsMapper.updateSys_equistate(eqste);
    }
    @Override
    public int addSys_equistate(Sys_equistate eqs) {
        return sys_eqsMapper.addSys_equistate(eqs);
    }
    @Override
    public void deleteBatch(List<Integer> ids) {
        sys_eqsMapper.deleteBatchByIds(ids);
    }
}
