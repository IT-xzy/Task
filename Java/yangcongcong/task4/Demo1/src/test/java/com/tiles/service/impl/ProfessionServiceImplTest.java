package com.tiles.service.impl;

import com.tiles.model.Profession;
import com.tiles.service.ProfessionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class ProfessionServiceImplTest {

    @Autowired
    private ProfessionService professionService;
    @Test
    public void addAll() {
        Profession profession = new Profession();
        profession.setType("Python工程师");
        profession.setIntroduce("lulululu");
        profession.setThreshold(1);
        profession.setLevel(1);
        profession.setPeriod("1-2年");
        profession.setRequired(1021);
        profession.setSalary1("10k-15k/月");
        profession.setSalary2("15k-20k/月");
        profession.setSalary3("20k-50k/月");
        profession.setLearning(231);
        profession.setLanguage1("python");
        profession.setLanguage2("mysql");
        profession.setLanguage3("shell");
        profession.setImg_path("/imges2/123456.png");
        profession.setCreate_at(System.currentTimeMillis());
        profession.setUpdate_at(System.currentTimeMillis());

        professionService.addProfession(profession);
        System.out.println(profession);
    }

    @Test
    public void get() {
        List<Profession> list=professionService.getAll();
        for (Profession p : list) {
            System.out.println(p);
        }
    }
}