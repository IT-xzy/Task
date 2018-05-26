package com.enroll.DAO;

import com.enroll.POJO.EntryForm;

import java.util.List;

/**
 * @ProjectName: task1
 * @Package: com.enroll.DAO
 * @ClassName: IStudentDao
 * @Description: add/delete/update/select to EntryForm.
 * @Author: Jin
 * @CreateDate: 2018/4/27 13:07
 * @UpdateUser:
 * @UpdateDate: 2018/4/27 13:07
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface IStudentDao {
    void addEntryForm(List<EntryForm> list);
    void deleteById(int id);
    void deleteByName(String name);
    void update(EntryForm entryForm);
    List<EntryForm> getAll();
    EntryForm getEntryFormById(int id);
    EntryForm getEntryFormByQq(Long qq);
    List<EntryForm> getEntryFormByString(String str);
}
