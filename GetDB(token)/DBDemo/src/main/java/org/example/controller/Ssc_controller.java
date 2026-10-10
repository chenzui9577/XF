package org.example.controller;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Sys_equideti;
import org.example.entity.Sys_equitype;
import org.example.entity.Sys_program;
import org.example.service.Eqd_Service;
import org.example.service.Ssc_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/Search")
public class Ssc_controller {
    @Autowired
    private Ssc_Service sscService;
    @GetMapping("/queryAllSystype/")//通过项目代码（控制器编码）查询该项目包含的所有设备类型
    public List<Sys_equideti> queryAllSystype(){
        List<Sys_equideti> qas = sscService.queryAllSystype();
        return qas;
    }
    @GetMapping("/queryAll/")//通过项目代码（控制器编码）查询该项目包含的所有设备类型
    public List<Sys_equideti> queryAll(){
        List<Sys_equideti> qas = sscService.queryAll();
        return qas;
    }
    @GetMapping("/queryAllName_eqt/")//通过筛选查看该项目中某个系统类型包含的所有部件类型
    public List<Sys_equideti> queryAllName_eqt(@Param("Systype") String Systype){
        return  sscService.queryAllName_eqt(Systype);
    }
    @GetMapping("/queryAllBySystype/")//查看该项目中某个系统类型中的部件信息
    public  List<Sys_equideti> queryAllBySystype(String Systype) {
        return sscService.queryAllBySystype(Systype);
    }
    @GetMapping("/queryAllByName_eqt/")//查看该项目中某个部件类型中的部件信息
    public List<Sys_equideti> queryAllByName_eqt(String Name_eqt) {
        return sscService.queryAllByName_eqt(Name_eqt);
    }
    @GetMapping("/queryBySelection/")//查看该项目中某个部件类型中的部件信息
    public List<Sys_equideti> queryBySelection(String Systype,String Name_eqt){
        return sscService.queryBySelection(Systype,Name_eqt);
    }

}
