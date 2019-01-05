package com.xiaobo.demo.util;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CommonUtil {
    public static Object map2Object(Map<String,Object> map, Class<?> beanClass)throws Exception{
        if(map == null){
            return null;
        }
        Object obj = beanClass.newInstance();
        org.apache.commons.beanutils.BeanUtils.populate(obj,map);
        return obj;
    }
}
