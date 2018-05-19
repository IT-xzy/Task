package com.fml.utils;

import java.util.UUID;

/**
 * 表示通用唯一标识符(UUID)的类。UUID表示一个128位的值
 */
public class UUIDUtil {
    public static String getUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
