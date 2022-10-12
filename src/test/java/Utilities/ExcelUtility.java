package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;

public class ExcelUtility {

    //  kendisine verilen path deki excelin, istenilen, sheetindeki
    //  istenilen kolona kadar sütunları okuyup Arraylist formatında geri döndüren fonksiyonu yazınız.
    //  getListData("src/test/java/ApachePOI/resources/ApacheExcel2.xlsx","testCitizen", 2); 0-2 kolon arası

    public static void main(String[] args) {

        ArrayList<ArrayList<String>> table = getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx", "testCitizen", 2);

        System.out.println("Table: " + table);
    }

    public static ArrayList<ArrayList<String>> getListData(String path, String sheetName, int columnCount) {
        ArrayList<ArrayList<String>> table = new ArrayList<>();

        Workbook workbook = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet = workbook.getSheet(sheetName);

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            ArrayList<String> rowData = new ArrayList<>();

            for (int j = 0; j < columnCount; j++) {
                rowData.add(sheet.getRow(i).getCell(j).toString());
            }

            table.add(rowData);
        }

        return table;
    }

    public static void writeExcel(String path, Scenario scenario, String browserName, String time) {

        File file = new File(path);

        if (!file.exists()) {  // başına ! koyarsak yoksa anlamına gelir.

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Sheet1");

            Row newRow = sheet.createRow(0);

            Cell newCell = newRow.createCell(0);
            newCell.setCellValue(scenario.getName());

            newCell = newRow.createCell(1);
            newCell.setCellValue(scenario.getStatus().toString());

            newCell = newRow.createCell(2);
            newCell.setCellValue(browserName);

            newCell = newRow.createCell(3);
            newCell.setCellValue(time);

            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {

            FileInputStream fileInputStream = null;
            Workbook workbook = null;
            try {
                fileInputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(fileInputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Sheet sheet = workbook.getSheetAt(0);

            int rowCount = sheet.getPhysicalNumberOfRows(); // 6 satır var 0 -5
            Row newRow = sheet.createRow(rowCount); // en son satırın altına acıldı.

            Cell newCell = newRow.createCell(0);
            newCell.setCellValue(scenario.getName());

            newCell = newRow.createCell(1);
            newCell.setCellValue(scenario.getStatus().toString());

            newCell = newRow.createCell(2);
            newCell.setCellValue(browserName);

            newCell = newRow.createCell(3);
            newCell.setCellValue(time);

            try {
                fileInputStream.close();
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
