package JDBCTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InitStatement {
    static Connection con;
    static PreparedStatement sql;
    static String stb;
    static int a,b;

    public InitStatement() {
        TemplateDemo c = new TemplateDemo();
        con = c.open();
    }

    public PreparedStatement select(PreparedStatement sql, String stb){

        try {
            sql = con.prepareStatement(stb);
            sql.setInt(a, b);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sql;
    }

}
