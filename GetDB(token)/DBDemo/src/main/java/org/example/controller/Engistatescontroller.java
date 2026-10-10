package org.example.controller;


import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.example.entity.Engistates;
import org.example.service.Eng_Service;
import org.example.util.Engistates_Excel_export;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/Engistates")
public class Engistatescontroller {

    @Autowired
    private Eng_Service engService;

    @GetMapping("selectAll")
    public List<Engistates> selectAll() {
        List<Engistates> engs = engService.selectAll();
        return engs;
    }
    /**
     * 批量删除
     */

    @RequestMapping(value = "/batch-delete", method = RequestMethod.DELETE,produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> deleteBatch(@RequestBody List<Integer> ids) {
        engService.deleteBatch(ids);
        return ResponseEntity.ok("批量删除成功");
    }
    //查询自定义条数，时间倒序
    @GetMapping("selectcountAll")
    public List<Engistates> selectcountAll(Integer count) {
        List<Engistates> engs = engService.selectcountAll(count);
        return engs;
    }
    @GetMapping("selectByUsercode")
    public List<Engistates> selectByUsercode(String Usercode) {
        return engService.selectByUsercode(Usercode);
    }

    @GetMapping("selectByUsercodeAndCount")
    public List<Engistates> selectByUsercodeAndCount(@RequestParam("Usercode") String Usercode, @RequestParam("count") Integer count) {
        return engService.selectByUsercodeAndCount(Usercode, count);
    }
    @GetMapping("/searchBycountOrUsercode")
    public List<Engistates> searchEngistates(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) Integer count) {
        return engService.findByUserCodeWithLimit(code, count);
    }
    @GetMapping("/export")
    public void exportByEngicode(@RequestParam String engicode, HttpServletResponse response) {
        try {
            List<Engistates> engista = engService.selectByEngicode(engicode);
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("消防信息表", "UTF-8") + ".xlsx");
            Engistates_Excel_export.exportToExcel(engista, response);
        } catch (IOException e) {
            // 处理异常，可能是文件生成或写入时的错误
            e.printStackTrace();
            // 可以根据需要进行更详细的异常处理或返回特定的HTTP状态码
        }
    }


}
