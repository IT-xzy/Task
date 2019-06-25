/**
 * Author：老王
 * Time：2019/3/31 0:29
 **/

package cn.wp.dao;

import cn.wp.entity.Contact;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface ContactDao {

    @Insert("insert into Contact (ID,Name,Email,QQ,Gender) value (#{ID},#{Name},#{Email},#{QQ},#{Gender})")
    public void save(Contact cat);

    @Select("select * from Contact where id = #{ID}")
    public Contact getContact(int ID);

}
