package com.AOP;

import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        List list = new ArrayList();
        List list1 = new ArrayList();
        list.add("first");
        list.add("nihao");
        list1.add("first");
        list1.add("nihao");
        list1.add(list);
        JSONArray jsonArray = JSONArray.fromObject(list1);
        System.out.print(jsonArray);

        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("name", "Alexia");
        map1.put("sex", "female");
        map1.put("age", "23");

        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("name", "Edward");
        map2.put("sex", "male");
        map2.put("age", "24");

        List<Map> list2 = new ArrayList<Map>();
        list2.add(map1);
        list2.add(map2);
        System.out.println(list2);
    }
}
