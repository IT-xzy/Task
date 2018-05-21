package com.ev.service; 

import com.ev.dao.StudentMapper;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})


public class StudentServiceImplTest {

    @Autowired
    StudentService studentService;


/** 
* 
* Method: addAStudent(Student student) 
* 
*/ 
@Test
public void testAddAStudent() throws Exception {
    System.out.println(studentService.findStudentById(19L));
} 

/** 
* 
* Method: deleteAStudent(Long primeKey) 
* 
*/ 
@Test
public void testDeleteAStudent() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findStudentById(Long id) 
* 
*/


@Test
public void testFindStudentById() throws Exception {

    System.out.println(studentService.findStudentByName("刘伟"));
} 

/** 
* 
* Method: findStudentByName(String name) 
* 
*/ 
@Test
public void testFindStudentByName() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findStudentByNumber(String online_num) 
* 
*/ 
@Test
public void testFindStudentByNumber() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: updateInformation(Student student) 
* 
*/ 
@Test
public void testUpdateInformation() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: reset() 
* 
*/ 
@Test
public void testReset() throws Exception { 
//TODO: Test goes here... 
} 


} 
