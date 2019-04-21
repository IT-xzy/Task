/**
 * Author: 老王
 * Date: 2019/4/6 23:34
 */
package cn.wp.dao;

import cn.wp.entity.Contact;

import java.util.List;

public interface ContactDao {

    Contact findById (int ID);

    boolean add (Contact cat);

    int delete(int ID);

    boolean update(Contact cat);

    List<Contact> findAll();

}


