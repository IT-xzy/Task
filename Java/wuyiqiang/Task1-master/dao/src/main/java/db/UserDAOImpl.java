package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private PreparedStatement pstmt = null ;
    private DataBaseConnection dbc = null ;

    public UserDAOImpl(DataBaseConnection dbc){
        this.dbc = dbc;
    }

    public void insert(User user) throws Exception {
        //添加操作
        String sql = "INSERT INTO user(username,password) VALUES(?,?)" ;
        // 下面是针对数据库的具体操作
        try{
            // 连接数据库
            pstmt = dbc.getConnection().prepareStatement(sql) ;
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            // 进行数据库更新操作
            pstmt.executeUpdate() ;
            pstmt.close() ;
        }catch (Exception e){
            throw new Exception("操作出现异常") ;
        }
    }
    //修改操作
    public void update(User user) throws Exception {
        String sql = "UPDATE user SET username=?,password=? WHERE userid=?" ;
        // 下面是针对数据库的具体操作
        try{
            // 连接数据库
            pstmt = dbc.getConnection().prepareStatement(sql) ;
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setInt(3,user.getUserid());
            // 进行数据库更新操作
            pstmt.executeUpdate() ;
            pstmt.close() ;
        }
        catch (Exception e){
            throw new Exception("操作出现异常") ;
        }
    }
    //删除操作
    public void delete(int userid) throws Exception {
        String sql = "DELETE FROM user WHERE userid=?" ;
        // 下面是针对数据库的具体操作
        try{
            // 连接数据库
            pstmt = dbc.getConnection().prepareStatement(sql) ;
            pstmt.setInt(1,userid) ;
            // 进行数据库更新操作
            pstmt.executeUpdate() ;
            pstmt.close() ;
        }catch (Exception e){
            throw new Exception("操作出现异常") ;
        }
    }
    //按ID查询
    public User queryById(int userid) throws Exception {
        User user = null ;
        String sql = "SELECT * FROM user WHERE userid=?" ;
        // 下面是针对数据库的具体操作
        try{
            // 连接数据库
            pstmt = dbc.getConnection().prepareStatement(sql) ;
            pstmt.setInt(1, userid);
            // 进行数据库查询操作
            ResultSet rs = pstmt.executeQuery() ;
            if(rs.next())
            {
                // 查询出内容，之后将查询出的内容赋值给user对象
                user = new User() ;
                user.setUserid(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
            }
            rs.close() ;
            pstmt.close() ;
        }catch (Exception e){
            throw new Exception("操作出现异常") ;
        }
        return user ;
    }
    public List<User> queryAll() throws Exception {
        List<User> all = new ArrayList<User>() ;
        String sql = "SELECT * FROM user " ;

        // 下面是针对数据库的具体操作
        try{
            // 连接数据库
            pstmt = dbc.getConnection().prepareStatement(sql) ;
            // 进行数据库查询操作
            ResultSet rs = pstmt.executeQuery() ;
            while(rs.next()){
                // 查询出内容，之后将查询出的内容赋值给user对象
                User user = new User() ;
                user.setUserid(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));

                // 将查询出来的数据加入到List对象之中
                all.add(user) ;
            }
            rs.close() ;
            pstmt.close() ;
        }
        catch (Exception e){
            throw new Exception("操作出现异常") ;
        }
        return all ;
    }
}