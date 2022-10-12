package Utilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {

    private static Connection connection;

    protected static Statement statement;

    @BeforeTest
    protected static void DBconnectionOpen() {

        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    protected static void DBconnectionClose() {

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        List<List<String>> tablo = getListData("select * from actor");

        for (List<String> row : tablo) { // test icin kontrol,  veriler geldi mi' liste atildi mi?
            System.out.println("row = " + row);
        }
    }

    public static List<List<String>> getListData(String query) {

        List<List<String>> tablo = new ArrayList<>();
        //db den bütün satırları ve sütunları okuyup bu liste atıcam

        // db bağlantıyı aç
        DBconnectionOpen();

        try {
            //1- sorguyu çalıştır
            ResultSet rs = statement.executeQuery(query);
            //2- bütün satırları ve o satırlardaki sütunları oku Tabloya ekle
            int numberOfColumn = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                List<String> row = new ArrayList<>();
                for (int i = 1; i <= numberOfColumn; i++) {
                    row.add(rs.getString(i));
                }

                tablo.add(row);
            }

        } catch (Exception ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }

        DBconnectionClose();
        //db bağlantısı kapat
        return tablo;
    }
}