package JDBC.Day01;

import JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_AbsoluteRelative extends JDBCParent {

    @Test
    private void test1() throws SQLException {
        // next() : bir sonraki row
        // previous() : bir onceki row
        // absolute(4) : bastan itibaren direkt 4. row'a gider
        // relative(4) : bulundugu noktadan 4 sonraki row'a gider

        ResultSet result = statement.executeQuery("select * from film");

        result.absolute(10); // 10. satira gonderdik
        String title = result.getString("title");
        System.out.println("title = " + title);

        result.absolute(15); // 15. satira gonderdik
        title = result.getString("title");
        System.out.println("title = " + title);

        result.absolute(-15); // (-) sondan 15. satira gonderdik
        title = result.getString("title");
        System.out.println("title = " + title);

        result.relative(5); // en son bulundugun yerden 5 satir ileri git
        title = result.getString("title");
        System.out.println("title = " + title);

        result.relative(-5); // en son bulundugun yerden 5 satir geri git
        title = result.getString("title");
        System.out.println("title = " + title);

    }
}
