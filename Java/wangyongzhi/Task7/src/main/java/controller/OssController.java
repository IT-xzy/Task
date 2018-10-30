package controller;

import domain.entity.StuApply;
import domain.entity.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import service.StuApplyService;
import thirdApi.OssService;
import thirdApi.com.aliyun.oss.util.IsImageUtil;
import thirdApi.com.aliyun.oss.util.MtoFUtil;
import util.GetUserUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 上传图片模块
 */
@Controller
@RequestMapping(value = "/")
public class OssController {

    private Logger logger = LoggerFactory.getLogger(OssController.class);

    @Autowired
    GetUserUtil getUserUtil;
    @Autowired
    StuApplyService stuApplyService;
    @Autowired
    OssService ossService;

    /**
     * 展示头像接口
     */
    @RequestMapping(value = "/u/updateImage", method = RequestMethod.GET)
    public String getUploadImage(HttpServletRequest request, Model model) {

        Users user = getUserUtil.getUser(request);
        StuApply stu = stuApplyService.getByUsername(user.getUsername());
        //修改预览图
        model.addAttribute("stu", stu);
        return "bindData/uploadImage";
    }

    /**
     * 上传图片
     */
    @RequestMapping(value = "/u/updateImage", method = RequestMethod.POST)
    public String getUploadImage(@RequestParam("file") MultipartFile file, HttpServletRequest request, Model model)
            throws Exception {

        Users user = getUserUtil.getUser(request);
        StuApply stu = stuApplyService.getByUsername(user.getUsername());
        String imageName = user.getUsername() + "Image";

        File tmp = MtoFUtil.MToF(file, request);

        if (IsImageUtil.isImage(tmp.getAbsolutePath())) {

            //判断OSS数据库是否已经存在图片，存在就删除
            if (ossService.isExist(imageName)) {
                ossService.deleteImage(imageName);
            }
            //上传新图片
            ossService.uploadFile(imageName, tmp.getAbsolutePath());

            //获得访问链接,并存入image字段
            String url = ossService.getUrl() + imageName;
            stu.setImage(url);
            stuApplyService.updateByUsername(stu);

            //修改预览图
            model.addAttribute("stu", stu);


        } else {
            Map map = new HashMap();
            map.put("warning", "您上传的图片格式错误，请重新上传！");
            model.addAttribute("map", map);
            logger.info("This is not an image!");

        }
        //删除临时文件
        File del = new File(tmp.toURI());
        del.delete();
        return "bindData/uploadImage";
    }
}
