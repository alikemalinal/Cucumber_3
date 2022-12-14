package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class _04_ApachePOIGetAllData {
    public static void main(String[] args) throws IOException {

        String path = "src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("Sheet1");

        // calısma sayfasındaki toplam satır sayısını veriyor.
        int rowCount = sheet.getPhysicalNumberOfRows();

        for (int i = 0; i < rowCount; i++) {

            Row row = sheet.getRow(i); // row(satır) sayısı alındı.
            int cellCount = row.getPhysicalNumberOfCells(); // bu row'daki toplam cell(hücre) sayısı alındı.

            for (int j = 0; j < cellCount; j++) { // row'daki cell sayısı kadar dönecek.
                Cell cell = row.getCell(j); // bu row'daki sıradaki cell'i aldım.

                System.out.print(cell + " ");
            }

            System.out.println();
        }
    }
}
