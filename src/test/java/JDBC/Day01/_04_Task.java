package JDBC.Day01;

import JDBC.JDBCParent;
import org.testng.annotations.Test;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_Task extends JDBCParent {

    // city tablosundaki tum kayitlari next ile yazdiriniz
    // city tablosundaki tum kayitlari absolute ile yazdiriniz
    // city tablosundaki tum kayitlari relative ile yazdiriniz

    @Test
    public void test1() throws SQLException {

        ResultSet result = statement.executeQuery("select * from city");

        int count = 0;
        while (result.next()) {
            System.out.println(result.getString(1));
            System.out.println(result.getString(2));
            System.out.println(result.getString(3));
            count++;
        }
        System.out.println("Count: " + count);
    }

    @Test
    public void test2() throws SQLException {

        ResultSet result = statement.executeQuery("select * from city");

        int count = 1;
        while (result.absolute(count)) {
            System.out.println(result.getString(2));
            count++;
        }
        System.out.println("Count: " + count);
    }

    @Test
    public void test3() throws SQLException {

        ResultSet result = statement.executeQuery("select * from city");

        int count = 0;
        while (result.relative(1)) {
            System.out.println(result.getString(2));
            count++;
        }
        System.out.println("Count: " + count);
    }
}
