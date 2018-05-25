package com.ptteng;

public class StringAndByteArray {
    public static byte[] strToByteArrary(String str) {
        if (str == null) {
            return null;
        }
        byte[] byteArray = str.getBytes();
        return byteArray;
    }
}
