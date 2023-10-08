package com.vmo.demowebshop.utils.excelutils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
  ThreadLocal<XSSFWorkbook> workbook = new ThreadLocal<>();
  ThreadLocal<XSSFSheet> worksheet = new ThreadLocal<>();
  private final DataFormatter formatter = new DataFormatter();
  private final String excelPath;
  private final String sheetName;

  public ExcelReader(String excelPath, String sheetName) {
    this.excelPath = excelPath;
    this.sheetName = sheetName;
  }
  public synchronized Object[][] getAllData() {
    Object[][] data = new Object[0][];
    try {
      FileInputStream fileInputStream = new FileInputStream(excelPath);
      workbook.set(new XSSFWorkbook(fileInputStream));
      worksheet.set(workbook.get().getSheet(sheetName));
      XSSFRow row = worksheet.get().getRow(0);

      int rowNum = worksheet.get().getPhysicalNumberOfRows();
      int colNum = row.getLastCellNum();

      data = new Object[rowNum - 1][colNum];

      for (int i = 0; i < rowNum - 1; i++) {
        XSSFRow r = worksheet.get().getRow(i + 1);
        for (int j = 0; j < colNum; j++) {
          if (r == null)
            data[i][j] = "";
          else {
            XSSFCell cell = r.getCell(j);
            if (cell == null)
              data[i][j] = "";
            else {
              String value = formatter.formatCellValue(cell);
              data[i][j] = value;
            }
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return data;
  }
  public synchronized Object[][] getData(int startCol, int totalCol) {
        Object[][] data = new Object[0][];
        try {
            FileInputStream fileInputStream = new FileInputStream(excelPath);
            workbook.set(new XSSFWorkbook(fileInputStream));
            worksheet.set(workbook.get().getSheet(sheetName));
            int rowNum = worksheet.get().getPhysicalNumberOfRows();
            data = new Object[rowNum - 1][totalCol];
            for (int i = 0; i < rowNum - 1; i++) {
                XSSFRow r = worksheet.get().getRow(i + 1);
                int c = startCol;
                for (int j = 0; j < totalCol; j++) {
                    if (r == null)
                        data[i][j] = "";
                    else {
                        XSSFCell cell = r.getCell(c);
                        c++;
                        if (cell == null)
                            data[i][j] = "";
                        else {
                            String value = formatter.formatCellValue(cell);
                            data[i][j] = value;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

  public synchronized void writeData(String columnName, String result, int dataSet) {
        int col_num = -1;
        try {
            FileInputStream file_input_stream = new FileInputStream(excelPath);
            workbook.set(new XSSFWorkbook(file_input_stream));
            worksheet.set(workbook.get().getSheet(sheetName));
            XSSFRow row = worksheet.get().getRow(0);

            int sheetIndex = workbook.get().getSheetIndex(sheetName);
            DataFormatter formatter = new DataFormatter();
            if (sheetIndex == -1) {
                System.out.println("Sheet doesn't exist!!!");
            } else {
                for (int i = 0; i < row.getLastCellNum(); i++) {
                    XSSFCell cols = row.getCell(i);
                    String colsVal = formatter.formatCellValue(cols);
                    if (colsVal.trim().equalsIgnoreCase(columnName.trim())) {
                        col_num = i;
                        break;
                    }
                }
                row = worksheet.get().getRow(dataSet);
                try {
                    XSSFCell cell = worksheet.get().getRow(dataSet).getCell(col_num);
                    if (cell == null) {
                        cell = row.createCell(col_num);
                    }
                    cell.setCellValue(result);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            FileOutputStream file_output_stream = new FileOutputStream(excelPath);
            workbook.get().write(file_output_stream);
            file_output_stream.close();
            if (col_num == -1) {
                System.out.println("Column does not exist");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}