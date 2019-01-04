package task6.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import task6.pojo.PositionStu;

public class FastJsonUtil {
    public static String TransitionJson(Object object){
        return JSON.toJSONString(object, SerializerFeature.WriteClassName);
    }
    public static PositionStu JsonTransition(String s){
        ParserConfig.getGlobalInstance().addAccept("task6.pojo.PositionStu");
        return (PositionStu) JSON.parse(s);
    }
}
