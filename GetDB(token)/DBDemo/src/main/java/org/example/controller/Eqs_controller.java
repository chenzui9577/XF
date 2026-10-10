package org.example.controller;

import org.example.entity.Sys_controller;
import org.example.entity.Sys_equideti;
import org.example.entity.Sys_equistate;
import org.example.service.Con_Service;
import org.example.service.Eqd_Service;
import org.example.service.Eqs_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Equistate")
public class Eqs_controller {
        @Autowired
        private Eqs_Service eqsService;

        @GetMapping("queryByTypecode")
        public Sys_equistate queryTypecode(String Typecode, String Retstate){
                return eqsService.queryTypecode(Typecode,Retstate);
        }
        @GetMapping("selectAll")
        public List<Sys_equistate> selectAll(){
                List<Sys_equistate>  eqss = eqsService.selectAll();
                return eqss;
        }
        /**
         * 根据id查询信息
         */
        @GetMapping("queryByid/{id}")
        public Sys_equistate queryByid(@PathVariable("id") int id){
                return eqsService.queryByid(id);
        }
        /**
         * 增加功能
         */
        @RequestMapping(value = "add", method = RequestMethod.GET)
        public int addSys_equistate(Sys_equistate eqs){
                return eqsService.addSys_equistate(eqs);
        }

        /**
         * 编辑功能
         */

        @RequestMapping(value = "update", method = RequestMethod.GET)
        public String updateSys_equistate(Sys_equistate eqste){
                int result = eqsService.updateSys_equistate(eqste);
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
        public String deleteSys_equistate(int id){
                int result = eqsService.deleteSys_equistate(id);
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
                eqsService.deleteBatch(ids);
                return ResponseEntity.ok("批量删除成功");
        }
}
