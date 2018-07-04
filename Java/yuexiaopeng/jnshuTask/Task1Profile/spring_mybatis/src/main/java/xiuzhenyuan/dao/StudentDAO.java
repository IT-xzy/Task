package xiuzhenyuan.dao;

import xiuzhenyuan.bean.Student;

import java.util.List;

public interface StudentDAO {
    void doDelete(String study_id);
    void doInsert(Student student);
    void doUpdate(Student student);
    List<Student> doSelectByStudy_id(String study_id);
    List<Student> doSelectAll();
}
