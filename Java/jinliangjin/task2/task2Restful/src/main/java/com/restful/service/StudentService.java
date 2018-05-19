package com.restful.service;

import com.restful.dao.IStudentDao;
import com.restful.dao.StudentServiceDao;
import com.restful.pojo.Student;
import com.restful.util.NumberPlaceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: task2Restful
 * @Package: com.restful.service
 * @ClassName: StudentService
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/17 14:31
 * @UpdateUser:
 * @UpdateDate: 2018/5/17 14:31
 * @UpdateRemark:
 * @Version: 1.0
 */
@Service
public class StudentService implements StudentServiceDao{
    @Autowired
    IStudentDao iStudentDao;
    /**
     * @Description: Batch insert one Student by i times.
     * * @param i
     * @return: java.lang.Boolean
     * @since: 1.0.0
     * @Date: 2018/5/9 21:16
     */
    @Override
    public Boolean insertStudents(int i) {

        Boolean insert = false;
        Long startTime = System.currentTimeMillis();
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setName("刘军健");
        student.setSex("男");
        student.setQq(3631017L);
        student.setWhatType("Java工程师");
        student.setJoinTime(20180415L);
        student.setSchool("哈尔滨工业大学");
        student.setStudent_id("java-3651");
        student.setLink("http://www.jnshu.com/daily/54889?dailyType=others&total=7&page=1&uid=23102&sort=0&orderBy=3");
        student.setWishes("从入门到到放弃，你确定要放弃吗？");
        student.setTutorBro("JAVA-杨以杰");
        student.setKnowFrom("知乎");
        student.setCreate_at(System.currentTimeMillis());
        student.setUpdate_at(System.currentTimeMillis());

        for (int x = 0; x <= i; x++) {
            students.add(student);
            if (x % 2000 == 0 && x != 0) {
                iStudentDao.addStudentList(students);
                students.clear();
                Long endTime = System.currentTimeMillis();
                System.out.println("\r\n第" + (x / 2000) + "次插入2000条数据费时：\r\n" +
                        (double) (endTime - startTime) / 1000 + "秒\r\n");
                startTime = System.currentTimeMillis();
            }
            if (i == x && students.size() > 0) {

                iStudentDao.addStudentList(students);
                students.clear();
                Long endTime = System.currentTimeMillis();
                System.out.println("\r\n插入最后的" + (i % 2000) + "条数据费时：\r\n" +
                        (double) (endTime - startTime) / 1000 + "秒\r\n");
                startTime = System.currentTimeMillis();
            }
        }
        insert = true;
        return insert;
    }
    /**
     * @Description: Delete one Student or Customers by (int)ids and/or (Long) tels.
     * * @param numbers
     * @return: java.lang.Boolean
     * @since: 1.0.0
     * @Date: 2018/5/9 21:19
     */
    @Override
    public Boolean deleteByNumber(Object... numbers) {
        Boolean flag = false;
        if (numbers != null) {
            Integer[] ids = new Integer[numbers.length + 1];
            Long[] qq = new Long[numbers.length + 1];
            for (int x = 0; x < numbers.length; x++) {
                //id
                if (numbers[x] instanceof Integer) {
                    //0 <int id <10 million
                    if((Integer)numbers[x] >0 && NumberPlaceUtil.IntTakePlace((Integer)numbers[x]) <6){
                        ids[x] = (Integer) numbers[x];
                    } else
                        System.out.println("请输入正确的id！");
                }
                //tel
                if (numbers[x] instanceof Long) {
                    //long tel must >0 and being 11 digits
                    if((Long)numbers[x] >0 && NumberPlaceUtil.LongTakePlace((Long)numbers[x])==11){
                        qq[x] = (Long) numbers[x];
                    }else
                        System.out.println("请输入正确的电话号码！");
                }
                continue;
            }
            iStudentDao.deleteById(ids);
            iStudentDao.deleteByQq(qq);
            flag = true;
        } else {
            System.out.println("输入不能为空");
        }
        return flag;
    }
    /**
     * @Description: Batch update customers by list.
     * * @param customers
     * @return: java.lang.String
     * @since: 1.0.0
     * @Date: 2018/5/9 21:37
     */
/*    @Override
    public String update(List<Student> students) {

        String str = "更新成功！";
        if (students != null) {
            iStudentDao.updateStudents(students);
            System.out.println(str);
            return str;
        } else {
            str = "更新失败！";
            System.out.println(str);
        }
        return str;
    }*/
    /**
     * @Description: Batch update address where id in an array which type is int.
     * * @param address
     * @param knowFrom
     * @param id
     * @return: void
     * @since: 1.0.0
     * @Date: 2018/5/9 21:38
     */
    @Override
    public void updateKnowFromById(String knowFrom, int... id) {

        Student student = new Student();
        student.setKnowFrom(knowFrom);
        student.setUpdate_at(System.currentTimeMillis());

        for (int x = 0; x < id.length; x++) {
            student.setId(id[x]);
            iStudentDao.updateOne(student);
        }
    }

