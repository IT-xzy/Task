package com.opt.util;

import java.io.File;

public class FileCheUtil {

    /**
     * 判断文件大小
     *
     * @param file
     *            文件
     * @param size
     *            限制大小
     * @param unit
     *            限制单位（B,K,M,G）
     * @return
     */
    public static boolean checkFileSize(File file, int size, String unit) {
        long len = file.length();
        double fileSize = 0;
        if ("B".equals(unit.toUpperCase())) {
            fileSize = (double) len;
        } else if ("K".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1024;
        } else if ("M".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1048576;
        } else if ("G".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1073741824;
        } else {
            System.out.println("没有当前单位");
            return false;
        }

        System.out.println("上传文件大小："+fileSize);
        if (fileSize > size) {

            return false;
        }
        return true;
    }

}
