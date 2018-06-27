/*
package com.enroll;

import com.enroll.POJO.EntryForm;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

*/
/**
 * @ProjectName: task1
 * @Package: com.enroll.service
 * @ClassName: TestReflect
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/2 10:27
 * @UpdateUser:
 * @UpdateDate: 2018/5/2 10:27
 * @UpdateRemark:
 * @Version: 1.0
 *//*

public class TestReflect {
    private Class c;

    {
        try {
            c = Class.forName("com.enroll.POJO.EntryForm");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void constructorTest() throws Exception {

        EntryForm entryForm = new EntryForm();
        Class c1 = entryForm.getClass();
        Class c2 = EntryForm.class;
        System.out.println(c1==c2);
        //get c.class
        Class c = Class.forName("com.enroll.POJO.EntryForm");
        //get a constructor with no parameterType
        Constructor constructor = c.getConstructor();
        System.out.println(constructor + "\n");

        Constructor[] constructors = c.getConstructors();
        //get all constructors
        for (Constructor constructor1 : constructors)
            System.out.println(constructor1);
        System.out.println();

        //get a constructor with String/Integer parameterType
        Constructor constructor1 = c.getConstructor(String.class, int.class);
        System.out.println(constructor1 + "\n");
    }

    @Test
    public void methodTest() throws Exception {

        //all methods
        Method[] methods = c.getDeclaredMethods();
        //too many to show
        System.out.println(methods.length);

        //get setName()
        Method method = c.getMethod("setName", String.class);
        System.out.println(method);
    }

    @Test
    public void fieldTest() throws Exception {
        //get all fields include private field
        Field[] fields = c.getDeclaredFields();
        System.out.println(fields.length);

        //public field
        Field[] fields1 = c.getFields();
        for (Field field : fields1)
            System.out.println(field);

        //get String test1  throws Exception
        Field field = c.getField("test");
        System.out.println(field);

    }

    @Test
    public void reflectTest() throws Exception {
        //new object  throws Exception
        Object o = c.newInstance();
        Method method = c.getDeclaredMethod("reflect", String.class);
        method.setAccessible(true);
        System.out.println(method.invoke(o, "123456"));

    }

}
*/
