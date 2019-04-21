/**
 * Author: 老王
 * Date: 2019/4/13 22:13
 */
package cn.wp.dao;

import cn.wp.po.Demo;

import java.sql.SQLException;

public interface DemoDao {
    //    增
    void add(Demo demo) throws SQLException;
}
