package com.redis;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//json 互转的工具类

public class Tool {
    /* 功能     ：将一个对象转成json数组
     * 参数      ：object对象
     * return    ：json数组
     * */

    public String getJsonByJSONArrayFromObject(Object o) {

        JSONArray json = JSONArray.fromObject(o);

        return json.toString();

    }

    /* 功能     ：将一个对象转成json对象
     * 参数      ：object对象
     * return    ：json对象
     * */

    public String getJsonByBeanFromObject(Object o) {

        JSONObject jsonObj = JSONObject.fromObject(o);

        return jsonObj.toString();

    }



    /* 功能      ：将一个List转成json数组
     * 参数      ：对象list
     * return    ：json数组
     * 返回的格式： [{"password":"1234","username":"cxl"}]
     * */

    public String getJsonByJSONArrayFromList(List list) {

        JSONArray json = JSONArray.fromObject(list);

        return json.toString();

    }

    /* 功能                     ：将一个List转成json对象
     * 参数                     ：对象list
     * return    ：json对象
     * */

    public String getJsonByJSONObjectFromList(List list) {

        JSONObject jsonObj = new JSONObject();

        for (int i = 0; i < list.size(); i++) {

    jsonObj.put(list.get(i).toString(), list.get(i));

        }

        return jsonObj.toString();

    }
    /* 功能      ：将一个map转成json数组
     * 参数      ：map
     * return    ：json数组
     * */

    public String getJsonByJSONArrayFromMap(Map map) {

        JSONArray json = JSONArray.fromObject(map);

        return json.toString();
    }

    /* 功能      ：将一个map转成json对象
     * 参数      ：map
     * return    ：json对象
     * */

    /*
     * Map<String,Object> map = new HashMap<String,Object>(); map.put("users",
     * users); map.put("u", u);
     */

    public String getJsonByJSONObjectFromMap(Map map) {

        JSONObject json = JSONObject.fromObject(map);

        return json.toString();

    }

    /*
     * 功能    ：将json对象（只有一组值）转成object
     * 参数    ：json字符串
     * return  : javabean 对象
     * */
// {id:'id1',code:'code1',name:'name1'}

    public Object getBeantByJSONObjectFromJson(String json) {

        JSONObject jsonObject = JSONObject.fromObject(json);

        Object object = (Object) JSONObject.toBean(jsonObject);

        return object;

    }

    /*
     * 功能                 ：将json转成map
     * 参数                 ：json字符串
     * return  : map
     * */
// {id:'id1',code:'code1',name:'name1'}

    public Map<String, Object> getMapByJson(String json) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 最外层解析

        JSONObject object = JSONObject.fromObject(json);

        for (Object k : object.keySet()) {

            Object v = object.get(k);

            map.put(k.toString(), v);

        }

        return map;

    }

    /*
     * 功能                 ：将json转成list
     * 参数                 ：json字符串
     * return  : list
     * */
// [{id:'id1',code:'code1',name:'name1'},{id:'id2',code:'code2',name:'name2'}]

    public List getListByJSONArrayFromJson(String json) {

        JSONArray array = JSONArray.fromObject(json);

        List list = (List) JSONArray.toList(array);

        return array;

    }
}