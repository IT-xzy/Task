package com.ev.utils; 

import com.ev.DAO.UserDAO;
import com.ev.service.UserService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
* SMSUtil Tester. 
* 
* @author <Authors name> 
* @since <pre>05/14/2018</pre> 
* @version 1.0 
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SMSUtilTest {
    @Autowired
    UserDAO userDAO;
/**
* 
* Method: sendSms(String phoneNumber, String code) 
* 
*/ 
@Test
public void testSendSms() throws Exception {

}


} 
