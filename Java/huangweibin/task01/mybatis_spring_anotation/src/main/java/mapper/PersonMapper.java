package mapper;

import org.springframework.stereotype.Repository;
import pojo.Person;


import java.util.List;

@Repository
public interface PersonMapper {
    //通过ID获取雇员信息
    public Person getPerson(Integer id);

    //插入雇员信息
    public void insertPerson(Person person);

    //通过ID删除相应信息
    public void  deletePerson(Integer id);

    //通过名字来更新信息
    public void  updateEmp(Person person);

    //查看所有信息
    public List<Person> findAllUser();

}
