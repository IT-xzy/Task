package impl;

import Entity.Signup;
import dao.signupDAO;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class signupDAOimpl extends JdbcDaoSupport implements signupDAO {

    public String FindSignupByID(Long id) {
        String sql = "SELECT name FROM signup WHERE id=?";
        return this.getJdbcTemplate().queryForObject(sql,String.class,id);
    }

    public int InsertSignup(Signup signup) {
        String sql = "INSERT INTO signup(name,qq) VALUE (?,?)";
        return this.getJdbcTemplate().update(sql, signup.getName(),signup.getQq());
    }

    public int DeleteByName(String name){
        String sql = "Delete from signup WHERE name=?";
        return this.getJdbcTemplate().update(sql,name);
    }
    public int UpdateByName(String name) {
        String sql = "UPDATE signup SET Name='西西' WHERE name=?";
        return this.getJdbcTemplate().update(sql,name);
    }


}
