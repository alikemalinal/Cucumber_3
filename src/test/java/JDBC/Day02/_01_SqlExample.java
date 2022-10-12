package JDBC.Day02;

import JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _01_SqlExample extends JDBCParent {

    // last, first, getRow, getInd, getDouble
    @Test
    public void test1() throws SQLException {

        ResultSet result = statement.executeQuery("select city_id, city, country_id from city");

        result.last(); // sonuncu row'a gider

        String id = result.getString(1);
        System.out.println("id = " + id);

        int idInt = result.getInt(1);
        System.out.println("idInt = " + idInt);

        String name = result.getString(2);
        System.out.println("name = " + name);

//        int nameInt = result.getInt(2);
//        System.out.println("nameInt = " + nameInt);
//        tipi uygun olan donusumle mesela hepsini String olarak alabilirsin.
//        ancak tipi uygun olmayan mesela isimleri int olarak zaten alinmaz

        int whichRow = result.getRow();
//      dolayisiyla bir sorgunun sonucunda kac satir geldigini
//      result.last() dedikten sonra result.getRow() ile alabilirim

        result.first(); // ilk satira gider


    }
}
