package com.util.aliyunutil;

/**
 * @Author: Jaime
 * @Date: 2018/5/25 21:50
 * @Description: *
 */
public class ViaPictureNameCreater {
        private int viapicturename;
        public int getViapicturename(){
            return viapicturename;
        }
        public void setViapicturename(){
            viapicturename = (int)(Math.random()*999999999)+1000;  //每次调用生成一次六位数的随机数
        }

}
