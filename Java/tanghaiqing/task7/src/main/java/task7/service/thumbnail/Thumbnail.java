package task7.service.thumbnail;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;



public class Thumbnail {
    //设置缩略图的宽度和高度
    public static final int witdth=100;
    public static final int heigth=100;
    /**
     * 生成缩略图并且返回相对地址
     */
    public static String generateThumbnail(MultipartFile file) throws IOException{
        File uploadFile =new File("E:/task7/target/task7/static/images/thumbImages");
        if(!uploadFile.exists()){
            uploadFile.mkdir();
        }
        //缩略图保存的决定地址
        String des ="E:/task7/target/task7/static/images/thumbImages/"+file.getOriginalFilename();
        //生成缩略图
        Thumbnails.of(file.getInputStream()).size(witdth, heigth).toFile(des);
        //返回缩略图的相对地址
        return "E:/task7/target/task7/static/images/thumbImages/"+file.getOriginalFilename();

    }
}
