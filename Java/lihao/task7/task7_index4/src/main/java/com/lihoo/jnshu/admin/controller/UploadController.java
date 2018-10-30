package com.lihoo.jnshu.admin.controller;

import com.alibaba.fastjson.JSON;
import com.lihoo.jnshu.common.util.COSUtil.QiNiuUtil2;
import com.lihoo.jnshu.common.util.COSUtil.QiniuyunCOSUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * #Title: UploadController
 * #ProjectName task7_index4
 * #Description: TODO
 * #author lihoo
 * #date 2018/10/4-20:35
 * @author lihoo
 */

@Controller
public class UploadController {
    private static Logger logger = LoggerFactory.getLogger(UploadController.class);

    @RequestMapping(value = "/uuploadImg", produces = "text/plain;charset=UTF-8")
    public String uuploadImg(@RequestParam(value = "fileName",required = false) String fileName,
                            Model model, HttpServletRequest request) {
        logger.info("准备->上传图片");
        if (fileName != null) {
            logger.info("本地图片路径不为空");
            return "redirect:/uploadImg";
        }
        return "uuploadImg";
    }

    @RequestMapping(value = "/uploadImg", produces = "text/plain;charset=UTF-8")
    public String uploadImg(@RequestParam(value = "fileName",required = false) String fileName,
                            Model model, HttpServletRequest request) {
        logger.info("开始-->上传图片");
        if (fileName != null) {
            logger.info("本地图片路径:" + fileName);
            QiniuyunCOSUtil.picUp(fileName);
//        QiniuyunCOSUtil.picUp("C:\\Users\\lihoo\\Pictures\\Camera Roll\\public\\Dgzwjn2VQAArM44.jpg");
        }
        logger.info("已经---->上传图片");

        return "uploadImg";

//        //获取文件后缀
//        String fileExt = request.getParameter("fileEnd");
//        //用当前时间毫秒数来为文件命名
//        String fileName = System.currentTimeMillis()+"."+fileExt;
////        String fileName = "666.png";
//        //获取上传凭证
//        String token = QiNiuUtil2.getToken(fileName);
//        //返回对象的封装
//        Map<String,Object> returnMap = new HashMap<String,Object>();
//        returnMap.put("fileName", fileName);
//        returnMap.put("token", token);
//
//        return JSON.toJSONString(returnMap);
    }
}
