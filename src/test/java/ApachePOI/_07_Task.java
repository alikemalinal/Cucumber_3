package ApachePOI;

/*
      Bir önceki soruda kullanıcıdan bu sefer sütun numarası
      isteyiniz ve o sütundaki bütün bilgileri yazdırınız

     */

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _07_Task {
    public static void main(String[] args) {

        System.out.print("Searching column: ");
        Scanner scanner = new Scanner(System.in);
        int column = scanner.nextInt();

        String result = find(column);

        System.out.println("Result: " + result);

    }

    public static String find(int column) {

        String value = "";

        String path = "src/test/java/ApachePOI/resource/LoginData.xlsx";

        Workbook workbook = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet = workbook.getSheet("Login");

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            if (sheet.getRow(i).getPhysicalNumberOfCells() > column) {
                value += sheet.getRow(i).getCell(column) + "\n";
            }
        }

        return value;
    }
}
