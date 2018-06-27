package jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DBCPUtils {

	private static DataSource dataSource = null;

	static {
		InputStream in = DBCPUtils.class.getClassLoader().getResourceAsStream(
				"jdbc/util/db.properties");
		Properties properties = new Properties();
		try {
			properties.load(in);
			dataSource = BasicDataSourceFactory.createDataSource(properties);

		} catch (IOException e) {
			System.out.println("load properties file failure:" + e);
			throw new ExceptionInInitializerError(e);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() throws SQLException {
		return DBCPUtils.dataSource.getConnection();
	}

	public static void release(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		connection = null;
	}

	public static void release(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		statement = null;
	}

	public static void release(ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resultSet = null;
	}
}