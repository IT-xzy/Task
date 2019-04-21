import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: 老王
 * Date: 2019/4/12 12:51
 */

public class DatabaseUtil {

    private final static Logger LOGGER = Logger.getLogger(DatabaseUtil.class);

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String URL = "jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "1201";

    private static final String SQL = "DELETE FROM ";// 数据库表内容清空


    static {
        try {

            Class.forName(DRIVER);

        } catch (ClassNotFoundException e) {

            LOGGER.error("数据库驱动加载失败===>>>", e);

        }

    }

    /**
     * 获取数据库连接
     *
     * @return
     */

    public static Connection getConnection() {

        Connection conn = null;

        try {

            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException e) {

            LOGGER.error("数据库连接失败===>>>", e);

        }
        return conn;

    }

    /**
     * 关闭数据库连接
     *
     * @param conn
     */

    public static void closeConnection(Connection conn) {

        if (conn != null) {

            try {

                conn.close();

            } catch (SQLException e) {

                LOGGER.error("数据库关闭失败===>>>", e);

            }

        }

    }

    /**
     * 获取数据库下的所有表名
     */

    public static List<String> getTableNames() {

        List<String> tableNames = new ArrayList<String>();

        Connection conn = getConnection();

        ResultSet rs = null;

        try {       //获取数据库的元数据

            DatabaseMetaData db = conn.getMetaData();  //从元数据中获取到所有的表名

            rs = db.getTables(null, null, null, new String[]{"TABLE"});

            while (rs.next()) {

                tableNames.add(rs.getString(3));

            }

        } catch (SQLException e) {

            LOGGER.error("获取数据库表名失败===>>>", e);

        } finally {
            try {

                rs.close();

                closeConnection(conn);

            } catch (SQLException e) {

                LOGGER.error("关闭数据库失败===>>>", e);

            }

        }
        return tableNames;

    }    /*

     * 清空数据库表     */

    public static void emptyDatabase() throws SQLException {

        List<String> tableNames = getTableNames();

        Connection conn = getConnection();

        PreparedStatement pStemt = null;

        for (String table : tableNames) {

            if (!table.equals("SYSPARAM") && !table.equals("T_CLEAR_DATA")) {

                String tableSql = SQL + table;

                try {

                    pStemt = conn.prepareStatement(tableSql);

                    Statement stmt = conn.createStatement();

                    stmt.executeUpdate(tableSql);

                } catch (SQLException e) {

                    e.printStackTrace();

                }

            }

        }

        conn.close();
        System.out.println("已清空");
    }

}