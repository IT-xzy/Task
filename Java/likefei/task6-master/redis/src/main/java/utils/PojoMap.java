package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class PojoMap {
   private static final Logger logger = LoggerFactory.getLogger(PojoMap.class);
    /**
     * Mapz转实体类
     * @param type 实体类class
     * @param map  map
     * @return
     * @throws Exception
     */
    public static Object convertMap(Class<?> type, Map map) throws Exception{
//        BeanInfo beanInfo = Introspector.getBeanInfo(type);
//        Object object = type.newInstance();
//        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
//        for (PropertyDescriptor propertyDescriptor:propertyDescriptors){
//            String propertyName = propertyDescriptor.getName();
//            if (map.containsKey(propertyName)){
//                Object value = map.get(propertyName);
//                propertyDescriptor.getWriteMethod().invoke(object,value);
//            }
//        }
//        logger.info("将Map转换为{}实体类",type);
//        return object;
        if (map == null) {
            return null;
        }
        Object obj = null;
        try {
            obj = type.newInstance();
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }
                field.setAccessible(true);
                field.set(obj, map.get(field.getName()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("将Map转换为{}实体类",type);
        return obj;
    }

    /**
     * 实体类转Map
     * @param bean 实体类
     * @return Map
     * @throws Exception
     */
    public static Map covertBean(Object bean) throws Exception{
        Class type = bean.getClass();
        Map returnMap = new HashMap();
        BeanInfo beanInfo = Introspector.getBeanInfo(type);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor:propertyDescriptors){
            String propertyName = propertyDescriptor.getName();
            if (!propertyName.equals("class")){
                Method readMethod = propertyDescriptor.getReadMethod();
                Object result = readMethod.invoke(bean);
                if (result!=null){
                    returnMap.put(propertyName,result);
                }
                else {
                    returnMap.put(propertyName,"");
                }
            }
        }
        logger.info("将实体类{}转换Map",bean);
        return returnMap;
    }
}
