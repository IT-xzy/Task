package com.jdbctemplate.daoservice;

import com.jdbctemplate.dao.UserDao;
import com.jdbctemplate.pojo.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.lang.Nullable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbctemplate;

    public JdbcTemplate getJdbctemplate() {
        return jdbctemplate;
    }

    public void setJdbctemplate(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }

//    查询全部
    @Override
    public List<User> findAll() {

        String sql = "select * from jnshu_user";

        List<User> list = new ArrayList<User>();
        jdbctemplate.queryForList(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                User u = new User();
                u.setId(resultSet.getInt("id"));
                u.setCreate_at(resultSet.getInt("create_at"));
                u.setUpdate_at(resultSet.getInt("update_at"));
                u.setName(resultSet.getString("name"));
                u.setSchool(resultSet.getString("school"));
                u.setStu_num(resultSet.getInt("stu_num"));
                u.setType(resultSet.getInt("type"));
                u.setQq(resultSet.getInt("qq"));
                u.setAge(resultSet.getInt("age"));
                u.setSex(resultSet.getInt("sex"));
                u.setPro(resultSet.getString("pro"));
                u.setBrother(resultSet.getString("brother"));
                u.setDaily_link(resultSet.getString("daily_link"));
                u.setStart_time(resultSet.getString("start_time"));

                list.add(u);
            }
        });

        return list;
    }

//    查询数据
    @Override
    public User selectById(int id) {

        String sql = "select * from jnshu_user where id = ?";

//        查询出来的数据是返回类型
        User user = jdbctemplate.queryForObject(sql, new RowMapper<User>() {

            @Nullable
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User u = new User();
                u.setId(resultSet.getInt("id"));
                u.setCreate_at(resultSet.getInt("create_at"));
                u.setUpdate_at(resultSet.getInt("update_at"));
                u.setName(resultSet.getString("name"));
                u.setSchool(resultSet.getString("school"));
                u.setStu_num(resultSet.getInt("stu_num"));
                u.setType(resultSet.getInt("type"));
                u.setQq(resultSet.getInt("qq"));
                u.setAge(resultSet.getInt("age"));
                u.setSex(resultSet.getInt("sex"));
                u.setPro(resultSet.getString("pro"));
                u.setBrother(resultSet.getString("brother"));
                u.setDaily_link(resultSet.getString("daily_link"));
                u.setStart_time(resultSet.getString("start_time"));
                return u;
            }
        }, id);

        return user;
    }

//    修改数据
    @Override
    public void updateUser(User user) {

//        String sql = "update jnshu_user set (name,create_at,update_at,age,sex,pro,brother) values( ?,?,?,?,?,?,? ) where id = ?";
        String sql = "update jnshu_user set update_at=?,name=?,school=?,stu_num=?,type=?,qq=?,age=?,sex=?,pro=?,brother=?,daily_link=?,start_time=? where id = ?";
        jdbctemplate.update(sql,user.getUpdate_at(),user.getName(),user.getSchool(),user.getStu_num(),user.getType(),user.getQq(),user.getAge(),user.getSex(),user.getPro(),user.getBrother(),user.getDaily_link(),user.getStart_time(),user.getId());

    }

//    删除数据
    @Override
    public void delectUser(int id) {

        String sql = "delete jnshu_user where id = ?";

        jdbctemplate.update(sql,id);
    }

//    添加数据,获取返回值
    @Override
    public int insertUser(User user) {

//        留方法修改
        String sql = "insert into jnshu_user (name,school,stu_num,type,qq,age,sex,pro,brother,daily_link,start_time,create_at,update_at) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
//        不返回参数直接使用update就可以了
//        jdbctemplate.update(sql,user);

//      返回参数需要自己重写方法
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbctemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pstmt.setObject(1,user.getName());
                pstmt.setObject(2,user.getSchool());
                pstmt.setObject(3,user.getStu_num());
                pstmt.setObject(4,user.getType());
                pstmt.setObject(5,user.getQq());
                pstmt.setObject(6,user.getAge());
                pstmt.setObject(7,user.getSex());
                pstmt.setObject(8,user.getPro());
                pstmt.setObject(9,user.getBrother());
                pstmt.setObject(10,user.getDaily_link());
                pstmt.setObject(11,user.getStart_time());
                pstmt.setLong(12,user.getCreate_at());
                pstmt.setLong(13,user.getUpdate_at());
                return pstmt;
            }
        },keyHolder);

        return keyHolder.getKey().intValue();
    }

//    批量添加
    @Override
    public void insertList(List<User> list) {

        String sql = "insert into jnshu_user (create_at,update_at,name,school,stu_num,type,qq,age,sex,pro,brother,daily_link,start_time) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        List<Object[]>  users = new ArrayList<>();
//        循环添加
        for(User user : list){
            Object[] ob = new Object[]{
                    user.getCreate_at(),
                    user.getUpdate_at(),
                    user.getName(),
                    user.getSchool(),
                    user.getStu_num(),
                    user.getType(),
                    user.getQq(),
                    user.getAge(),
                    user.getSex(),
                    user.getPro(),
                    user.getBrother(),
                    user.getDaily_link(),
                    user.getStart_time()
            };
            users.add(ob);
//            users.add(new Object[]{user.getName(),user.getSchool(),user.getStu_num(),user.getType(),user.getQq(),user.getAge(),user.getSex(),user.getPro(),user.getBrother(),user.getDaily_link(),user.getStart_time()});
        }

//        jdbctemplate.batchUpdate(sql,users);
        jdbctemplate.batchUpdate(sql,users);
    }

    //        查询数据总数
    public int selectCount(){
        String sql = "select Count(*) from jnshu_user ";
//        spring 3.2.2后取消ForInt
        int conut =  jdbctemplate.queryForObject(sql,new Object[]{},Integer.class);
        return conut;
    }




}
