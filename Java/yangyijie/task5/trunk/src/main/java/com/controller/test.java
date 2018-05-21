package com.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Arike
 * Create_at 2018/1/16 08:47
 */
public class test {
    public static void main(String[] args) throws ParseException {
        Date da = new SimpleDateFormat("yyyy-MM-dd").parse("2018-11-1");
        System.out.println(da);
    }
}
