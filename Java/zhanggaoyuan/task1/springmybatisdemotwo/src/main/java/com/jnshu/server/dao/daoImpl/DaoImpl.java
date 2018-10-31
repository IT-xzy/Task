package com.jnshu.server.dao.daoImpl;

import com.jnshu.server.dao.StudentsDao;
import com.jnshu.server.po.Students;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.List;

public class DaoImpl  implements StudentsDao {
    public SqlSessionTemplate sqlSession;
    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;}
    @Override
    public long insertStudents(Students students) {
        return (long)sqlSession.insert ("com.jnshu.server.dao.StudentsDao.insertStudents",students );
    }
    @Override
    public int deleteStudents(long id) {
        return (int)sqlSession.delete ("com.jnshu.server.dao.StudentsDao.deleteStudents", id);
    }
    @Override
    public int updateStudents(Students students) {
        return(int) sqlSession.update ("com.jnshu.server.dao.StudentsDao.updateStudents", students);
    }
    @Override
    public int updateOne(Students students) {
        return (int)sqlSession.update ("com.jnshu.server.dao.StudentsDao.updateOne", students);
    }
    @Override
    public Students selectStudents(long id) {
        return (Students)sqlSession.selectOne ("com.jnshu.server.dao.StudentsDao.selectStudents", id);
    }
    @Override
    public List selectIf(Students students) {
        return (List) sqlSession.selectList ("com.jnshu.server.dao.StudentsDao.selectIf", students);
    }
    @Override
    public long insertBatch(Students[] students) {
        return (long) sqlSession.insert ("com.jnshu.server.dao.StudentsDao.insertBatch", students);
    }
}
