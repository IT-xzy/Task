package com.ev.controller; 

import com.ev.entity.GoodOne;
import com.ev.service.GoodOneService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.opensaml.xml.signature.G;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.rmi.Naming;

/** 
* PublicPagesController Tester. 
* 
* @author <Authors name> 
* @since <pre>05/25/2018</pre> 
* @version 1.0 
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class PublicPagesControllerTest { 



/** 
* 
* Method: getHomePage(Model model) 
* 
*/ 
@Test
public void testGetHomePage() throws Exception {
    GoodOneService goodOneService=(GoodOneService) Naming.lookup("rmi://127.0.0.1:9990/goodOneService");
    goodOneService.selectGoodOne();
}

/** 
* 
* Method: getEnterprise() 
* 
*/ 
@Test
public void testGetEnterprise() throws Exception { 
//TODO: Test goes here... 
} 


} 
