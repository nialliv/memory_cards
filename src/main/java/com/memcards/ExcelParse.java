package com.memcards;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ExcelParse {
    private Map<String, String> items = new HashMap<>();

    public ExcelParse(Path path) {
        try {
            InputStream in = new FileInputStream(String.valueOf(path));
//            XSSFWorkbook
            HSSFWorkbook wb = new HSSFWorkbook(in);
            Sheet sheet = wb.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    items.put(String.valueOf(row.getCell(0)), cell.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> getItems() {
        return items;
    }
}
