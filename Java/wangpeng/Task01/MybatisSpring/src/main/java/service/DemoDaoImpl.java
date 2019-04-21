/**
 * Author: 老王
 * Date: 2019/4/13 23:36
 */
package service;

import dao.DemoDao;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import pojo.Demo;

public class DemoDaoImpl extends SqlSessionDaoSupport implements DemoDao {

    @Override
    public Demo queryDemoById(int id) {

        SqlSession sqlSession =getSqlSession();

        Demo de = sqlSession.selectOne("queryDemoById", id);

        return de;
    }

    @Override
    public void add(Demo demo) {
        //获取SqlSession
        SqlSession sqlSession = getSqlSession();
        //使用SqlSession执行操作
        sqlSession.insert("add", demo);
        //不用提交，事务由spring进行管理
        //不要关闭sqlSession
    }

}
