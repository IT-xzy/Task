package com.iceneet.untils;

import java.util.UUID;

public class FileUpload {
    public static boolean isimage(String filetype){
        if("image/png".equals(filetype)||"image/jpg".equals(filetype)||
                "image/gif".equals(filetype)){
            return true;
        }else {
            return false;
        }
    }
    public static String randomName(String filetype){
        String suffix = filetype.split("/")[1];
        String newfilename = UUID.randomUUID()+"."+suffix;
        return newfilename;
    }
}
