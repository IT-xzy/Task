package com.iceneet.untils;

import java.util.Random;

public class RandomCode {
    public static String getFourRandom(){
        Random random = new Random();
        String fourRandom = random.nextInt(10000) + "";
        int randLength = fourRandom.length();
        if(randLength<4){
            for(int i=1; i<=4-randLength; i++)
                fourRandom = "0" + fourRandom  ;
        }
        return fourRandom;
    }

//    public static void main(String[] args) {
//        System.out.println(getFourRandom());
//    }
}
