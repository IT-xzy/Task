/**
 * Author：老王
 * Time：2019/3/31 1:57
 **/

package cn.wp.service;

import cn.wp.entity.Contact;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    /**
     * sqlSessionTemplate模板提供了sqlsession
     */

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public void save(Contact cat) {
        sqlSessionTemplate.insert("cn.wp.dao.ContactDao.save", cat);
    }

    public Contact getContact(int ID) {
        Contact cat = sqlSessionTemplate.selectOne("cn.wp.dao.ContactDao.getContact", ID);
        return cat;
    }

}
