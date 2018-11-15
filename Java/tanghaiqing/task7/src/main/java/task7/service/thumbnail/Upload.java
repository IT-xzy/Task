package task7.service.thumbnail;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;

@Service
public class Upload {
    /**
     * 上传图片并返回图片的相对地址
     */
    public String uploadImage(CommonsMultipartFile file,String realUploadPath) throws IOException {
        System.out.println("进入Service uploadImage方法");
        File uploadFile =new File(realUploadPath+"/rawImages");
        if(!uploadFile.exists()){
            System.out.println("创建："+uploadFile);
            uploadFile.mkdir();
        }
        //创建输入流
        InputStream input =file.getInputStream();
        //生成输出地址URL
        String outputPath =realUploadPath+"/rawImages/"+file.getOriginalFilename();
        //创建输入流
        OutputStream output=new FileOutputStream(outputPath);
        //设置缓冲区
        byte[] bytes=new byte[1024];

        //输入流读入缓冲区，输出流从缓冲区写出
        while ((input.read(bytes))>0){
            System.out.println("while().....");
            output.write(bytes);
        }
        input.close();
        output.close();

        //返回原图上传后的相对地址
        return "images/rawImages/"+file.getOriginalFilename();
    }

}
