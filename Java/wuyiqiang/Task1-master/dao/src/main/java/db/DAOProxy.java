package db;

import java.util.ArrayList;
import java.util.List;

public class DAOProxy implements UserDAO {

    private DataBaseConnection dbc = null;
    private UserDAOImpl dao = null;

    public DAOProxy() throws Exception{
        this.dbc = new DataBaseConnection();
        this.dao = new UserDAOImpl(dbc);
    }

    public void insert(User user) throws Exception {
        try{
            this.dao.insert(user);
        }catch(Exception e) {
            throw e;
        }finally{
            this.dbc.close();
        }
    }

    public void update(User user) throws Exception {
        try{
            this.dao.update(user);
        }catch(Exception e) {
            throw e;
        }finally{
            this.dbc.close();
        }
    }

    public void delete(int userid) throws Exception {
        try{
            this.dao.delete(userid);
        }catch(Exception e) {
            throw e;
        }finally{
            this.dbc.close();
        }
    }

    public User queryById(int userid) throws Exception {
        User user = null;
        try{
            user = this.dao.queryById(userid);
        }catch(Exception e) {
            throw e;
        }finally{
            this.dbc.close();
        }
        return user;
    }

    public List queryAll() throws Exception {
        List<User> all = new ArrayList<User>();
        try{
            all = this.dao.queryAll();
        }catch(Exception e) {
            throw e;
        }finally{
            this.dbc.close();
        }
        return all;
    }
}
