package com.myitschool.redPackageActivity;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ReadPackage {
    private double remainMoney = 1000000000;
    private int remainSize = 1000;

//    public ReadPackage(double remainMoney, int remainSize) {
//        this.remainMoney = remainMoney;
//        this.remainSize = remainSize;
//    }

    public double getRemainMoney() {
        return this.remainMoney;
    }

    public int getRemainSize() {
        return this.remainSize;
    }

    public boolean isEmpty() {
        return 0 == remainSize;
    }

    public double getRandomMoney() {
        if (1 == this.remainSize) {
            this.remainSize--;
            return (double) Math.floor(this.remainMoney * 100) / 100;
        }

        Random random = new Random();
        double min = 0.01;
        double max = this.remainMoney / this.remainSize * 2;
        double money = random.nextDouble() * max;
        money = money <= min ? min : money;
        money = (double) Math.floor(money * 100) / 100;
        this.remainSize--;
        this.remainMoney -= money;
        return money;
    }
}
