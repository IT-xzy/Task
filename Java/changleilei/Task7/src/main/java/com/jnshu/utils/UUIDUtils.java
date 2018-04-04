package com.jnshu.utils;
import java.util.UUID;

public class UUIDUtils {
    //随机生成数字
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
