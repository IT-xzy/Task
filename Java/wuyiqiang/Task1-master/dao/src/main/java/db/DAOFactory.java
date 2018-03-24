package db;

public class DAOFactory {
    public static UserDAO getDAOProxy() throws Exception {
        return new DAOProxy();
    }

    //oracle
    /*
    public static UserDAO getUserDAOInstance(){
        <span style="background-color: #ff0000;">return new UserDAOOracleImpl()</span> ;
    }
     */
}
