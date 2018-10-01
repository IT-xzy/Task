package com.task6.util2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.task6.pojo.Person;

/**
 * Create by SongWu on 2018/8/2
 */
public class JosonUtil {
    /**
     * 把Java对象转换成json字符串
     *
     * @param object 待转化为JSON字符串的Java对象
     * @return json 串 or null
     */
    public static String parseObjToJson(Object object) {
        String string = null;
        try {
            //string = JSON.toJSONString(object);
            string = JSONObject.toJSONString(object);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return string;
    }

    /**
     * 将Json字符串信息转换成对应的Java对象
     *
     * @param json json字符串对象
     * @param c    对应的类型
     */
    public static <T> T parseJsonToObj(String json, Class<T> c) {
        try {
            //JSONObject jsonObject = JSONObject.parseObject(json);
            JSONObject jsonObject = JSON.parseObject(json);
            return JSON.toJavaObject(jsonObject, c);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        Person person = new Person("刘军鹏", "asd*");
      String  personJson=JosonUtil.parseObjToJson(person);
        System.out.println(personJson);

        Person personFormJson = JosonUtil.parseJsonToObj(personJson, Person.class);
        System.out.println(personFormJson);
    }
}
