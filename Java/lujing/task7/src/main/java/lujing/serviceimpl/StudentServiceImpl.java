package lujing.serviceimpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import lujing.mapper.StudentMapper;
import lujing.mapper.StudentMapperCustom;
import lujing.pojo.Student;
import lujing.pojo.StudentCustom;
import lujing.pojo.StudentQueryVo;
import lujing.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapperCustom studentMapperCustom;
    
    @Autowired
    RedisTemplate redisTemplate;
    
    @Override
    
    public List<StudentCustom> findStudentList(StudentQueryVo studentQueryVo) {
        // TODO Auto-generated method stub
        //在缓存中查找是否存在studentlist.
        
        //如果不存在studentlist,去数据库查询数据，并写入缓存中
        if (redisTemplate.opsForHash().hasKey("student", "studentlist")) {
            List<StudentCustom> studentlist =
                    (List<StudentCustom>) redisTemplate.opsForHash().get("student", "studentlist");
            return studentlist;
            
        }
        List<StudentCustom> studentlist2 = studentMapperCustom.findStudentList(studentQueryVo);
        redisTemplate.opsForHash().put("student", "studentlist", studentlist2);
        return studentlist2;
        
    }
    
    @Autowired
    private StudentMapper studentMapper;
    
    @Override
    public StudentCustom findStudentById(Integer id) {
        //如果该id的学生不在缓存中，去数据库中查询
        if (redisTemplate.opsForHash().hasKey("student", id)) {
            
            StudentCustom studentCustom =
                    (StudentCustom) redisTemplate.opsForHash().get("student", id);
            
            return studentCustom;
        }
        Student student = studentMapper.selectByPrimaryKey(id);
        StudentCustom studentCustom1 = new StudentCustom();
        BeanUtils.copyProperties(student, studentCustom1);
        redisTemplate.opsForHash().put("student", id, studentCustom1);
     
        return studentCustom1;
    }
    
    @Override
    public void updateStudent(Integer id, StudentCustom studentCustom) {
        //判断该id在缓存中是否存在,
        
        if (redisTemplate.opsForHash().hasKey("student", id)) {
            //删除缓存中的单个学生信息
            redisTemplate.opsForHash().delete("student", id);
            //
            redisTemplate.opsForHash().delete("student", "studentlist");
            studentMapper.updateByPrimaryKeySelective(studentCustom);
        }
        studentMapper.updateByPrimaryKeySelective(studentCustom);
        
    }
    
    @Override
    public void deleteStudent(Integer id) {
        
        if (redisTemplate.opsForHash().hasKey("student", id)) {
            //删除缓存中的单个学生信息
            redisTemplate.opsForHash().delete("student", id);
            //
            redisTemplate.opsForHash().delete("student", "studentlist");
            //删除学生信息后需要删除缓存中的相应的学生信息。
            studentMapper.deleteByPrimaryKey(id);
        }
        studentMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public void addStudent(StudentCustom studentCustom) {
        // TODO Auto-generated method stub
        studentMapper.insertSelective(studentCustom);
        //增加学生信息后需要删除缓存中的相应的学生信息。
        redisTemplate.opsForHash().delete("student", "studentlist");
        
    }
    
}
