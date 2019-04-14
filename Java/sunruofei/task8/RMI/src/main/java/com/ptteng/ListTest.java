package com.ptteng;


/**
 * @ClassName ListTest
 * @Description 自定义一个List
 * @Author 孙若飞
 * @Date 2019/3/21  13:12
 * @Version 1.0
 **/
public class ListTest {
    //定义三个成员变量,数组,元素长度,默认值长度
    private Object[] elementData;
    private int size;
    private static final int defult = 2;
    //无参的构造方法,没有传入参数的话,数组大小默认2
    public ListTest() {
        elementData = new Object[defult];
    }
    //传进来多少,数组大小就为多少
    public ListTest(int capa) {
        elementData = new Object[capa];
    }
    //添加
    public void add(Object ob) {
        //什么时候扩容,
        if(size == elementData.length){
            //>>右移1,代表除以2,<<左移1,代表乘以2,>>右移2,代表除以4
            Object[] objects = new Object[elementData.length+(elementData.length>>1)];
            //第一个参数代表源数组
            //第二个参数代表从原数组的哪里开始copy
            //第三个参数代表目标数组
            //第四个参数代表从目标数组的第几个开始放数据
            //第五个参数代表源数组拷贝几个数据过去
            System.arraycopy(elementData,0,objects,0,elementData.length);
            elementData = objects;
        }
        elementData[size++] = ob;
    }

    public String toString (){

        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i =0;i<size;i++ ){
            sb.append(elementData[i]+",");
        }
      sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        ListTest listTest = new ListTest();
        listTest.add("sun");
        listTest.add("ruo");
        listTest.add("fei");
        System.out.println(listTest);

    }

}
