package db;

public class DAOFactory {
    public static UserDAO getUserDAOInstance(){
        return new UserDAOImpl() ;
    }

    //oracle
    /*
    public static UserDAO getUserDAOInstance(){
        <span style="background-color: #ff0000;">return new UserDAOOracleImpl()</span> ;
    }
     */
}
