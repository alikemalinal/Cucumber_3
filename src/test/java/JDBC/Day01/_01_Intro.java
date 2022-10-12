package JDBC.Day01;

// 1- connection : önce bağlantı ayarlarını yaptık
//        username, password, url(port, db, baglantı yolu)
//
// 2- Sorgu çalıştırma yolu : sorgularımı çalıştırmak için bir sayfa(yol) açtım.
//
// 3- Sonuçların alınması : sorgunun çalışması sonucu veritabanından gelen bilgiler.

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Intro {

    @Test
    public void test1() throws SQLException {

        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila"; // hostname, port/db adi lazim
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        Connection connection = DriverManager.getConnection(url, username, password); // connection

        Statement statement = connection.createStatement(); // sorgulari calistirmak icin page acildi.

        ResultSet result = statement.executeQuery("select * from actor"); // sorgu sonucu olustu ama db'de bekliyor

        // 1.satir
        result.next();

        String firstName = result.getString("first_name");
        String lastName = result.getString("last_name");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        // 2.satir
        result.next();

        firstName = result.getString("first_name");
        lastName = result.getString("last_name");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        connection.close();
    }
}



