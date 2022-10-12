package ApachePOI;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Verilen Exceldeki password bilgisini bir metoda aracılığı bularak yazdırınız,
 * yani metoda "password" kelimesi gönderilecek, dönen değer password'un kendisi olacak.
 * src/test/java/ApachePOI/resources/LoginData.xlsx
 */

public class _05_GetASpecificData {
    public static void main(String[] args) throws IOException {

        System.out.print("Searching word: ");
        Scanner scanner = new Scanner(System.in);
        String searchWord = scanner.next();

        String result = find(searchWord);

        System.out.println("Result: " + result);
    }

    public static String find(String searchWord) {

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
        int rowCount = sheet.getPhysicalNumberOfRows();

        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0);

            if (searchWord.equalsIgnoreCase(cell.toString())) {
                int cellCount = row.getPhysicalNumberOfCells();

                for (int j = 1; j < cellCount; j++) {
                    value += row.getCell(j) + " ";
                }
            }
        }

        return value;
    }
}
