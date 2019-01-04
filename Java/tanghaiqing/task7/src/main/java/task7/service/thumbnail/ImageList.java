package task7.service.thumbnail;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageList {
    //获取文件夹下所有的文件名
    public static List<String> printFile(String path){
        File file =new File(path);
        List<String> images =new ArrayList<>();
        //是文件夹下的话
        if (file.isDirectory()){
            String[] fileList =file.list();
            for (int i=0;i<fileList.length;i++){
                File readflie =new File(path+"/"+fileList[i]);
                if(!readflie.isDirectory()){
                    images.add(readflie.getName());
                }
            }
        }
        return images;
    }
}
