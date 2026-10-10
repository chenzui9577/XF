package org.example.controller;

import org.example.common.Result;
import org.example.entity.Sys_equitype;
import org.example.service.Eqt_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Equitype")
public class Eqt_controller {
        @Autowired
        private Eqt_Service eqtService;

        @GetMapping("queryByName_eqt")
        public Sys_equitype queryByName_eqt(String Name_eqt){
                return eqtService.queryByName_eqt(Name_eqt);
        }
        @GetMapping("selectAll")
        public List<Sys_equitype> selectAll(){
                List<Sys_equitype>  eqts = eqtService.selectAll();
                return eqts;
        }
        /**
         *查询所有系统类型
         */
        @GetMapping("/queryAllSystype/")
        public List<Sys_equitype> queryAllSystype() {
                List<Sys_equitype> eqt = eqtService.queryAllSystype();
                return eqt;
        }
        /**
         * 根据id查询信息
         */
        @GetMapping("queryByid/{id}")
        public Sys_equitype queryByid(@PathVariable("Id") int id){
                return eqtService.queryByid(id);
        }
        /**
         * 增加功能
         */
        @RequestMapping(value = "add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
        public int addSys_equistate(Sys_equitype eqt){
                return eqtService.addSys_equitype(eqt);
        }

        /**
         * 编辑功能
         */
        @ResponseBody
        @RequestMapping(value = "update", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
        public Result updateSys_equitype(Sys_equitype eqty){
                int result = eqtService.updateSys_equitype(eqty);
                if(result >= 1){
                        return Result.succeed("更新成功！");
                }else{
                        return Result.error("更新失败！");
                }
        }

        /**
         * 删除
         */
        @RequestMapping(value = "delete", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
        public String deleteSys_equitype(int id){
                int result = eqtService.deleteSys_equitype(id);
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
                eqtService.deleteBatch(ids);
                return ResponseEntity.ok("批量删除成功");
        }
}
