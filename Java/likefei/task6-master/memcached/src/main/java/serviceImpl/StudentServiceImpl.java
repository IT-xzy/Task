package serviceImpl;
import mapper.StudentMapper;
import memcached.CacheManager;
import net.rubyeye.xmemcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Student;
import service.StudentService;
import utils.Randomlist;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {
@Autowired
private StudentMapper studentMapper;
@Autowired
private CacheManager cacheManager;

    public List<Student> list(){
        List<Student> studentlist;
        if ((studentlist=cacheManager.get("studentlist"))!=null) {
            return studentlist;
        }
        else {
            studentlist = studentMapper.list();
            cacheManager.add("studentlist",studentlist);
            return studentlist;
        }
    }

    @Override
    public void add(Student student) {
        studentMapper.add(student);;
        cacheManager.delete("stotal");
        cacheManager.delete("studentlist");
    }

     @Override
    public void delete(Integer id)  {
        String str=id+"";
        studentMapper.delete(id);
        cacheManager.delete(str);
    }

    @Override
    public Student get (Integer id){
        Student student;
        String str=id+"";
        if((student=cacheManager.get(str))!=null)
            return student;
        else {
            student = studentMapper.get(id);
            cacheManager.add(str,student);
            return student;
        }
    }

    @Override
    public void update(Student student)  {
        String str = student.getId()+"";
        studentMapper.update(student);
        cacheManager.delete(str);
    }

    @Override
    public void pinsert(List<String> list) {}

    @Override
    public Integer gettotal(){
        Integer stotal;
        if ((stotal=cacheManager.get("stotal"))!=null)
        {
            return stotal;
        }
        else {
            stotal = studentMapper.gettotal();
            cacheManager.add("stotal",stotal);
            return stotal;
        }
    }

    @Override
    public int getjavatotal() {
        return studentMapper.getjavatotal();}


    @Override
    public List<Student> random() {
        List<Student> list = studentMapper.list();
        List<Student> newlist = Randomlist.createRandomList(list,4);
        return  newlist;
    }
}


