package org.example.util;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.entity.Engistates;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Engistates_Excel_export {

    public static void exportToExcel(List<Engistates> dataList, HttpServletResponse response) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet("Engistates Data");

            // 创建头部行
            Row headerRow = sheet.createRow(0);
            String[] headers = {"序号", "工程名称", "控制器编码", "控制器名称", "部件名称", "部件注释", "状态描述", "用户编码", "回路", "地址码", "入库时间"};
            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

            // 填充数据行
            int rowNum = 1;
            for (Engistates item : dataList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(item.getId());
                row.createCell(1).setCellValue(item.getUnitname());
                row.createCell(2).setCellValue(item.getEngicode());
                row.createCell(3).setCellValue(item.getEnginame());
                row.createCell(4).setCellValue(item.getEquiname());
                row.createCell(5).setCellValue(item.getAddr());
                row.createCell(6).setCellValue(item.getStatename());
                row.createCell(7).setCellValue(item.getUsercode());
                row.createCell(8).setCellValue(item.getLoops());
                row.createCell(9).setCellValue(item.getEaddr());
                row.createCell(10).setCellValue(item.getDt());
            }

            // 写入数据到响应流
            workbook.write(response.getOutputStream());
        }
    }
}
