package com.memcards;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ExcelFile {
    private final Map<String, String> items = new HashMap<>();

    public ExcelFile() {

    }

    public Map<String, String> getItems() {
        return items;
    }

    public void loadItems(Path path) {
        try {
            InputStream in = new FileInputStream(String.valueOf(path));
            HSSFWorkbook wb = new HSSFWorkbook(in);
            Sheet sheet = wb.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    items.put(String.valueOf(row.getCell(0)), cell.toString());
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeItemsToFile (Path path) {
        try {
            int num = 0;
            OutputStream out = new FileOutputStream(String.valueOf(path));
            HSSFWorkbook wb = new HSSFWorkbook();
            Sheet sheet = wb.createSheet("Words");
            Row row;
            for (Map.Entry<String, String> item : items.entrySet()) {
                row = sheet.createRow(num++);
                row.createCell(0).setCellValue(item.getKey());
                row.createCell(1).setCellValue(item.getValue());
            }
            wb.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
