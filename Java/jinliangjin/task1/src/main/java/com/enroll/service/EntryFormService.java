package com.enroll.service;

import com.enroll.DAO.IStudentDao;
import com.enroll.POJO.EntryForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: task1
 * @Package: com.enroll.service
 * @ClassName: EntryFormService
 * @Description: There're four methods, which are invoking a few of the eight basic insert_delete_update_select
 * methods,include updateAndSelectAll()/insertAndSelectALL()/getEntryForm()/deleteEntryForm(), to operate the entryform
 * table of the task1 database, and there is brief information before beginning each method.
 * @Author: Jin
 * @CreateDate: 2018/4/27 15:34
 * @UpdateUser:
 * @UpdateDate: 2018/4/27 15:34
 * @UpdateRemark:
 * @Version: 1.0
 */
@Transactional
@Service("entryFormService")
public class EntryFormService {

    @Autowired
    private IStudentDao iStudentDao;
    EntryForm entryForm = new EntryForm();
//    Logger logger = (Logger) LoggerFactory.getLogger(getClass());

    /**
     * @Description: Update the entryform table and return one list of this table.
     * 〈〉
     * * @param e
     * @return: java.util.List<com.enroll.POJO.EntryForm>
     * @since: 1.0.0
     * @Date: 2018/4/28 16:22
     */
    public List<EntryForm> updateAndSelectAll(EntryForm e) {

        entryForm.setId(e.getId());
        entryForm.setName(e.getName());
        entryForm.setSex(e.getSex());
        entryForm.setQq(e.getQq());
        entryForm.setWhatType(e.getWhatType());
        entryForm.setJoinTime(e.getJoinTime());
        entryForm.setLink(e.getLink());
        entryForm.setWishes(e.getWishes());
        entryForm.setTutorBro(e.getTutorBro());
        entryForm.setKnowFrom(e.getKnowFrom());
        iStudentDao.update(entryForm);
        return iStudentDao.getAll();
    }

    /**
     * @Description: Insert i time(s) EntryForm to the entryform table and return the size of this table.
     * 〈〉
     * * @param i
     * @return: java.util.List<com.enroll.POJO.EntryForm>
     * @since: 1.0.0
     * @Date: 2018/4/28 16:08
     */
    public Boolean batchInsert(int i) {
        Boolean insert = false;
        Long startTime = System.currentTimeMillis();
        List<EntryForm> entryForms = new ArrayList<EntryForm>();
        EntryForm entryForm = new EntryForm();
        entryForm.setName("刘军健");
        entryForm.setSex("男");
        entryForm.setQq(3631017);
        entryForm.setWhatType("Java工程师");
        entryForm.setJoinTime(20180415L);
        entryForm.setSchool("哈尔滨工业大学");
        entryForm.setStudent_id("java-3651");
        entryForm.setLink("http://www.jnshu.com/daily/54889?dailyType=others&total=7&page=1&uid=23102&sort=0&orderBy=3");
        entryForm.setWishes("从入门到到放弃，你确定要放弃吗？");
        entryForm.setTutorBro("JAVA-杨以杰");
        entryForm.setKnowFrom("知乎");

        for (int x = 0; x <= i; x++) {
            entryForms.add(entryForm);
            if (x % 2000 == 0 && x != 0) {
                iStudentDao.addEntryForm(entryForms);
                entryForms.clear();
                Long endTime = System.currentTimeMillis();
                System.out.println("\r\n第" + (x / 2000) + "次插入2000条数据费时：\r\n" +
                        (double) (endTime - startTime) / 1000 + "秒\r\n");
                startTime = System.currentTimeMillis();
            }
            if (i == x && entryForms.size() > 0) {

                iStudentDao.addEntryForm(entryForms);
                entryForms.clear();
                Long endTime = System.currentTimeMillis();
                System.out.println("\r\n插入最后的" + (i % 2000) + "条数据费时：\r\n" +
                        (double) (endTime - startTime) / 1000 + "秒\r\n");
                startTime = System.currentTimeMillis();
            }
        }
/*        Long selectSizeStart = System.currentTimeMillis();
        System.out.println("查询size开始于：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(selectSizeStart)));
        System.out.println("表entryform中有" + iStudentDao.getAll().size() + "条数据");
        Long selectSizeEnd = System.currentTimeMillis();
        System.out.println("查询size结束于：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(selectSizeEnd))
                + "\n用时：" + (double) (selectSizeEnd - selectSizeStart) / 1000 + "秒");*/

        insert = true;
        return insert;

/*        EntryForm entryForm = new EntryForm("刘军健", "男", 3631017, "Java工程师",
                20180415L, "哈尔滨工业大学", "java-3651",
                "http://www.jnshu.com/daily/54889?dailyType=others&total=7&page=1&uid=23102&sort=0&orderBy=3",
                "从入门到到放弃，你确定要放弃吗？", "JAVA-杨以杰", "知乎");
        for (Long x = 0L; x < i; x++) {
            iStudentDao.addEntryForm(entryForm);
        }
        return iStudentDao.getAll();*/
    }

    /**
     * @Description: Select an EntryForm(list) from the entryform table by an Object that type include Integer or
     * Long or String but nothing else.
     * 〈〉
     * * @param o
     * @return: java.util.List<com.enroll.POJO.EntryForm>
     * @since: 1.0.0
     * @Date: 2018/4/28 20:01
     */
    public List<EntryForm> getEntryForm(Object o) {

        List<EntryForm> list = new ArrayList<EntryForm>();
        if (o instanceof Integer) {
            if ((Integer) o <= 0 && (Integer) o >= 2000000) {
                System.out.println("请输入正确的学号！");
            } else if ((Integer) o > 0 && (Integer) o < 2000000) {
                list.add(iStudentDao.getEntryFormById((Integer) o));
            }
        } else if (o instanceof Long) {
            if ((Long) o <= 2000000L) {
                System.out.println("请输入正确的qq号！");
            } else if ((Long) o > 2000000L) {
                list.add(iStudentDao.getEntryFormByQq((Long) o));
            }
        } else if (o instanceof String) {
            list = iStudentDao.getEntryFormByString((String) o);
        } else {
            System.out.println("输入错误或者没有查询到相关信息。");
        }
        return list;
    }

    /**
     * @Description: Delete from entryform table by Object(s) which include int id(s) and String name(s) but
     * nothing else and return a list about what information being deleted.
     * 〈〉
     * * @param objects
     * @return: java.util.List<com.enroll.POJO.EntryForm>
     * @since: 1.0.0
     * @Date: 2018/4/28 22:14
     */
    public List<EntryForm> deleteEntryForm(Object... objects) {
        List<EntryForm> list = new ArrayList<EntryForm>();
        try {
            for (int x = 0; x < objects.length; x++) {
                if (objects[x] instanceof Integer && objects[x] != null) {
                    list.addAll(this.getEntryForm(objects[x]));
                    iStudentDao.deleteById((Integer) objects[x]);
                } else if (objects[x] instanceof String && objects[x] != null) {
                    list.addAll(this.getEntryForm(objects[x]));
                    iStudentDao.deleteByName((String) objects[x]);
                } else {
                    System.out.println("输入错误或未查询到相关信息。");
                }
            }
            System.out.println("以下信息被删除：" + list);
            return list;
        } catch (Exception e) {
            System.out.println("删除数据出错，请检查数据库连接。");
        }
        return null;
    }
}
