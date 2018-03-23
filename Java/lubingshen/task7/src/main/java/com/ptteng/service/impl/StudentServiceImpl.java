package com.ptteng.service.impl;

import com.ptteng.dao.StudentDao;
import com.ptteng.dao.UserDAO;
import com.ptteng.manager.Redis;
import com.ptteng.pojo.exception.UnacceptableException;
import com.ptteng.pojo.model.Student;
import com.ptteng.pojo.model.User;
import com.ptteng.service.StudentService;
import com.ptteng.utils.DataCheckUtil;
import com.ptteng.utils.OSSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
//这个service可以扔到一个独立机子上，用spring配置多个数据源，去ping其他数据库的端口
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;
    @Autowired
    UserDAO userDAO;
    @Autowired
    Redis cacheManager;


    @Override
    //上传用户头像至OSS服务器，并且取回URL值
    public String uploadAvatar(MultipartFile file, String userName, String ip) {
        Object count = cacheManager.get(ip, "avatar");
        int number;
        if (count == null) {
            cacheManager.put(ip, "avatar", 0, 36000L);
            number = 0;
        } else {
            number = (int) count;
        }
        if (number >= 10) {
            throw new UnacceptableException("该ip请求太频繁");
        }
        String fileName = file.getOriginalFilename();
        DataCheckUtil.isImg(fileName);
        // 获取文件后缀名
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String key = OSSUtil.getImgKey(userName, suffix);
        OSSUtil.uploadFileToOSS(file, key);
        //发送成功则增加计数
        number++;
        //添加新的ip请求次数到缓存中
        cacheManager.put(ip, "avatar", number, 36000L);
        return OSSUtil.getImgUrl(key);
    }

    @Override
    public boolean updateStudentAvatar(String userName, String url) throws Exception {
        User user = userDAO.findStudentByName(userName);
        Student student = user.getStudent();
        student.setAvatar(url);
        return studentDao.updateAvatarById(student);
    }

    @Override
    public boolean hasStudentInfo(String userName) throws Exception {
        Long studentId = userDAO.findByName(userName).getStudentId();
        return studentId != null;
    }

    @Override
    public User getStudentInfo(String userName) throws Exception {
        User user = userDAO.findStudentByName(userName);
        if (user == null) {
            throw new UnacceptableException("过期的账号角色");
        }
        return user;
    }

    @Override
    public String addStudentByUser(String userName, String studentName) throws Exception {
        //再次确认用户角色有效
        User user = userDAO.findStudentByName(userName);
        if (user == null) {
            throw new UnacceptableException("过期的账号角色");
        }
        Student student = new Student();
        student.setCreateAt(System.currentTimeMillis());
        student.setStudentName(studentName);
        //这边必须用user的id，而不是name，因为name可以改
        String onlineNumber = "DepeatKK-" + user.getId();
        student.setOnlineNumber(onlineNumber);
        try {
            studentDao.insertStudent(student);
        } catch (DuplicateKeyException e) {
            throw new UnacceptableException("你已经重新报名，请刷新页面");
        }
        Long studentId = student.getId();
        user.setStudentId(studentId);
        userDAO.addStudentId(user);
        return onlineNumber;
    }

}
