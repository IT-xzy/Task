package dao;

import modul.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonDao {

    public Person getPerson(int id);

//  public Person insertPerson(String name,String emp, double salary);
    public void insertPerson(Person person);

    public void  deletePerson(int id);

    public void  updateEmp(String name);

    public List<Person> findAllUser();

}
