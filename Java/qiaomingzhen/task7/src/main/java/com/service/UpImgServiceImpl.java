//package com.service;
///*
// * @ClassName:UpImgServiceImpl
// * @Description:TODO
// * @Author qiao
// * @Date 2018/8/26 21:34
// **/
//
//import com.util.task7.OSSClientUtil;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//@Service
//public class UpImgServiceImpl implements UpImgService {
//    @Override
//    public String updateHead(MultipartFile file) {
//        if (file == null || file.getSize() <= 0) {
//            System.out.println("file不能为空");
//        }
//        OSSClientUtil ossClient=new OSSClientUtil();
//        String name = ossClient.uploadImg2Oss(file);
//        String imgUrl = ossClient.getImgUrl(name);
//        String[] split = imgUrl.split("\\?");
//        return split[0];
//    }
//
//}
