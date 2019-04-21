/**
 * Author：老王
 * Time：2019/3/29 23:03
 **/

package dao;

import pojo.Contact;

public interface ContactDao {

    Contact queryContactById(int ID);

//    List<Contact> queryContactByName(String name);

    void addContact(Contact cat);

    void changeContact(Contact cat);

    void deleteContactById(int ID);
}
