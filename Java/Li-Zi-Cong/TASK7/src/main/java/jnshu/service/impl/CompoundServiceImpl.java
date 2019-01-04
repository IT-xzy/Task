package jnshu.service.impl;

import jnshu.pojo.*;
import jnshu.util.*;
import jnshu.service.CompoundService;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CompoundServiceImpl implements CompoundService {
    private Logger logger = LogManager.getLogger(CompoundServiceImpl.class);

    static boolean flag = true;
    static float index = 0;
    static float count = 0;
    static float wait = 0;

    @Autowired
    private AccountServiceImpl accountService;

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private JobServiceImpl jobService;

    @Autowired
    private StudentInfoImpl studentInfoService;


    private List<?> memcached(String key) {
        try {
            if (MemcacheUtil.get(key) != null) {
                index++;
                List<Object> object = SerializeUtil.unserializeList((byte[]) MemcacheUtil.get(key));
                System.out.println("@,:" + (int) (index / (wait + count + index) * ) + "%  :" + (int) index + " ,:" + (int) (wait + count + index));
                logger.error(":" + new Date());
                return object;
            } else if (flag == true) {
                flag = false;
                count++;
                List<Student> temp = studentService.listExcellent();
                System.out.println(":" + (count / (wait + count + index) * ) + "%  :" + (int) count);
                if (temp != null) {
                    System.out.println("");
                    MemcacheUtil.set(key, SerializeUtil.serializeList(temp));
                    flag = true;
                    return SerializeUtil.unserializeList((byte[]) MemcacheUtil.get(key));
                } else if (temp == null) {
                    System.out.println("");
                    logger.error(":" + new Date());
                    MemcacheUtil.set(key, SerializeUtil.serialize(" "));
                    return null;
                }
            } else if (flag == false) {
                wait++;
                System.out.println(":" + (int) (wait));
                Thread.sleep();
                return memcached(key);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    private List<?> redis(String key) throws Exception {
        Jedis redis = new Jedis("", );
        if (redis.exists(key.getBytes())) {
            System.out.println("");
            return SerializeUtil.unserializeList(redis.get(key.getBytes()));
        } else {
            if (flag == true) {
                flag = false;
                List<Student> list = studentService.listExcellent();
                System.out.println("");
                if (list != null) {
                    System.out.println("");
                    redis.set(key.getBytes(), SerializeUtil.serializeList(list));
                    flag = true;
                    return SerializeUtil.unserializeList(redis.get(key.getBytes()));
                } else {
                    System.out.println("");
                    redis.setex(key, , "");
                    return null;
                }
            } else if (flag == false) {
                System.out.println(":" + (++wait));
                Thread.sleep();
                return redis(key);
            }
        }
        return null;
    }


    @Override
    public List<Student> homePage() throws Exception {


        List<Student>students=(List<Student>) redis("");

        if (students == null) {
            logger.error("" + new Date());
            students = studentService.listExcellent();
        }

        int[] num = new int[];
        for (int  = 0;  < ; ++) {
            num[] = (int) (Math.random() * students.size());
            for (int  = 0;  < num.length; ++) {
                if (num[] == num[] &&  != ) {
                    num[] = (int) (Math.random() * students.size());
                     = ;
                }
            }
        }
        List<Student> studentList = new ArrayList<>();
        for (inti = 0;  < num.length; i++) {
            studentList.add(students.get(num[]));
        }
        return studentList;
    }

    @Override
    public List<Job> positionPageCon() throws Exception {
        return jobService.listJob();
    }

    @Override
    public Student jsonPage(int id) throws Exception {
        return studentService.findByStudentID(id);
    }

    @Override
    public void Register(RegisterAccount registerAccount) throws Exception {
        List<String> list = MD5.getText(registerAccount.getPassword(), null);
        registerAccount.setSalt(list.get(0));
        registerAccount.setPassword(list.get(1));
        accountService.register(registerAccount);
    }


    @Override
    public Cookie checkLogin(LoginAccount loginAccount) throws Exception {
        RegisterAccount registerAccount = accountService.checkLogin(loginAccount);
        List<String> lists = MD5.getText(loginAccount.getPassword(), registerAccount);
        if (registerAccount != null) {
            if (registerAccount.getPassword().equals(lists.get(1))) {
                System.out.println("");

                return Token.getToken(loginAccount.getAccount(), lists.get(0));
            }
        }
        return null;
    }


    /**
     */
    @Override
    public String insertStudent(StudentInfo studentInfo) throws Exception {
        try {
            if (studentInfo.getStudentName() == null) {
                return "";
            } else {
                if (studentInfoService.insertSTU(studentInfo) != null) {
                    Cache.resetIndex(studentInfoService);
                    Cache.updateKey(new String("" + studentInfo.getId().toString()), studentInfo);
                    logger.error("");
                }
            }
            return ":";
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }


    /**
     */
    @Override
    public String deleteStudentbyID(Integer id) throws Exception {
        try {
            Cache.resetIndex(studentInfoService);
            studentInfoService.deleteByID(id);
            Cache.deleteKey(new String("" + id.toString()));
            logger.error("");
            return ":";
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }


    /**
     */
    @Override
    public StudentInfo findByStudentID(Integer id, Integer pageCount) throws Exception {
        StudentInfo studentInfo = Cache.getOneKey(new String(""+id));
        studentInfo.setPageCount(pageCount);
        return studentInfo;
    }


    /**
     */
    @Override
    public List updateStudent(StudentInfo studentInfo, Integer pageCount) throws Exception {
        try {
            List list = new ArrayList();
            studentInfoService.updateByID(studentInfo);
            Cache.updateKey(new String("" + studentInfo.getId().toString()), studentInfo);
            Cache.resetIndex(studentInfoService);
            list.add(0, AddPageCount.setCount(Cache.getKeyList(pageCount), pageCount));
            list.add(0, "");
            logger.error("");
            return list;
        } catch (Exception e) {
            Cache.resetIndex(studentInfoService);
            if (studentInfoService.insertSTU(studentInfo) == null) {
            logger.error("");
            }
            Cache.updateKey(new String("" + studentInfo.getId().toString()), studentInfo);
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }


    /**
     */
    @Override
    public List listInfo(String function, Integer pageCount) throws Exception {
        List list = new ArrayList();

        /**
         */
        if (function.equals("")) {
            Cache.resetIndex(studentInfoService);
            return (List<StudentInfo>) Cache.getKeyList(0);
        }
        /**
         */
        else if (function.equals("")) {
            pageCount += 0;
            int allCount = studentInfoService.allCount();
            //余
            int remainder = allCount % pageCount;
            //商
            int quotient = allCount / pageCount;
            //差
            int difference = (pageCount + 0) - allCount;
            System.out.println(":" + pageCount);
            /**
             */
            if (difference > 0) {
                System.out.println("" + difference);
                list.add(0, AddPageCount.setCount(Cache.getKeyList(pageCount ), pageCount ));
                list.add(0, pageCount );
                list.add(0, 0);
                return list;
            }
            list.add(0, AddPageCount.setCount(Cache.getKeyList(pageCount), pageCount));
            list.add(0, pageCount);
            list.add(0, pageCount);
            return list;
        }
        /**
         */
        else if (function.equals("")) {
            if (pageCount < 0) {
                list.add(0, Cache.getKeyList(0));
                list.add(0, 0);
                list.add(0, 0);
                return list;
            }
            /**
             */
            pageCount -= 0;
            if (pageCount >= 0) {
                list.add(0, AddPageCount.setCount(Cache.getKeyList(pageCount), pageCount));
                list.add(0, pageCount);
                list.add(0, 0);
                return list;
            }
            return null;
        } else {
            return null;
        }
    }

}
