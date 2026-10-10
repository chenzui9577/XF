package org.example.controller;

import org.example.entity.Sys_controller;
import org.example.service.Con_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Controller")
public class Con_controller {
    @Autowired
    private Con_Service conService;
    //根据控制器返回码查询信息
    @GetMapping("queryByCcode")
    public Sys_controller queryByCcode(String Ccode) {
        return conService.queryByCcode(Ccode);
    }
    //根据项目名称查询信息
    @GetMapping("selectByEnginame")
    public Sys_controller selectByEnginame(String Enginame) {
        return conService.selectByEnginame(Enginame);
    }
    //查询所有
    @GetMapping("selectAll")
    public List<Sys_controller> selectAll() {
        List<Sys_controller> cons = conService.selectAll();
        return cons;
    }
    @GetMapping("selectEngicodeAndEnginame")
    public List<Sys_controller> selectEngicodeAndEnginame(){
        List<Sys_controller> cons = conService.selectEngicodeAndEnginame();
        return cons;
    }

    /**
    * 根据id查询信息
    */
    @GetMapping("/queryByid/{id}")
    public Sys_controller queryByid(@PathVariable("id")int id){
        return conService.queryByid(id);
    }
    /**
     * 批量删除
     */

    @RequestMapping(value = "/batch-delete", method = RequestMethod.DELETE,produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> deleteBatch(@RequestBody List<Integer> ids) {
        conService.deleteBatch(ids);
        return ResponseEntity.ok("批量删除成功");
    }
    /**
     * 增加功能
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public int addSys_controller(Sys_controller con){
        return conService.addSys_controller(con);
    }

    /**
     * 编辑功能
     */

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String updateSys_controller(Sys_controller contro){
        int result = conService.updateSys_controller(contro);
        if(result >= 1){
            return "更新成功！";
        }else{
            return "更新失败！";
        }
    }
    /**
     * 删除
     */
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteSys_controller(int id){
       int result = conService.deleteSys_controller(id);
        if(result >= 1){
            return "删除成功！";
        }else{
            return "删除失败！";
        }
    }

}
