package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _09_NewExcelWrite {
    public static void main(String[] args) throws IOException {

        // hafızada yeni workbook olustur, sonra sheet olustur, sonra row olustur, sonra cell olustur.
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");

        Row newRow = sheet.createRow(0); // satır 0. yerde olusturuldu.
        Cell newCell = newRow.createCell(0); // yeni satırda ilk hucre olusturuldu.
        newCell.setCellValue("Hello World"); // bilgi yazıldı.

        for (int i = 1; i < 10; i++) {
            newRow.createCell(i).setCellValue(i);
        }

        String newExcelPath = "src/test/java/ApachePOI/resource/NewExcel.xlsx"; // yeni excel olusturduk.
        FileOutputStream outputStream = new FileOutputStream(newExcelPath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("Process is done...");
    }
}
