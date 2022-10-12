package JDBC.Day02;

import JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _02_GetAllRowColumn extends JDBCParent {

    @Test
    public void test1() throws SQLException {

        ResultSet result = statement.executeQuery("select * from language");
        // ResultSet: data + meta (data disindaki diger bilgiler kolon sayisi vs.)

        ResultSetMetaData metaData = result.getMetaData();
        // sonclarin haricindeki diger bilgiler: kolon sayisi, isimleri, tipleri

        int columnCount = metaData.getColumnCount(); // kolon sayisi
        System.out.println("columnCount = " + columnCount);

        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            String columnType = metaData.getColumnTypeName(i);

            System.out.print("columnName = " + columnName);
            System.out.println(", columnType = " + columnType);

        }

    }

    @Test
    public void test2() throws SQLException {

        // language tablosundaki tüm satırları ve tüm sütunları yazdırınız,
        // aynı mysql sonuç ekranında olduğu gibi

        ResultSet result = statement.executeQuery("select * from language");

        ResultSetMetaData metaData = result.getMetaData();

        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            System.out.print(metaData.getColumnName(i) + " ");
        }

        System.out.println();

        while (result.next()) {
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.print(result.getString(i) + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void test3() throws SQLException {

        // language tablosundaki tüm satırları ve tüm sütunları yazdırınız,
        // aynı mysql sonuç ekranında olduğu gibi

        ResultSet result = statement.executeQuery("select * from language");

        ResultSetMetaData metaData = result.getMetaData();

        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            System.out.printf("%-20s", metaData.getColumnName(i));
            // % : degiskenin degerini isaret eder
            // - : sola dayali yazdirir, default saga dogru yazdirir
            // 20 : kac hane kullanilacak her zaman onun bilgisi verildi
            // s : String degerler icin yazildi. Sayisal degerler icin "d" kullanilir
            // "%5.2d" : sayı için 5 hane kullan, ondalıklı kısım için 2 hane
        }

        System.out.println();

        while (result.next()) {
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.printf("%-20s", result.getString(i) + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void test4() throws SQLException {

        // actor tablosundaki tüm satırları ve tüm sütunları yazdırınız, aynı mysql sonuç ekranında olduğu gibi
        // fakat metod kullanınız, metoda sorguyu gönderiniz ve orada yazdırınız.

        getTable("select * from actor");

    }

    public void getTable(String sorgu) throws SQLException {

        ResultSet result = statement.executeQuery(sorgu);

        ResultSetMetaData metaData = result.getMetaData();

        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            System.out.printf("%-20s", metaData.getColumnName(i));
        }

        System.out.println();

        while (result.next()) {
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.printf("%-20s", result.getString(i) + " ");
            }
            System.out.println();
        }
    }
}

