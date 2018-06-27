package com.Impl;

import com.POJO.Student;
import com.Utils.OSSUtil;
import com.mappers.LoginMapper;
import com.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.UnavailableException;
import java.util.List;

/**
 * @author: 曹樾
 * @program: task7
 * @description: the implements of LoginService
 * @create: 2018/5/28 下午1:41
 */

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private LoginMapper loginMapper;
    public List<Student> testJson() {
        List<Student> studentlist = loginMapper.testJson();
        return studentlist;
    }
    @Override
    //上传用户头像至OSS服务器，并且取回URL值
    public String uploadAvatar(MultipartFile file, String userName, String ip) throws UnavailableException {
//        Object count = cacheManager.get(ip, "avatar");
//        int number;
//        if (count == null) {
//            cacheManager.put(ip, "avatar", 0, 36000L);
//            number = 0;
//        } else {
//            number = (int) count;
//        }
//        if (number >= 10) {
//            throw new UnacceptableException("该ip请求太频繁");
//        }
        String fileName = file.getOriginalFilename();
//        DataCheckUtil.isImg(fileName);
        // 获取文件后缀名
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String key = OSSUtil.getImgKey(userName, suffix);
        OSSUtil.uploadFileToOSS(file, key);
        //发送成功则增加计数
//        number++;
        //添加新的ip请求次数到缓存中
//        cacheManager.put(ip, "avatar", number, 36000L);
        return OSSUtil.getImgUrl(key);
    }
}
