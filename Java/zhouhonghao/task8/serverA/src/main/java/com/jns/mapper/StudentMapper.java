package com.jns.mapper;


import com.jns.entity.Student;

import java.util.HashMap;
import java.util.List;

public interface StudentMapper {
    //接受返回值，对应xml文件中的sql语句
    //方法名与对应的xml文件中id保持一致

    //添加数据 类型为student类
    int add(Student student);

    //根据id删除数据
    void delete(int id);

    //根据id，搜索这个学生的所有数据，用student类接受返回值
    Student get(int id);

    //更新，类型为什么是student类，而不是 int id。
    //这里返回的是int类型，若是参数类型为int id，则其他修改的数据获取不到，不会保存。
    int update(Student student);

    //这个就可以，返回类型为student类。
    //Student student update（int id）;

    //接受所有student的数据
    List<Student> list();

    //分页查询
    List<Student> findByPage(HashMap<String, Object> map);

    //所有记录数量
    int total();
}
