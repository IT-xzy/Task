/**
 * Author：老王
 * Time：2019/3/29 23:08
 **/

package service;

import dao.ContactDao;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import pojo.Contact;

import java.util.List;

public class ContactDaoImpl extends SqlSessionDaoSupport implements ContactDao {

    @Override
    public Contact queryContactById(int ID) {
        //获取SqlSession
        SqlSession sqlSession =getSqlSession();
        //使用SqlSession执行操作
        Contact cat = sqlSession.selectOne("queryContactById", ID);
        //不关闭sqlSession
        return cat;
    }

    public List<Contact> queryContactByName(String name) {
        //获取SqlSession
        SqlSession sqlSession = getSqlSession();
        //使用SqlSession执行操作
        List<Contact> cat = sqlSession.selectList("queryContactByName", "name");
        //不关闭sqlSession
        return cat;
    }

    @Override
    public void addContact(Contact cat) {
        //获取SqlSession
        SqlSession sqlSession = getSqlSession();
        //使用SqlSession执行操作
        sqlSession.insert("addContact", cat);
        //不用提交，事务由spring进行管理
        //不要关闭sqlSession
    }

    @Override
    public void changeContact(Contact cat) {
        //获取SqlSession
        SqlSession sqlSession = getSqlSession();
        //使用SqlSession执行操作
        sqlSession.update("changeContact", cat);
        //不用提交，事务由spring进行管理
        //不要关闭sqlSession
    }

    @Override
    public void deleteContactById(int ID) {
        //获取SqlSession
        SqlSession sqlSession = super.getSqlSession();
        //使用SqlSession执行操作
        sqlSession.delete("deleteContactById", ID);
        //不用提交，事务由spring进行管理
        //不要关闭sqlSession
    }
}
