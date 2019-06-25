/**
 * Author: 老王
 * Date: 2019/4/13 22:13
 */
package cn.wp.service;

import cn.wp.dao.DemoDao;
import cn.wp.po.Demo;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

public class DemoDaoImpl implements DemoDao {

    private JdbcTemplate jTemplate;

    //增
    @Override
    public void add(Demo demo) throws SQLException {
        String sql = "insert into demo values(?,?,?,?)";
        jTemplate.update(sql, demo.getId(), demo.getName(),
                demo.getQq(), demo.getSchool());
    }

    public void setjTemplate(JdbcTemplate jTemplate) {
        this.jTemplate = jTemplate;
    }
}
