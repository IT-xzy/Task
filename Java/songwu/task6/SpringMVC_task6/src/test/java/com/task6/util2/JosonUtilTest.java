package com.task6.util2;

import com.task6.pojo.Person;
import org.junit.Test;

/** 
* JosonUtil Tester. 
* 
* @author <Authors name> 
* @since <pre>八月 2, 2018</pre> 
* @version 1.0 
*/ 
public class JosonUtilTest { 
String personJson;

/** 
* 
* Method: parseObjToJson(Object object) 
* 
*/ 
@Test
public void testParseObjToJson() throws Exception {
    Person person = new Person("刘军鹏", "asd*");
    personJson=JosonUtil.parseObjToJson(person);
    System.out.println(personJson);

} 

/** 
* 
* Method: parseJsonToObj(String json, Class<T> c) 
* 
*/ 
@Test
public void testParseJsonToObj() throws Exception {
    Person personFormJson = JosonUtil.parseJsonToObj(personJson, Person.class);
    System.out.println(personFormJson);
} 


} 
