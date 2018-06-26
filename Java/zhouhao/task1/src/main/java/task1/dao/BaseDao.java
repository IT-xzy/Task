package task1.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: Zhou Hao
 * @Date: 2018/5/19 20:07
 * @Description: DAO对象基础类,继承SqlSessionDaoSupport，
 *               含有SqlSessionFactory和SqlSessionTemplate
 * @Modify:
 */
public abstract class BaseDao extends SqlSessionDaoSupport {

    @Override
    @Autowired//覆盖方法以添加注解
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }
}
