package com.jnshu.task5.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FastJsonUtil {

        private static final SerializeConfig config;

        static {
            config = new SerializeConfig();
            // 使用和json-lib兼容的日期输出格式
            config.put(java.util.Date.class, new JSONLibDataFormatSerializer());
            // 使用和json-lib兼容的日期输出格式
            config.put(java.sql.Date.class, new JSONLibDataFormatSerializer());
        }
        // 输出空置字段
        private static final SerializerFeature[] features = { SerializerFeature.WriteMapNullValue,
                // list字段如果为null，输出为[]，而不是null
                SerializerFeature.WriteNullListAsEmpty,
                // 数值字段如果为null，输出为0，而不是null
                SerializerFeature.WriteNullNumberAsZero,
                // Boolean字段如果为null，输出为false，而不是null
                SerializerFeature.WriteNullBooleanAsFalse,
                // 字符类型字段如果为null，输出为""，而不是null
                SerializerFeature.WriteNullStringAsEmpty
        };

        /**
         * Object 转换成字符串
         * @param object
         * @return
         */
        public static String toJSONFeaturesString(Object object) {
            return JSON.toJSONString(object, config, features);
        }

        /**
         * Object 转换成字符串
         * @param object
         * @return
         */
        public static String toJSONString(Object object) {
            return JSON.toJSONString(object, config);
        }

        public static Object toBean(String text) {
            return JSON.parse(text);
        }


        /**
         * json字符串转化为map
         * @param s
         * @return
         */
        public static Map stringToCollect(String s) {
            Map m = JSONObject.parseObject(s);
            return m;
        }

        /**
         * 将map转化为string
         * @param m
         * @return
         */
        public static String collectToString(Map m) {
            String s = JSONObject.toJSONString(m);
            return s;
        }

        /**
         * 用fastjson 将json字符串解析为一个 JavaBean
         *
         * @param jsonString
         * @param cls
         * @return
         */
        public static <T> T getJson(String jsonString, Class<T> cls) {
            T t = null;
            try {
                t = JSON.parseObject(jsonString, cls);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return t;
        }

        /**
         * 用fastjson 将json字符串 解析成为一个 List<JavaBean> 及 List<String>
         *
         * @param jsonString
         * @param cls
         * @return
         */
        public static <T> List<T> getArrayJson(String jsonString, Class<T> cls) {
            List<T> list = new ArrayList<T>();
            try {
                list = JSON.parseArray(jsonString, cls);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        }

        /**
         * 用fastjson 将json字符串 解析成为一个 List<JavaBean> 及 List<String>
         *
         * @param jsonString
         * @return
         */
        @SuppressWarnings("unchecked")
        public static <T> List<T> getArrayJson(String jsonString) {
            List<T> list = new ArrayList<T>();
            try {
                list = (List<T>) JSON.parseArray(jsonString);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        }

        /**
         * 用fastjson 将jsonString 解析成 List<Map<String,Object>>
         *
         * @param jsonString
         * @return
         */
        public static List<Map<String, Object>> getListMap(String jsonString) {
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            try {
                // 两种写法
                // list = JSON.parseObject(jsonString, new
                // TypeReference<List<Map<String, Object>>>(){}.getType());

                list = JSON.parseObject(jsonString, new TypeReference<List<Map<String, Object>>>() {
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        }

}
