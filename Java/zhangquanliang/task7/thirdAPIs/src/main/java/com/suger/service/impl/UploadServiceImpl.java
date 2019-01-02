package com.suger.service.impl;

import com.suger.service.UploadService;
import com.suger.util.AliyunOSSClientUtil;
import com.suger.util.UUIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author suger
 * @date 2018/12/31 16:51
 */
@Service(value = "uploadService")
public class UploadServiceImpl implements UploadService {


    private static final Logger logger = LoggerFactory.getLogger(UploadServiceImpl.class);

    // 默认本地保存路径
    private String saveLocalPath = "./upload/";
    // 默认文件保存路径--------------指的是阿里云对象存储的路径
    private String savePath = "user/img/";

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    @Override
    public String aliyunUploadFile(MultipartFile file) {
        // 获取文件名称
        String filename = file.getOriginalFilename();
        // 生成存储路径
        String savePrePath = saveLocalPath+savePath;
        // 获取文件后缀
        String suffix = filename.substring(filename.lastIndexOf("."));
        // 存储目录
        File fileDir = new File(savePrePath);
        // 判断目录是否存在
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }
        // 生成存储文件
        String fileSaveName = UUIDUtils.getUUID()+String.valueOf(System.currentTimeMillis())+suffix;
        try{
            // 存储路径和存储文件生成新的临时文件
            File saveFile = new File(savePrePath,fileSaveName);
            // 移动临时文件
            file.transferTo(saveFile);
            // 准备上传文件到阿里云
            AliyunOSSClientUtil ossClientUtil = new AliyunOSSClientUtil();
            String fileUrl = ossClientUtil.uploadFile(savePrePath+fileSaveName,savePath+fileSaveName);
            saveFile.delete();

            return fileUrl;
        } catch (IOException e){
            e.printStackTrace();
            logger.warn("上传头像至阿里云oss发生异常，失败");
        }
        return null;
    }

}
