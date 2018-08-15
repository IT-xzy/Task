package cc.myhome.jdbctemplate.service;

import cc.myhome.jdbctemplate.dao.Dao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import cc.myhome.model.Network1;


import java.util.List;
import java.util.Map;

public class Daoimpl2 implements Dao {

    private JdbcTemplate jdbcTemplate;

    public Daoimpl2(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public void insert(Network1 stu){
        String sql = "INSERT INTO network1 (Name, QQ, Type, Enrolment_time, Graduate, Report_link, Wish," +
                "Senior, How_know, Create_at, Update_at) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, stu.getName(), stu.getQQ(), stu.getType(),
                stu.getEnrolmentTime(), stu.getGraduate(), stu.getReportLink(),
                stu.getWish(), stu.getSenior(), stu.getHowKnow(), stu.getCreateAt(), stu.getUpdateAt());

    }

    @Override
    public void update(long id, Network1 stu){
        String sql = "UPDATE network1 SET Name = ?,QQ = ?,Type = ?," +
                "Enrolment_time = ?,Graduate = ?,Report_link = ?,Wish = ?,Senior = ?," +
                "How_know = ?,Create_at = ?,Update_at = ? WHERE Line_id = ?";
        jdbcTemplate.update(sql, stu.getName(), stu.getQQ(), stu.getType(),
                stu.getEnrolmentTime(), stu.getGraduate(), stu.getReportLink(),
                stu.getWish(), stu.getSenior(), stu.getHowKnow(),
                stu.getCreateAt(), stu.getUpdateAt(),id);


    }

    @Override
    public List selectAll(){
        String sql = "SELECT * FROM network1";
        List rows = jdbcTemplate.queryForList(sql);
        return rows;
    }

    @Override
    public Map selectById(long id){
        String sql = "SELECT * FROM network1 WHERE Line_id = ?";
        Map myMap = (Map) jdbcTemplate.queryForMap(sql, id);
        return myMap;


    }

    @Override
    public List selectByName(String name){
        String sql = "SELECT * FROM network1 WHERE Name = ?";
        List rows = jdbcTemplate.queryForList(sql, name);
        return rows;

    }
}
