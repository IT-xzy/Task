package crud.dao.imp;

import java.sql.*;

import crud.connection.DatabaseConnection;
import crud.dao.StudentsDAO;

public class StudentsDAOImp extends DatabaseConnection implements StudentsDAO
{
    Statement stmt=null;
    String sql=null;
    ResultSet rs=null;


    public void doINSERT() throws Exception {
        DatabaseConnection stuDB=new DatabaseConnection();
        stuDB.DbConnection();
        Connection conn=stuDB.getconnection();
        sql = "insert into student values(99,'岳飞飞',20180608,20160608,892499056,'java工程师',20180602," +
                "'大连交通大学','java-666','http://www.jnshu.com/school/22071/daily','看看星星就好','李')";
        stmt = conn.createStatement();
        stmt.executeUpdate(sql);

    }

    public void doUPDATE() throws Exception {
        DatabaseConnection stuDB=new DatabaseConnection();
        stuDB.DbConnection();
        Connection conn=stuDB.getconnection();
        sql = "update student set slogen='老大最帅' where name='岳飞飞'";
        stmt = conn.createStatement();
        stmt.executeUpdate(sql);

    }

    public void doDELETE() throws Exception {
        DatabaseConnection stuDB=new DatabaseConnection();
        stuDB.DbConnection();
        Connection conn=stuDB.getconnection();
        sql = "DELETE FROM student where id='69'";
        stmt = conn.createStatement();
        stmt.executeUpdate(sql);

    }

    public void doSELECT() throws Exception {
        DatabaseConnection stuDB=new DatabaseConnection();
        stuDB.DbConnection();
        Connection conn=stuDB.getconnection();
        sql = "select * FROM student where id='99'";
        stmt = conn.createStatement();
        rs=stmt.executeQuery(sql);
        while(rs.next()){

            int id=rs.getInt(1);
            String name=rs.getString(2);
            Long creat_at=rs.getLong(3);
            Long update_at=rs.getLong(4);
            int qq=rs.getInt(5);
            String study_type=rs.getString(6);
            Long join_time=rs.getLong(7);
            String university=rs.getString(8);
            String study_id=rs.getString(9);
            String daily_link=rs.getString(10);
            String slogen=rs.getString(11);
            String master=rs.getString(12);

            System.out.println("id= "+id+";");
            System.out.println("creat_at= "+creat_at+";");
            System.out.println("update_at= "+update_at+";");
            System.out.println("name= "+name+";");
            System.out.println("qq= "+qq+";");
            System.out.println("study_type= "+study_type+";");
            System.out.println("study_id= "+study_id+";");
            System.out.println("join_time= "+join_time+";");
            System.out.println("university= "+university+";");
            System.out.println("daily_link= "+daily_link+";");
            System.out.println("slogen= "+slogen+";");
            System.out.println("master= "+master+";");
            }

    }
}








