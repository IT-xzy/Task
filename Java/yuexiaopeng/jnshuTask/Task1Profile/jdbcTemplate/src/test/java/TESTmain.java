import crud.dao.imp.StudentsDAOImp;

import java.sql.Connection;
import java.sql.SQLException;

public class TESTmain extends StudentsDAOImp{
    public static void main(String[] args)throws  Exception
    {
        StudentsDAOImp studaoIMP=new StudentsDAOImp();
        studaoIMP.DbConnection();
        Connection stuconn=studaoIMP.getconnection();

        try{studaoIMP.doINSERT();}
        catch (SQLException SE){SE.printStackTrace();}
        catch (Exception E){E.printStackTrace();}
        if(stuconn!=null)
        {
            stuconn.close();
            System.out.println("successful");
        }
        else System.out.println("defait");


    }
}
