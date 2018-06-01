package com.ptteng;

import org.junit.Test;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationTest {
    @Test
    public void EnumerationTest(){
        Enumeration<String> days;
        Vector<String> dayNames = new Vector<>();
        dayNames.add("Sunday");
        dayNames.add("Monday");
        dayNames.add("Tuesday");
        dayNames.add("Wednesday");
        dayNames.add("Thursday");
        int i = dayNames.hashCode();
        System.out.println(i);
        dayNames.add("Friday");
        int x = dayNames.hashCode();
        System.out.println("hashCode x = " + x);
        days = dayNames.elements();
        while(days.hasMoreElements()){
            System.out.println(days.nextElement());
        }
    }

}
