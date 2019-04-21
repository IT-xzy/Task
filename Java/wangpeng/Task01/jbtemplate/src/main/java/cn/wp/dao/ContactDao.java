/**
 * Author：老王
 * Time：2019/3/28 12:54
 **/

package cn.wp.dao;

import cn.wp.po.Contact;

import java.sql.SQLException;
import java.util.List;

public interface ContactDao {
    //    增
    void add(Contact contact) throws SQLException;

    //    删
    void remove(int ID) throws SQLException;

    //    改
    void update(Contact contact) throws SQLException;

    //    查
    List<Contact> findAll() throws SQLException;

}
