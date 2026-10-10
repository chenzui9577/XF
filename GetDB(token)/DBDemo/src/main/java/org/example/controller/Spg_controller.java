package org.example.controller;

import org.apache.ibatis.annotations.Param;
import org.example.entity.Sys_program;
import org.example.service.Spg_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Sys_program")
public class Spg_controller {

    @Autowired
    private Spg_Service spgService;

    @GetMapping("selectAll")
    public List<Sys_program> selectAll() {
        List<Sys_program> sysp = spgService.selectAll();
        return sysp;
    }
    @GetMapping("selectAllEnginame")
    public List<Sys_program> selectAllEnginame() {
        List<Sys_program> sysp = spgService.selectAllEnginame();
        return sysp;
    }

    @GetMapping("queryAllClient")
    public List<Sys_program> queryAllClient() {
        List<Sys_program> sysp = spgService.queryAllClient();
        return sysp;
    }

    @GetMapping("/queryByEnginame")
    public List<Sys_program> queryByEnginame(@Param("Enginame") String Enginame) {
        return spgService.queryByEnginame(Enginame);
    }

    @GetMapping("/queryByClient")
    public List<Sys_program> queryByClient(@Param("Client") String Client) {
        return spgService.queryByClient(Client);
    }

    /**
     * 根据id查询信息
     */
    @GetMapping("queryByid/{id}")
    public Sys_program queryByid(@PathVariable("id") int id) {
        return spgService.queryByid(id);
    }

    /**
     * 增加功能
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public int addSys_program(Sys_program spg) {
        return spgService.addSys_program(spg);
    }

    /**
     * 编辑功能
     */

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String updateSys_program(Sys_program sysp) {
        int result = spgService.updateSys_program(sysp);
        if (result >= 1) {
            return "更新成功！";
        } else {
            return "更新失败！";
        }
    }

    /**
     * 删除
     */
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteSys_program(int id) {
        int result = spgService.deleteSys_program(id);
        if (result >= 1) {
            return "删除成功！";
        } else {
            return "删除失败！";
        }
    }
    /**
     * 批量删除
     */

    @RequestMapping(value = "/batch-delete", method = RequestMethod.DELETE,produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> deleteBatch(@RequestBody List<Integer> ids) {
        spgService.deleteBatch(ids);
        return ResponseEntity.ok("批量删除成功");
    }

}
