package com.task4.service;

import com.task4.mapper.ProfessionMapper;
import com.task4.pojo.Profession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/** 
* ProfessionServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>六月 27, 2018</pre> 
* @version 1.0 
*/


@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")

public class ProfessionServiceImplTest {
    @Autowired
    ProfessionService professionService;
@Autowired
    ProfessionMapper professionMapper;
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: selectProfession() 
* 
*/ 
@Test
public void testSelectProfession() throws Exception {
    List<Profession> list=professionMapper.selectProfession();
    System.out.println(list);

}

    @Test
    public void testFindById() {
        List<Profession> list = professionMapper.findById("后端开发方向");
        System.out.println(list);
    }
}
