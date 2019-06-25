/**
 * Author：老王
 * Time：2019/3/31 1:56
 **/

package cn.wp.dao;

import cn.wp.entity.Contact;

public interface  ContactDao {
    public void save(Contact cat);
    public Contact getContact(int ID);
}
