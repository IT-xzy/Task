package JDBCTemplate;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultTest {
    ResultSet result;
    PreparedStatement sql;
    public void getResult(PreparedStatement sql) throws SQLException {
        result = sql.executeQuery();
        while (result.next()) {
            Long ID = result.getLong("ID");
            String name = result.getString("name");
            Long QQ = result.getLong("QQ");
            String onlineID = result.getString("onlineID");
            String time_of_enrollment = result.getString("time_of_enrollment");
            String graduate_institutions = result.getString("graduate_institutions");
            String report_link = result.getString("report_link");
            String swear = result.getString("swear");
            String hearfrom = result.getString("hearfrom");
            System.out.print(ID);
            System.out.print(name);
            System.out.print(QQ);
            System.out.print(onlineID);
            System.out.print(time_of_enrollment);
            System.out.print(graduate_institutions);
            System.out.print(report_link);
            System.out.print(swear);
            System.out.println(hearfrom);
        }

}
}
