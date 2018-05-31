package task2.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import task2.mapper.StudentMapper;
import task2.pojo.Student;
import task2.util.Page;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {


    //引入spring的配置文件获取上下文
    private static ApplicationContext context =new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    //通过上下文和bean的名字获取userMapper实例
    private static StudentMapper studentMapper=context.getBean(StudentMapper.class);
//    @Autowired
//    private static UserMapper userMapper;

    @Override
    public int add(Student student) throws Exception {
        try{
            student.setCreate_at(System.currentTimeMillis());
            student.setUpdate_at(System.currentTimeMillis());
            studentMapper.add(student);
            return student.getid();}
        catch (DuplicateKeyException e){
            //插入学员时可能发生的异常
            throw new DuplicateKeyException("Insert failed ,id exists.");
        }

    }      //System.out.println(studentDao);//NullPointerException,userMapper确实是null
    //必须在所有使用dao的地方，包括调用它的service都要进行@Autowired注入，否则之后的注入就会失败
    //不用注解了，直接读取配置文件，getBean
    //System.out.println(studentDao);




    @Override
    public boolean delete(int id) {
        return studentMapper.delete(id);
    }

    @Override
    public Student findById(int id) {
        return studentMapper.findById(id);
    }

    @Override
    public List<Student> findByName(String stu_name) throws Exception {
        return studentMapper.findByName(stu_name);
    }

    @Override
    public boolean update(Student student) throws Exception {
        student.setUpdate_at(System.currentTimeMillis());
        return studentMapper.update(student);
    }

    @Override
    public void reset() throws Exception {
        studentMapper.reset();
    }
    public List<Student> list(){
        return studentMapper.list();
    };

//    @Override
//    public List<student> list(Page page) {
//        // TODO Auto-generated method stub
//        return userMapper.list(page);
//    }
//
//    @Override
//    public int total() {
//        return userMapper.total();
//    }
}