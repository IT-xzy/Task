package com.baidu.service;

import com.baidu.dao.StudentMapper;
import com.baidu.pojo.Student;
import com.baidu.util.RedisUtil;
import com.baidu.util.SerializeUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	private static final Log log = LogFactory.getLog(StudentServiceImpl.class);
	private RedisUtil redisUtil = new RedisUtil();
	private Jedis jedis = redisUtil.getCon();

	@Resource(name = "studentMapper")
	private StudentMapper studentMapper;

	public void saveStudent(Student student) {
		//保存用户好像就没必要在缓存中也保存一份了
		studentMapper.saveStudent(student);
	}
	public void deleteStudentById(int id) {
		//删除数据库数据同时也要把缓存中的数据删掉
		studentMapper.deleteStudentById(id);
		if (jedis.get(id +"") != null) {
			//缓存中有该条记录，删掉
			jedis.del(id + "");
			log.info("从缓存中删除数据：" );
		}
		log.info("从数据库中删除了数据");
	}

	public void updateStudent(Student student) {
		//这里更新数据库的同时应该把缓存也更新了
        studentMapper.updateStudent(student);

        if (jedis.get(student.getId() + "") != null){
        	//如果缓存中存有原来的数据，那么把缓存中的数据也更新掉
        	jedis.del(student.getId() + "");
        	log.info("更新了缓存：" + student);
        	return;
		}
		log.info("缓存中没有内容，直接更新数据库。。。");
	}

	public Student findStudentById(int id) {
		Student student;
		if(jedis.get("flag" + id) != null){
			//判断是否为恶意攻击
			log.info("恶意攻击，直接返回null");
			return null;
		} else {
			//不是恶意攻击
			if (jedis.get(id + "") != null){
				//缓存中存在数据，从缓存中取
				byte [] studentByte = jedis.get((id + "").getBytes());
				student =(Student)SerializeUtil.unserialize(studentByte);
				//把字符串转换成对象
				log.info("从缓存中库中取的数据：" + student);
			}else {
				//没有数据去数据库拿
				student = studentMapper.findStudentById(id);
				log.info("从数据库中取的数据：" + student);
				if (student != null){
					jedis.set("student".getBytes(),SerializeUtil.serialize(student));
					log.info("把数据存到缓存中");
				}else {
					//数据库中没有该条数据，标志改key为恶意访问
					jedis.set("flag" + id, "flag");
					return null;
				}
			}
		}
		return student;
	}
	public List<Student> findAllStudent() {
		List<Student> studentsList;
		if (jedis.get("students") != null){
			//先从缓存中取数据
			byte [] studentsListByte = jedis.get(("students").getBytes());
			studentsList =(List<Student>)SerializeUtil.unserialize(studentsListByte);
			log.info(studentsList.size());
		}else {
			//如果缓存中没有数据，那么就去数据库中取
			studentsList = studentMapper.findAllStudent();
			if(studentsList != null){
				//转换成json字符串
				jedis.set("students".getBytes(), SerializeUtil.serialize(studentsList));
				//放到缓存中去
				log.info("存到缓存中");
				return studentsList;
			}
		}
		return studentsList;
	}
}
