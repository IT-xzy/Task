package serviceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.StudentMapper;
import memcached.MemCache;
import memcached.MemcachedCache;
import memcached.MemcachedCacheManager;
import net.rubyeye.xmemcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pojo.Student;
import service.StudentService;
import utils.Randomlist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
@Autowired
StudentMapper studentMapper;
@Autowired
MemcachedClient memcachedClient;


//    @Cacheable(value = "studentservicecache",key = "#pn")
//    @Override
//    public PageInfo page(Integer pn) {
//        PageHelper.startPage(pn,10);
//        List<Student> studentList = studentMapper.list();
//        PageInfo pageInfo = new PageInfo<>(studentList,10);
//        return pageInfo;
//    }
    public List<Student> list(){ return  studentMapper.list(); }

    @Override
    public void add(Student student) {
    studentMapper.add(student);
    }

    @Override
    public void delete(Integer id)  {
     studentMapper.delete(id);
    }

    @Cacheable(value = "studentcache",key = "#id")
    @Override
    public  Student get(Integer id) {
        return studentMapper.get(id);
    }

    @Override
    public void update(Student student)  { studentMapper.update(student); }

    @Override
    public void pinsert(List<String> list) { }


    @Override
    public int gettotal(){ return  studentMapper.gettotal();}

    @Override
    public int getjavatotal() {return studentMapper.getjavatotal();}


    @Override
    public List<Student> random() {
        List<Student> list = studentMapper.list();
        List<Student> newlist = Randomlist.createRandomList(list,4);
        return  newlist;
    }
}