    /**
     * @Description: Select one customer by id or qq or String
     * * @param o
     * @return: java.util.List<com.company.pojo.Student>
     * @since: 1.0.0
     * @Date: 2018/5/8 11:35
     */
    @Override
    public List<Student> selectByNumberOrString(Object o) {
        List<Student> students = new ArrayList<>();
        if (o instanceof Integer) {
            //判断Integer o 的位数
            int x = NumberPlaceUtil.IntTakePlace((Integer) o);
            if ((Integer) o > 0 && x < 7) {
                if(iStudentDao.getOneById((Integer) o) == null){
                    return null;
                } else {
                    students.add(iStudentDao.getOneById((Integer) o));
                    return students;
                }

            } else {
                System.out.println("请输入正确的id。");

            }
        } else if (o instanceof Long) {
            int x = NumberPlaceUtil.LongTakePlace((Long) o);
            if (x > 5 && x < 12) {

                if(iStudentDao.getOneByQq((Long) o) == null){
                    return null;
                } else {
                    students.add(iStudentDao.getOneByQq((Long) o));
                    return students;
                }

            } else {
                System.out.println("请输入正确的QQ号。");
            }
        } else if (o instanceof String) {
            int x = ((String) o).length();
            if (x < 4) {

                if(iStudentDao.getOneByKey((String) o) == null) {
                    return null;
                } else {
                    students.addAll(iStudentDao.getOneByKey((String) o));
                    return students;
                }

            }
        } else {
            System.out.println("请输入正确的内容！");
        }
        return null;
    }

    /**
     * @Description: Insert ont customer and show all customer's details.
     * * @param customer
     * @return: java.util.List<com.company.pojo.Student>
     * @since: 1.0.0
     * @Date: 2018/5/8 11:37
     */
    @Override
    public List<Student> insertAndSelectAll(Student student) {

        iStudentDao.addStudent(student);
        return iStudentDao.getAll();
    }

    /**
     * @Description: Select all from customer table..
     * * @param
     * @return: java.util.List<com.company.pojo.Student>
     * @since: 1.0.0
     * @Date: 2018/5/8 11:39
     */
    //查询全部
    @Override
    public List<Student> query() {
        return iStudentDao.getAll();
    }
    //更新
    @Override
    public void updateStudent(Student student){
        student.setUpdate_at(System.currentTimeMillis());
        iStudentDao.updateOne(student);
    }
    //根据id查询
    @Override
    public Student getStudentById(int id){
        return iStudentDao.getOneById(id);
    }
    //根据id删除
    @Override
    public void deleteStudent(int id){
        iStudentDao.deleteById(id);
    }
    //增加
    @Override
    public void insertStudent(Student student){
        student.setCreate_at(System.currentTimeMillis());
        student.setUpdate_at(System.currentTimeMillis());
        iStudentDao.addStudent(student);
    }
    @Override
    public List<Student> selectStu(Student student){
        return iStudentDao.select(student);
    }


    public List<Student> getByLimit(int startRow, int pageSize){
        return iStudentDao.getStudentByPage(startRow,pageSize);
    }

}
