package com.mybatis.DAO.impl;

import com.mybatis.DAO.IStudentDAO;
import com.mybatis.bean.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @author Arike
 * Create_at  2017/11/20 9:38
 *                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                            O\ = /O
//                        ____/`---'\____
//                      .   ' \\| |// `.
//                       / \\||| : |||// \
//                     / _||||| -:- |||||- \
//                       | | \\\ - /// | |
//                     | \_| ''\---/'' | |
//                      \ .-\__ `-` ___/-. /
//                   ___`. .' /--.--\ `. . __
//                ."" '< `.___\_<|>_/___.' >'"".
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |
//                 \ \ `-. \_ __\ /__ _/ .-` / /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//
//         .............................................
//                  佛祖保佑             永无BUG
//          佛曰:
//                  写字楼里写字间，写字间里程序员；
//                  程序人员写程序，又拿程序换酒钱。
//                  酒醒只在网上坐，酒醉还来网下眠；
//                  酒醉酒醒日复日，网上网下年复年。
//                  但愿老死电脑间，不愿鞠躬老板前；
//                  奔驰宝马贵者趣，公交自行程序员。
//                  别人笑我忒疯癫，我笑自己命太贱；
//                  不见满街漂亮妹，哪个归得程序员？
*/

public class StudentDAOImp implements IStudentDAO {
    
    //声明SQL语句工厂对象
   private SqlSessionFactory sqlSessionFactory ;
    //声明reader
    private Reader reader ;
    private SqlSessionFactory getSqlSessionFactory() {
       
        String resource = "MyBaitsConfig.xml";
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
        
    }
    
    
    //增加
    public  void insertStudent(Student student) {
        SqlSession sqlsession = getSqlSessionFactory().openSession(true);
        sqlsession.insert("daomapper.insertStudent", student);
        //sqlsession.commit();
        sqlsession.close();
        System.out.println("本次数据ID为" + student.getId());
    }
    
    //通过名称模糊查询
    public void selectAll(String name) {
        SqlSession sqlsession = getSqlSessionFactory().openSession();
        List<Student> list = sqlsession.selectList("daomapper.getStudentByName", name);
        System.out.println(list);
        sqlsession.close();
    }
    
    //更新
    public void updateStudent(Student student) {
        SqlSession sqlsession = getSqlSessionFactory().openSession();
        sqlsession.update("daomapper.updateStudent", student);
        sqlsession.commit();
        sqlsession.close();
        System.out.println("update成功!");
    }
    
    //删除
    public void deleteStudent(long id) {
        SqlSession sqlsession = getSqlSessionFactory().openSession();
        sqlsession.delete("daomapper.deleteStudent", id);
        sqlsession.commit();
        sqlsession.close();
        System.out.println("delete成功!");
    }
    
    //根据ID查找
    public void selectOne(long id) {
        SqlSession sqlsession = getSqlSessionFactory().openSession();
        Student s = sqlsession.selectOne("daomapper.getStudentById", id);
        System.out.println(s);
        sqlsession.close();
    }
    

}

