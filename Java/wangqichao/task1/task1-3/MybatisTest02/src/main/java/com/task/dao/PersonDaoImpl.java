package com.task.dao;

import com.task.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import java.util.List;

public class PersonDaoImpl implements IPersonDao {
    ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
    JdbcTemplate jdbcTemplate=(JdbcTemplate)ctx.getBean("jdbcTemplate");
    @Override
    public void addPerson(Person person) {
        String sql="insert into person1 (created_at,name,age,personId) values (?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{System.currentTimeMillis(),person.getName(),person.getAge(),person.getPersonID()});
    }

    @Override
    public int updatePerson(Person person) {

        String sql="update person1 set updated_at=?,name=?,age=?,personId=? where id=?";
        return   jdbcTemplate.update(sql,new Object[]{System.currentTimeMillis(),person.getName(),person.getAge(),person.getPersonID(),person.getId()});

    }

    @Override
    public int deletePerson(int id) {

        String sql="delete from person1 where id=?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public List<Person> selectAll() {

        String sql="select * from person1";
        RowMapper<Person> rowMapper=new BeanPropertyRowMapper<Person>(Person.class);
        List<Person> personList=jdbcTemplate.query(sql,rowMapper);
        return  personList;
    }

    @Override
    public Person selectById(int id) {

        String sql="select * from person1 where id=?";
        RowMapper<Person> rowMapper=new BeanPropertyRowMapper<Person>(Person.class);
        Person person=jdbcTemplate.queryForObject(sql,rowMapper,id);
        return person;
    }

    @Override
    public Person selectByName(String name) {

        String sql="select * from person1 where name=?";
        RowMapper<Person> rowMapper=new BeanPropertyRowMapper<Person>(Person.class);
        Person person=jdbcTemplate.queryForObject(sql,rowMapper,name);
        return person;
    }

    @Override
    public void deleteAll() {
        String sql="truncate table person1";
        jdbcTemplate.execute(sql);
    }

}
