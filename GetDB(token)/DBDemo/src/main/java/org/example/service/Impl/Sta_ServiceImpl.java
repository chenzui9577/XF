package org.example.service.Impl;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Sys_state;
import org.example.mapper.Sys_stateMapper;
import org.example.service.Sta_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Sta_ServiceImpl implements Sta_Service {
    //调用Sys_controllerMapper查询数据
    //@Resource或者@Autowired注解都可
    @Resource
    @Autowired
    private Sys_stateMapper sys_staMapper;

    @Override
    public Sys_state queryByStates(String States) {
        return sys_staMapper.queryByStates(States);
    }

    @Override
    public List<Sys_state> selectAll() {
        List<Sys_state> sta = sys_staMapper.selectAll();
        return sta;
    }
    @Override
    public void deleteBatch(List<Integer> ids) {
        sys_staMapper.deleteBatchByIds(ids);
    }
    @Override
    public int deleteSys_state(int id) {
        return sys_staMapper.deleteSys_state(id);

    }

    @Override
    public int updateSys_state(Sys_state stat) {
        return sys_staMapper.updateSys_state(stat);
    }

    @Override
    public int addSys_state(Sys_state sta) {
        return sys_staMapper.addSys_state(sta);
    }

    @Override
    public Sys_state queryByid(@Param("id")int id) {
        return sys_staMapper.queryByid(id);
    }
/*
    @Override
    public List<*> selectAll() {
        List<*>  * = *Mapper.selectAll();
        return *s;
    }*/
}
