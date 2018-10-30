package com.jnshutask.util;

 class DataSwap {
     static{
         System.out.println("父类的静态代码块");
     }
     {
         System.out.println("父类的代码块");
     }
    public DataSwap(){
        System.out.println("父类一参构造函数");
    }
    public DataSwap(String two){
        this();
        System.out.println("父类二参构造函数");
    }
}
