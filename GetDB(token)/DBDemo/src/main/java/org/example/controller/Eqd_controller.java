package org.example.controller;

import org.example.entity.PartComparisonResult;
import org.example.entity.Sys_equideti;
import org.example.service.Eqd_Service;
import org.example.util.ExcelExporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/Equideti")
public class Eqd_controller {
    private static final Logger LOGGER = LoggerFactory.getLogger(Eqd_controller.class);
    @Autowired
    private Eqd_Service eqdService;
    @Autowired
    public void Eqd_Controller(Eqd_Service eqdService) {
        this.eqdService = eqdService;
    }

    @GetMapping("/selectByEngicode")
    public List<Sys_equideti> selectByEngicode(String Engicode) {
        return eqdService.selectByEngicode(Engicode);
    }

    @GetMapping("/selectAll")
    public List<Sys_equideti> selectAll() {
        List<Sys_equideti> eqds = eqdService.selectAll();
        return eqds;
    }

    /**
     * 根据id查询详细信息@PathVariable("id")
     */
    @RequestMapping(value = "/queryByid/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Sys_equideti> queryByid(int id) {
        return eqdService.queryByid(id);
    }

    /**
     * 增加功能
     */
    @ResponseBody
    @RequestMapping(value = "add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public int addSys_equideti(Sys_equideti eqd) {
        return eqdService.addSys_equideti(eqd);
    }

    /**
     * 编辑功能
     */

    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String updateSys_equideti(Sys_equideti eqdti) {
        int result = eqdService.updateSys_equideti(eqdti);
        if (result >= 1) {
            return "更新成功！";
        } else {
            return "更新失败！";
        }
    }

    /**
     * 清空
     */
    @RequestMapping(value = "/deleteAll/{Engicode}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> deleteDataByEngicode(@PathVariable String Engicode) {
        eqdService.deleteByEngicode(Engicode);
        return ResponseEntity.ok("清空成功");
    }


    /**
     * 删除
     */
    @GetMapping(value = "delete")
    public String deleteSys_equistate(int id) {
        int result = eqdService.deleteSys_equideti(id);
        if (result >= 1) {
            return "删除成功！";
        } else {
            return "删除失败！";
        }
    }

    /**
     * 批量删除
     */

    @RequestMapping(value = "/batch-delete", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> deleteBatch(@RequestBody List<Integer> ids) {
        eqdService.deleteBatch(ids);
        return ResponseEntity.ok("批量删除成功");
    }

    /**
     * 导出
     */

    @RequestMapping(value = "/export", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public void exportByEngicode(@RequestParam String engicode, HttpServletResponse response) {
        try {
            List<Sys_equideti> syseqdeti = eqdService.selectByEngicode(engicode);
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("部件明细表", "UTF-8") + ".xlsx");
            ExcelExporter.exportToExcel(syseqdeti, response);
            System.out.println(syseqdeti);
        } catch (IOException e) {
            // 处理异常，可能是文件生成或写入时的错误
            e.printStackTrace();
            // 可以根据需要进行更详细的异常处理或返回特定的HTTP状态码
        }
    }

    /**
     * 导入
     *
     * @param file 传入的excel文件对象
     * @return 导入结果
     */
    @RequestMapping(value = "/import", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> importExcel(@RequestParam("file") MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            eqdService.processExcelFile(inputStream);
            return ResponseEntity.ok("文件导入成功");
        } catch (IOException e) {
            // 日志记录异常
            // LOGGER.error("Error processing file", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("文件导入失败");
        }
    }

    /**
     * 对比
     */

    @PostMapping("/compareParts")
    public String compareUsercodes(@RequestBody MultiValueMap<String, String> requestMap) {
        System.out.println("前端发送来的初始点位数据:"+requestMap);
        String engicode = "37XF210000154"; // 固定参数
        List<String> count = eqdService.getUsercodeByEngicode(engicode); // 从数据库中获取count数组
        System.out.println("编码表中数据:" + count);
        System.out.println("编码表点位总数：" + count.size());
        List<String> parts = extractParts(requestMap);
        System.out.println("提取后的前端点位数据:" + parts);
        System.out.println("模型中点位总数：" + parts.size());
        Collections.sort(parts);
        Collections.sort(count);
        return compareArrays(parts, count);
    }

    private String compareArrays(List<String> list1, List<String> list2) {
        // 找出两个数组中都存在的元素
        List<String> intersection = new ArrayList<>(list1);
        intersection.retainAll(list2);
        System.out.println(intersection);
        // 找出 list1 中存在但 list2 中不存在的元素
        List<String> onlyInList1 = new ArrayList<>(list1);
        onlyInList1.removeAll(intersection);

        // 找出 list2 中存在但 list1 中不存在的元素
        List<String> onlyInList2 = new ArrayList<>(list2);
        onlyInList2.removeAll(intersection);
        // 创建并保存比较结果
        PartComparisonResult result = new PartComparisonResult();
        result.setModelPointCount(list1.size());
        result.setDatabasePointCount(list2.size());
        result.setOnlyModelPoints(onlyInList1.toString());
        result.setOnlyDatabasePoints(onlyInList2.toString());
        eqdService.savePartComparisonResult(result);

        // 输出差异
        if (onlyInList1.isEmpty() && onlyInList2.isEmpty()) {
            return "success";
        } else {
            System.out.println("差异如下：" + "\n"
                    + "仅存在于前端点位中的元素：" + "\n"
                    + onlyInList1 + "\n"
                    + "仅存在于编码表中的元素：" + "\n"
                    + onlyInList2);
            return "差异如下：" + "\n"
                    + "模型中点位总数：" + "\n"
                    + list1.size() + "\n"
                    + "编码表点位总数：" + "\n"
                    + list2.size() + "\n"
                    + "仅存在于前端点位中的元素：" + "\n"
                    + onlyInList1 + "\n"
                    + "仅存在于编码表中的元素：" + "\n"
                    + onlyInList2;

        }
    }

    private List<String> extractParts(MultiValueMap<String, String> requestMap) {
        List<String> parts = requestMap.getOrDefault("Parts", new ArrayList<>());
        List<String> extractedParts = new ArrayList<>();
        // 如果Parts数组不为空且包含嵌套数组
        if (!parts.isEmpty() && parts.get(0).startsWith("[")) {
            // 解析嵌套数组并添加到提取后的列表中
            String nestedArrayString = parts.get(0).replaceAll("\\[|\\]", "");
            String[] nestedArray = nestedArrayString.split(",");
            for (String part : nestedArray) {
                extractedParts.add(part.replaceAll("\"", ""));
            }
        } else {
            // 如果Parts数组不包含嵌套数组，直接解析
            for (String part : parts) {
                extractedParts.add(part.replaceAll("\"", ""));
            }
        }
        return extractedParts;
    }
/*
    @GetMapping("/getLatestComparisonResult")
    public List<Sys_equideti> getLatestComparisonResult() {
        List<PartComparisonResult> getlc = eqdService.getLatestComparisonResult();
        return getlc;
    }
*/

}
