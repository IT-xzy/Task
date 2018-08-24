package com.baidu.test;

import com.alibaba.fastjson.JSON;
import com.baidu.pojo.Student;
import com.baidu.util.RedisUtil;
import com.baidu.util.SerializeUtil;
import redis.clients.jedis.Jedis;

import java.util.List;

public class JsonDemo {
	public static void main(String[] args) {
		//将对象转换成json字符串
		Student student = new Student();
		student.setId(18);
		student.setSchool("东莞理工学员");
		student.setName("黄东江");
		String objectStr = JSON.toJSONString(student);
		System.out.println("对象序列化成json字符串型：" + objectStr);
		//将json字符串转换成对象
		String stringObj = "{\"id\":19,\"qq\":123}";
		Student student1 = JSON.parseObject(stringObj,Student.class);
		System.out.println("将字符串反序列化成对象：" + student1);

		//对象集合转换成json字符串
        Student student2 = new Student();
        student2.setId(1);
        student2.setName("zhangsan1");

        Student student3 = new Student();
		student3.setId(1);
		student3.setName("zhangsan2");

        Student student4 = new Student();
        student4.setId(1);
        student4.setName("zhangsan3");

        Student [] studentsArr = {student2,student3,student4};
        String studentsStr = JSON.toJSONString(studentsArr);
		System.out.println("studetnStr:" + studentsStr);

		List<Student> studentsList = JSON.parseArray(studentsStr,Student.class);
		for (Student s : studentsList) {
			System.out.println(s.getName());
		}
		RedisUtil redisUtil = new RedisUtil();
		Jedis jedis = redisUtil.getCon();
		jedis.set("student111".getBytes(),SerializeUtil.serialize(student2));
		byte [] s = jedis.get(("student111").getBytes());
		Student student5 =(Student)SerializeUtil.unserialize(s);
		System.out.println(student5.getName());
	}
}
