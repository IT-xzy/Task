package com.jnshu.Utils;
import java.util.UUID;

public class UUIDUtil {
    public static String getUUID(){
        java.util.UUID uuid= java.util.UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr=str.replace("-", "");
        return uuidStr;
    }
}
