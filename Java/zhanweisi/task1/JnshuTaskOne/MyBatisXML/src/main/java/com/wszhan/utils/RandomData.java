package com.wszhan.utils;

import com.github.javafaker.Faker;

import java.util.Random;

/**
 * @author Weisi Zhan
 * @create 2018-10-30 11:50
 **/
public class RandomData {
    private Random random;
    Faker faker;

    public RandomData() {
        random = new Random();
        faker = new Faker();
    }

    public int randomAge() {
        int high = 120;
        return random.nextInt(high);
    }

    public String randomName() {
        return faker.name().fullName();
    }

    public static void main(String[] args) {
        RandomData randomObj = new RandomData();

        //randomObj.randomAge(120);
        for (int i = 0; i < 20; i++) {
            System.out.println(randomObj.randomName());
        }
    }
}
