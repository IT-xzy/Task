package com.ev.service; 

import com.ev.dao.GoodOnesDAO;
import com.ev.dao.OccupationDAO;
import com.ev.dao.StudentGeneralInfoDAO;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.annotation.ApplicationScope;

/** 
* GoodOnesServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>04/15/2018</pre> 
* @version 1.0 
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class GoodOnesServiceImplTest { 

    @Autowired
    GoodOnesDAO goodOnesDAO;

    @Autowired
    OccupationDAO occupationDAO;

    @Autowired
    StudentGeneralInfoDAO studentGeneralInfoDAO;
@Test
public void testSelectGoodOnes() throws Exception {
    System.out.println(goodOnesDAO.findGoodOnes());
    System.out.println(occupationDAO.selectOccupation());
    System.out.println(studentGeneralInfoDAO.selectMainStatus());

}


} 
