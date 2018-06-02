package mybatis.mapper;

import mybatis.model.Person;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
/*
*
* Mapper类
*
* 操作pserson表
*
* */
@Component
public interface PersonMapper {

//    查询所有数据 禁用
//    @Select("SELECT * FROM person")
    public List<Person> findAll();

//    根据id查询
//    @Select(" SELECT * FROM person WHERE id = #{id}")
//    @ResultMap("personMap")
    Person selectById(@Param("id") int id);

//    根据参数查询 名字/学号
//    @ResultMap("personMap")
//    public List<Person> selectByColumn(String name,int stu_num);
//    public List<Person> selectByColumn(Person person);
    public List<Person> selectByColumn(@Param("name") String name,@Param("stu_num") int stu_num);

//    根据对象属性传值查询
    public List<Person> selectByPerson(Person person);

//    修改
//    @Update("Update person SET name=#{name},age=#{age},sex=#{sex},tell=#{tell},qq=#{qq},email=#{email},pro=#{pro},stu_num=#{stu_num},waikey=#{waikey} WHERE id=#{id}")
    int updatePerson(Person person);

//    删除
//    @Delete("DELETE FROM person WHERE id = #{id}")
    int deletePerson(int id);

//     插入
//    @Insert("INSERT INTO person (id,create_at,update_at,name,age,sex,pro,tell,qq,email,stu_num,waikey) values (#{id},#{create_at},#{update_at},#{name},#{age},#{sex},#{pro},#{tell},#{qq},#{email},#{stu_num},#{waikey})")
    int insertPerson(Person person);

//    创建 = 插入
//    @Insert("INSERT INTO person (id,create_at,update_at,name,age,sex,pro,tell,qq,email,stu_num,waikey) values (#{id},#{create_at},#{update_at},#{name},#{age},#{sex},#{pro},#{tell},#{qq},#{email},#{stu_num},#{waikey})")
    void createPerson(Person person);

//    批量插入
    int insertPersonList(List<Person> list);




}
