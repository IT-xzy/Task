package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Student;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public StudentService() {
    }

    public int add(Student student) {
        this.studentMapper.add(student);
        return student.getAge();
    }

    public String delete(int id) {
        try {
            this.studentMapper.delete(id);
            return "True";
        } catch (Exception var3) {
            return "False";
        }
    }

    public String get(int id) {
        try {
            Student student = this.studentMapper.get(id);
            return "ID为" + student.getId() + "   姓名为" + student.getName() + "   QQ号为" + student.getAge();
        } catch (Exception var3) {
            return "查无此人";
        }
    }

    public String update(Student student) {
        try {
            this.studentMapper.update(student);
            return "True";
        } catch (Exception var3) {
            return "False";
        }
    }

    public String pinsert(List<String> list) {
        SimpleDateFormat bf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.studentMapper.pinsert(list);
        SimpleDateFormat af = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "插入前的时间为:" + af.format(new Date()) + "     插入后的时间为:" + bf.format(new Date());
    }
}
