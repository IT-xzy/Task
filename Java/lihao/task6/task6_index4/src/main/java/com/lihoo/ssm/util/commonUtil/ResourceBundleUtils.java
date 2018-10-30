package com.lihoo.ssm.util.commonUtil;

import java.text.MessageFormat;
import java.util.ResourceBundle;


/**
 * 国际化语言工具类
 * @author
 *
 */

/**
 * #Title: ResourceBundleUtils
 * #ProjectName task6_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/12-20:00
 * @author lihoo
 */


public class ResourceBundleUtils {
    /**
     * 国际化语言文件的名称
     */

    protected static ResourceBundle bundle = ResourceBundle.getBundle("config");

    public static String getString(String key) {
        try {
            return bundle.getString(key);
        } catch (Exception e) {
        }
        return key;
    }

    public static String getString(String key, String resource) {
        bundle = ResourceBundle.getBundle(resource);
        try {
            return bundle.getString(key);
        } catch (Exception e) {
        }
        return key;
    }

    public static String getString(String key, Object... params) {
        try {
            String value = bundle.getString(key);
            MessageFormat form = new MessageFormat(value);
            return form.format(value, params);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

    }

    /**
     *
     * @param key 需要获得的key值
     * @param resource 资源文件名称
     * @return 返回value值
     */
    public static String getString(String key, String resource, Object... params) {
        ResourceBundle bundles = ResourceBundle.getBundle(resource);
        try {
            String value = bundles.getString(key);
            MessageFormat form = new MessageFormat(value);
            return form.format(value, params);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    public static void main(String[] args)
    {
        System.out.println(ResourceBundleUtils.getString("memcached.host"));
    }
}
