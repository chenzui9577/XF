package org.example.util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.entity.Sys_equideti;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ExcelExporter {

    public static void exportToExcel(List<Sys_equideti> dataList, HttpServletResponse response) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet("SysEquideti Data");

            // 创建头部行
            Row headerRow = sheet.createRow(0);
            String[] headers = {"控制器编码", "部件名称", "部件注释", "用户编码", "机号", "回路", "地址码", "盘号", "手动键号"};
            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

            // 填充数据行
            int rowNum = 1;
            for (Sys_equideti item : dataList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(item.getEngicode());
                row.createCell(1).setCellValue(item.getName());
                row.createCell(2).setCellValue(item.getAddr());
                row.createCell(3).setCellValue(item.getUsercode());
                row.createCell(4).setCellValue(item.getNumber());
                row.createCell(5).setCellValue(item.getLoops());
                row.createCell(6).setCellValue(item.getEaddr());
                row.createCell(7).setCellValue(item.getTray());
                row.createCell(8).setCellValue(item.getHandkey());
            }

            // 写入数据到响应流
            workbook.write(response.getOutputStream());
        }
    }
}
