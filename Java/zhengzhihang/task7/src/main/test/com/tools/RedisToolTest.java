package com.tools;

import org.junit.Test;

import static org.junit.Assert.*;

public class RedisToolTest {

    @Test
    public void rdGet() {
        System.out.println(RedisTool.rdGet("tt"));
    }

    @Test
    public void rdSet() {
        RedisTool.rdSet("tt",CharaterUtils.getRandomString(6),22222);
    }

    @Test
    public void rdDel() {
    }

    @Test
    public void rdGetKey() {

    }

    @Test
    public void rdGet1() {

    }

    @Test
    public void rdSet1() {
    }

    @Test
    public void rdDel1() {
    }

    @Test
    public void rdGetKey1() {
    }
}