package org.example.util;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.example.entity.Sys_equideti;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class ExcelReader {

    public static List<Sys_equideti> readExcel(InputStream inputStream) {
        List<Sys_equideti> list = new ArrayList<>();
        try (Workbook workbook = WorkbookFactory.create(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // 跳过标题行
                Sys_equideti item = convertRowToData(row);
                if (item != null) {
                    list.add(item);
                }
            }
        } catch (Exception e) {
            // Log the error or handle it as per your application's need
            e.printStackTrace();
        }
        return list;
    }

    private static Sys_equideti convertRowToData(Row row) {
        Sys_equideti data = new Sys_equideti();
        try {
            data.setEngicode(getCellValueAsString(row.getCell(0)));  // 控制器编码
            data.setName(getCellValueAsString(row.getCell(1)));      // 设备名称
            data.setAddr(getCellValueAsString(row.getCell(2)));      // 部件注释
            data.setUsercode(getCellValueAsString(row.getCell(3)));  // 用户编码
            data.setNumber(getCellValueAsString(row.getCell(4)));   // 机号
            data.setLoops(getCellValueAsString(row.getCell(5)));    // 回路
            data.setEaddr(getCellValueAsString(row.getCell(6)));    // 地址码
            data.setTray(getCellValueAsString(row.getCell(7)));     // 盘号
            data.setHandkey(getCellValueAsString(row.getCell(8)));  // 手动键号
            // Continue for other fields...
        } catch (Exception e) {
            // Handle any exceptions, possibly logging them
            return null; // or handle it in a way that fits your application
        }
        return data;
    }

    private static String getCellValueAsString(Cell cell) {
        if (cell == null) return null;
        cell.setCellType(CellType.STRING);
        return cell.getStringCellValue();
    }
    private static Integer getCellValueAsInteger(Cell cell) {
        if (cell != null && cell.getCellType() == CellType.NUMERIC) {
            return (int) cell.getNumericCellValue();
        }
        return null; // 或者返回默认值，如0
    }


}
