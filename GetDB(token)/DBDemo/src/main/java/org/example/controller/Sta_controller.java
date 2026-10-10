package org.example.controller;

import org.example.entity.*;
import org.example.service.Con_Service;
import org.example.service.Sta_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Sys_state")
public class Sta_controller {
        @Autowired
        private Sta_Service staService;

        @GetMapping("queryByStates")
        public Sys_state queryByStates(String States){
            return staService.queryByStates(States);
        }
        @GetMapping("selectAll")
        public List<Sys_state> selectAll(){
                List<Sys_state>  stas = staService.selectAll();
                return stas;
        }
        /**
         * 根据id查询信息
         */
        @GetMapping("queryByid/{id}")
        public Sys_state queryByid(@PathVariable("id")int id){
                return staService.queryByid(id);
        }
        /**
         * 增加功能
         */
        @RequestMapping(value = "add", method = RequestMethod.GET)
        public int addSys_state(Sys_state sta){
                return staService.addSys_state(sta);
        }

        /**
         * 编辑功能
         */

        @RequestMapping(value = "update", method = RequestMethod.GET)
        public String updateSys_state(Sys_state stat){
                int result = staService.updateSys_state(stat);
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
        public String deleteSys_state(int id){
                int result = staService.deleteSys_state(id);
                if(result >= 1){
                        return "删除成功！";
                }else{
                        return "删除失败！";
                }
        }
        /**
         * 批量删除
         */

        @RequestMapping(value = "/batch-delete", method = RequestMethod.DELETE,produces = "application/json;charset=UTF-8")
        public ResponseEntity<?> deleteBatch(@RequestBody List<Integer> ids) {
                staService.deleteBatch(ids);
                return ResponseEntity.ok("批量删除成功");
        }
}
