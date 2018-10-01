import modul.Person;
import dao.PersonDao;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestDemo {
    private static final Log log= LogFactory.getLog(TestDemo.class);
    //根据ID获取相应的信息
    @Test
    public void getPersonTest(){
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext ( "applicationContext.xml" );
        PersonDao personDao = (PersonDao) ctx.getBean("personDao");
        Person person = personDao.getPerson(1);
        System.out.println(person);
    }

    //插入相应的数据
    @Test
    public void insertPersonTest(){
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext ( "applicationContext.xml" );
        PersonDao personDao  = (PersonDao) ctx.getBean ( "personDao" );
//        System.out.println ("-------");
        Person person=new Person ();
        person.setEmp ( "保安" );
        person.setName ( "dfd" );
        person.setSalary ( 12.21 );
        personDao.insertPerson (person);
        System.out.println ("insert Person Successfully" );
    }

    //根据ID删除相应的信息
    @Test
    public void deletePersonTest(){
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext ( "applicationContext.xml" );
        PersonDao personDao  = (PersonDao) ctx.getBean ( "personDao" );
         personDao.deletePerson ( 3 );
        System.out.println ("delete Person Successfully" );
    }


    //根据姓名改写相应的信息
    @Test
    public void updateEmpTest(){
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext ( "applicationContext.xml" );
        PersonDao personDao  = (PersonDao) ctx.getBean ( "personDao" );
        personDao.updateEmp ( "CC" );
        System.out.println ("update Person Successfully" );
    }


    //获取数据空中的所有信息
    @Test
    public void findAllByIdTest(){
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext ( "applicationContext.xml" );
        PersonDao personDao  = (PersonDao) ctx.getBean ( "personDao" );
//        List<Person> findAllUser= personDao.findAllUser();
//        System.out.println ("----Find All User-----" );
//        for (Person person : findAllUser) {
//            System.out.println(person);
//        }
        System.out.println ( personDao.findAllUser ( ) );
        System.out.println ("----Find All Use Successfully-----" );

    }
}
