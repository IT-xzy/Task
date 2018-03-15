package cn.summerwaves.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestPeople {
    @Test
    public void Test() {
        People people = new People();
        people.setName("name");
        System.out.println(people.getName());
    }

}