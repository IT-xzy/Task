package com.opt.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器 敏感字符
 * @author Mr.Z
 * @time
 * @param
 * @return List<String>
 */
public class FilterStringUtil {
//    静态 单例
    private static List<String> strs = new ArrayList<>();
    static {
         strs.add("cs");
         strs.add("sb");
         strs.add("2b");
    }
    public static List<String> getFilterString (){
        return strs;
    }

}
