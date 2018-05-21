//package com.util;
//
//public class RandomService {
//    static final String[] str = {"rmi://127.0.0.1:1199/RemoteService", "rmi://127.0.0.1:1198/RemoteService"};
//
//    public static String getRandomServicermi() {
//        int index = (int)(Math.random()*str.length);
//        return str[index];
//    }
//
//    public static String getanotherrmi(String rmi){
//        String another = null;
//        for(String string:str){
//            if(!string.equals(rmi)){
//                another =  string;
//            }
//        }
//        return another;
//    }
//}
