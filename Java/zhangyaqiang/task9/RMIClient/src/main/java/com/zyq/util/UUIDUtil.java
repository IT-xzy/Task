package com.zyq.util;

import java.util.UUID;

public class UUIDUtil {

    public static String getSalt() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
