package com.baidu.service;

import com.baidu.dao.StudentMapper;
import com.baidu.pojo.Student;
import com.baidu.util.MemcachedUtil;
import com.baidu.util.SerializeUtil;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	private static final Log log = LogFactory.getLog(StudentServiceImpl.class);
    private static MemcachedClient memcachedClient = MemcachedUtil.getMemcachedClient();
	@Resource(name = "studentMapper")
	private StudentMapper studentMapper;
	
	public void saveStudent(Student student) {
		//保存用户好像就么必要在缓存中也保存一份了
		studentMapper.saveStudent(student);
	}

	public void deleteStudentById(int id) throws Exception{
		//删除数据库数据同时也要把缓存中的数据删掉
		if (memcachedClient.get("student") != null) {
			//缓存中有该条记录，删掉
			memcachedClient.delete("student");
			log.info("从缓存中删除数据：" );
		}
		studentMapper.deleteStudentById(id);
		log.info("从数据库中删除了数据");
	}

	public void updateStudent(Student student) throws Exception{
		//这里更新数据库的同时应该把缓存也更新了
        studentMapper.updateStudent(student);
        if (memcachedClient.get("student") != null){
        	//如果缓存中存有原来的数据，那么把缓存中的数据也更新掉
        	memcachedClient.delete("student");
        	log.info("更新了缓存：" + student);
        	return;
		}
		log.info("缓存中没有内容，直接更新数据库。。。");
	}

	public Student findStudentById(int id) throws Exception {
		Student student;
		if(memcachedClient.get("flag" + id) != null){
			//判断是否为恶意攻击
			log.info("恶意攻击，直接返回null");
			return null;
		} else {
			//不是恶意攻击
			if (memcachedClient.get("student") != null){
				//缓存中存在数据，从缓存中取
				student = memcachedClient.get("student");
				log.info("从缓存中库中取的数据：" + student);
			}else {
				//没有数据去数据库拿
				student = studentMapper.findStudentById(id);
				log.info("从数据库中取的数据：" + student);
				if (student != null){
					//数据库中有该数数据
					memcachedClient.set("student", 3600, student);
					log.info("把数据存到缓存中");
				}else {
					//数据库中没有该条数据，标志改key为恶意访问
					memcachedClient.set("flag" + id, 3600,"flag");
					return null;
				}
			}
		}
		return student;
	}
	public List<Student> findAllStudent() throws InterruptedException, MemcachedException, TimeoutException {
		List<Student> studentsList;
		if (memcachedClient.get("students") != null){
			studentsList = memcachedClient.get("students");
			log.info("从缓存中取出数据，长度为：" + studentsList.size());
		}else {
			//如果缓存中没有数据，那么就去数据库中取
			studentsList = studentMapper.findAllStudent();
			if(studentsList != null){
				//放到缓存中去
				memcachedClient.set("students", 3600, studentsList);
				log.info("将查询到的所有学生信息放到缓存中，一共有" + studentsList.size() + "位学生信息");
				return studentsList;
			}
		}
		return studentsList;
	}
}
