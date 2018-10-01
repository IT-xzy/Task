package mapper;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Person;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class PersonMapperTest {
    Logger log = Logger.getLogger("TestMybatis");

    @Resource
    private PersonMapper  personMapper;

    @Test
    public void testGetPerson() {
        Person person = personMapper.getPerson ( 3 );
        System.out.println (person );
    }
    @Test
    public void testInsertPerson() {
        Person person = new Person ();
        person.setEmp ( "总监" );
        person.setName ("MM");
        person.setSalary (652652.54);
        personMapper.insertPerson ( person );
    }

    @Test
    public void testDeletePerson() {
        personMapper.deletePerson ( 11 );

    }
    @Test
    public void testUpdateEmp() {
        Person person = new Person ();
        person.setName ( "AA" );
        person.setEmp ( "高级工程师" );
        person.setSalary ( 5566.32 );
        personMapper.updateEmp ( person );
    }

    @Test
    public void testFindAllUser() {
        System.out.println (personMapper.findAllUser() );
    }

    }

