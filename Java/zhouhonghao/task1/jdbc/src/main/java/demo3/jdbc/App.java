package demo3.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Connection conn=null;
		ResultSet rs = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功加载MySql驱动");
			conn=DriverManager.getConnection("jdbc:mysql://www.king.com:3306/data?characterEncoding=UTF-8&useSSL=false", "root", "225510zZ@");
			stmt=conn.createStatement();
			//add(stmt);//添加
			//delete(stmt);//删除
			//update(stmt);//修改
			select(stmt,rs);//查询所有
			//getid(stmt,rs);//通过id查询
		conn.close();
		}catch(SQLException e) {
				System.out.println("mysql操作错误");
				e.printStackTrace();
		}catch(Exception e) {
				e.printStackTrace();
		}finally {
			try {
		        if(rs !=null)rs.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    try {
		        if(stmt !=null)stmt.close();
		    } catch (Exception e) {
		    	 e.printStackTrace();
		    }

		    try {
		        if(conn !=null)conn.close();
		    } catch (Exception e) {
		    	 e.printStackTrace();
		    }
		}

    }

	private static void getid(Statement stmt, ResultSet rs) {
		// TODO 自动生成的方法存根
		String sql= "select * from student1 where id=1";
		 try {
			rs=stmt.executeQuery(sql);
			System.out.println("学号\t姓名\t性别");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	private static void select(Statement stmt, ResultSet rs) {
		// TODO 自动生成的方法存根
		String sql= "select * from student1";
		 try {
			rs=stmt.executeQuery(sql);
			System.out.println("学号\t姓名\t性别");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
			
	}

	private static void update(Statement stmt) {
		// TODO 自动生成的方法存根
		String sql= "update student1 set name='历史了' where id=1";
		try {
			int x=stmt.executeUpdate(sql);
			if(x!=0) {
				System.out.println("更新成功");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	private static void delete(Statement stmt) {
		// TODO 自动生成的方法存根
		String sql= "delete from student1 where id=1";
		try {
			int x=stmt.executeUpdate(sql);
			if(x!=0) {
				System.out.println("删除成功");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	private static void add(Statement stmt) {
		// TODO 自动生成的方法存根
		String sql= "insert into student1 values("+1+","+"'老子'"+","+"'男'"+")";
		try {
			int x=stmt.executeUpdate(sql);
			if(x!=0) {
				System.out.println("添加成功");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
