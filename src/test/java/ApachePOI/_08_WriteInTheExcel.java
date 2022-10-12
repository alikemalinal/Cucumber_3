package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _08_WriteInTheExcel {
    public static void main(String[] args) throws IOException {

        // var olan bir Excel yazma islemi
        String path = "src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path); // okuma modunda acıldı.
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("Sheet1");

        // Hafızada olusturma ve yazma islemleri yapılıyor.
        Row newRow = sheet.createRow(0); // satır 0. yerde olusturuldu.
        Cell newCell = newRow.createCell(0); // yeni satırda ilk hucre olusturuldu.
        newCell.setCellValue("Hello World"); // bilgi yazıldı.

        for (int i = 1; i < 10; i++) {
            newRow.createCell(i).setCellValue(i);
        }

        // sıra kaydetmeye geldi, bütün bilgiler hafızada buraya kadar herşey worbook'da
        fileInputStream.close(); // okuma modunu kapattım cunku yazma modunda acmam gerekiyor.

        // Yazma islemini yazma modunda acıp oyle yapıyoruz.
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close(); // hafıza bosaltıldı.
        outputStream.close();
        System.out.println("Process is done...");


    }
}
