package org.example.service.Impl;


import org.apache.ibatis.annotations.Param;
import org.example.entity.Sys_equideti;
import org.example.entity.Sys_equistate;
import org.example.entity.Sys_equitype;
import org.example.entity.Sys_program;
import org.example.mapper.Sys_searchMapper;
import org.example.service.Ssc_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Ssc_ServiceImpl implements Ssc_Service {
    @Resource
    @Autowired
    private Sys_searchMapper sys_sscMapper;


   /* @Override
    public List<Sys_equideti> queryAllByTypecode_bak(String Typecode_bak) {
        return sys_sscMapper.queryAllByTypecode_bak(Typecode_bak);
    }

    @Override
    public List<Sys_equideti> queryByTypecode_bak(String Typecode_bak) {
        return sys_sscMapper.queryByTypecode_bak(Typecode_bak);
    }

    @Override
    public List<Sys_equideti> queryByName(String Name) {
        return   sys_sscMapper.queryByName(Name);
    }*/
   @Override//查询该项目包含的所有系统类型
   public List<Sys_equideti> queryAllSystype() {
       List<Sys_equideti> qas = sys_sscMapper.queryAllSystype();
       return qas;
   }
    @Override//查询该项目包含的所有系统类型
    public List<Sys_equideti> queryAll() {
        List<Sys_equideti> qas = sys_sscMapper.queryAll();
        return qas;
    }
    @Override//通过筛选查看该项目中某个系统类型包含的所有部件类型
    public List<Sys_equideti> queryAllName_eqt( String Systype){
        return sys_sscMapper.queryAllName_eqt(Systype);
    }
    @Override//查看该项目中某个系统类型中的部件信息
    public List<Sys_equideti> queryAllBySystype(String Systype){
        return sys_sscMapper.queryAllBySystype(Systype);
    }
    @Override//查看该项目中某个部件类型中的部件信息
    public List<Sys_equideti> queryAllByName_eqt(String Name_eqt){
        return sys_sscMapper.queryAllByName_eqt(Name_eqt);
    }
    @Override
    public  List<Sys_equideti> queryBySelection(String Systype,String Name_eqt){
        return sys_sscMapper.queryBySelection(Systype,Name_eqt);
    }
}
