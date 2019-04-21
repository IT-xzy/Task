/**
 * Author：老王
 * Time：2019/3/31 0:30
 **/

package cn.wp.service;

import cn.wp.dao.ContactDao;
import cn.wp.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired
    private ContactDao catDao;

    public void save(Contact cat) {
        catDao.save(cat);
    }

    public Contact getContact(int ID) {
        Contact cat = catDao.getContact(ID);
        return cat;
    }

}
