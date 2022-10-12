package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class _03_ApachePOIStart {
    public static void main(String[] args) throws IOException {

        // excel copy/path reference'ı aldık.
        String path = "src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";

        // böylece dosya ile progam arasında baglanti gerceklesti.
        FileInputStream fileInputStream = new FileInputStream(path);

        // Dosya okuma islemcisi uzerinden calısma kitabını alıyorum.
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // istedigim isimdeki calısma sayfasını aldım.
        Sheet sheet = workbook.getSheet("Sheet1");

        // istenen satırı alıyorum.
        Row row = sheet.getRow(0);

        Cell cell = row.getCell(0);

        System.out.println("Cell: " + cell);

    }
}
