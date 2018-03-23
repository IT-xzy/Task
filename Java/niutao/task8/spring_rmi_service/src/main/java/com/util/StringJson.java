package com.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

public class StringJson {
    private static Gson gson = new Gson();

    public static String MapToJson(Map<Integer, String> map){
        String json = gson.toJson(map);
        return json;

    }

    public static Map<Integer, String> JsonToMap(String json){
        Type type = new TypeToken<Map<Integer, String>>() {}.getType();
        Map<Integer, String> map = gson.fromJson(json,type);
        return map;

    }

}
