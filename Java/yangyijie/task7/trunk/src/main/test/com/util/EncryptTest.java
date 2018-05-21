package com.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Arike
 * Create_at 2018/1/8 14:52
 */
public class EncryptTest {
    
    @Test
    public void getSalt() {
        System.out.println(Encrypt.getSalt());
    }
}