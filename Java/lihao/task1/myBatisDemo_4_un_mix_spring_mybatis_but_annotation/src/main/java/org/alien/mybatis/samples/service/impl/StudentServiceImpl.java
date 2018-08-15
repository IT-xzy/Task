package org.alien.mybatis.samples.service.impl;

import org.alien.mybatis.samples.mapper.StudentMapper;
import org.alien.mybatis.samples.model.Student;
import org.alien.mybatis.samples.service.StudentService;
import org.alien.mybatis.samples.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author lihoo
 * @Title: StudentServiceImpl
 * @ProjectName myBatisDemo_4
 * @Description: TODO
 * @date 2018/7/1214:40
 */


public class StudentServiceImpl implements StudentService {


    /**
     * Add student info.
     *
     * @param student student instance
     * @return The key of current record in database;
     */
    @Override
    public int addStudent(Student student) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            int studentId = studentMapper.addStudent(student);

//            System.out.println(studentId);


            sqlSession.commit();
            return studentId;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * Delete student info by student's id.
     *
     * @param studentId student id
     * @return int The number of rows affected by the delete.
     */

    public int deleteStudent(int studentId) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            int rs = studentMapper.deleteStudent(studentId);
            sqlSession.commit();
            return rs;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    /**
     * update student info
     *
     * @param student Student instance
     * @return int The number of rows affected by the update.
     */
    public int updateStudent(Student student) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            int rs = studentMapper.updateStudent(student);
            sqlSession.commit();
            return rs;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * Query student by id.
     *
     * @param id student id
     * @return int The number of rows affected by the query.
     */

    @Override
    public Student getStudentById(int id) {
        SqlSession sqlSession =null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

            return studentMapper.getStudentById(id);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * Query student by name.
     *
     * @param username student name
     * @return String The number of rows affected by the query.
     */

    @Override
    public Student getStudentByName(String username) {
        SqlSession sqlSession = null;

        try {
            sqlSession = MybatisUtil.getSqlSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

            return studentMapper.getStudentByName(username);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }






}
