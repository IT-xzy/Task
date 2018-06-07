import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;
import pojo.User;

import java.util.*;

/**
 * 测试FAST JSON的使用
 */
public class FastJsonTest {
    @Test
    public void test1(){
        //将对象转换成JSON：String objJson = JSON.toJSONString(Object object)
        //输出格式化后的JSON：String objJson = JSON.toJSONString(Object object, boolean prettyFormat)
        Map<String,Object> map = new HashMap<>();
        map.put("key1","one");
        map.put("key2","two");
        String mapJson = JSON.toJSONString(map);
        String mapPrettyJson = JSON.toJSONString(map,true);
        System.out.println("map:"+mapJson+'\n'+"pretty:"+mapPrettyJson);

        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("key11","one");
        map1.put("key12","two");
        list.add(map);
        list.add(map1);
        String listJson = JSON.toJSONString(list);
        String listPrettyJson = JSON.toJSONString(list,true);
        String listPJson = JSON.toJSONString(list,SerializerFeature.PrettyFormat);
        System.out.println("list:"+listJson+'\n'+"pretty:"+listPrettyJson+"\n"+listPJson);

        User user = new User();
        user.setName("小米");
        user.setPassword("youbet");
        String beanJson = JSON.toJSONString(user);
        User user1 = JSON.parseObject(beanJson,User.class); //解析成对象
        System.out.println(user1);
        System.out.println("bean:"+beanJson);


    }

    @Test
    public void test2(){
        //日期格式化
        String dateJson = JSON.toJSONString(new Date()); //输出long类型的时间
        String datePrettyFormateJson = JSON.toJSONString(new Date(),SerializerFeature.WriteDateUseDateFormat);
        String dateFormatJson = JSON.toJSONStringWithDateFormat(new Date(),"yyyy-MM-dd HH:mm:ss.SSS");

        System.out.println("dateJson:"+dateJson+"\n"+"dateFormatJson:"+dateFormatJson);
        System.out.println("datePrettyFormateJson:"+datePrettyFormateJson);
    }

    @Test
    public void test3(){
        //反序列化，把Json解析成对象,必须先序列化
        //如果User序列化是没有加入类型信息（SerializerFeature.WriteClassName），就会报错（java.lang.ClassCastException）
        User user = new User();
        user.setName("小米");
        user.setPassword("youbet");
        String beanJson = JSON.toJSONString(user,SerializerFeature.WriteClassName);
        User user1 = (User) JSON.parse(beanJson);
        System.out.println(user1);

    }

    @Test
    public void test4() {
        //JSONObject，JSONArray是JSON的两个子类。
        //JSONObject相当于Map<String, Object>，
        //JSONArray相当于List<Object>。
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "one");
        map.put("key2", "two");
        JSONObject jsonObject = new JSONObject(map);
        jsonObject.put("key3", "three");
        System.out.println(jsonObject.get("key2"));

        //JSONArray相当于List<Object>
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map2 = new HashMap<>();
        map2.put("key1", "Three");
        map2.put("key2", "Four");
        list.add(map);
        list.add(map2);
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(list));
        for (Object aJ : jsonArray) {
            System.out.println(aJ);
        }
    }


}
