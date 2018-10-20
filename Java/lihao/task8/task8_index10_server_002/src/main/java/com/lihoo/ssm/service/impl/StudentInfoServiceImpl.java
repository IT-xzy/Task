package com.lihoo.ssm.service.impl;

import com.lihoo.ssm.dao.StudentInfoMapper;
import com.lihoo.ssm.model.StudentInfo;
import com.lihoo.ssm.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.lihoo.ssm.util.MD5Utils.getPwdHash;

/**
 * #Title: StudentInfoServiceImpl
 * #ProjectName task4_index4
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/1-9:35
 */

@Service
public class StudentInfoServiceImpl implements StudentInfoService {

    @Autowired
    StudentInfoMapper studentInfoMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return studentInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<StudentInfo> selectAll() {
        return studentInfoMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(StudentInfo record) {
        return studentInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int insert(StudentInfo record) {
        return studentInfoMapper.insert(record);
    }

    @Override
    public int updateLoginTimeById(StudentInfo studentInfo) {
        return studentInfoMapper.updateLoginTimeById(studentInfo);
    }

    @Override
    public StudentInfo selectByPrimaryKey(Long id) {
        return studentInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public StudentInfo selectByUsername(String username) {
        return studentInfoMapper.selectByUsername(username);
    }

    @Override
    public StudentInfo selectByPwd(String pwd) {
        return studentInfoMapper.selectByPwd(pwd);
    }

    @Override
    public Boolean verifyPwd(StudentInfo studentInfo) {
        StudentInfo studentInfo1 = studentInfoMapper.selectByUsername(studentInfo.getUsername());
        String salt = studentInfo1.getSalt();
        String loginPwdHash = getPwdHash(studentInfo.getPwd(), salt);
        return studentInfo1.getPwd().equals(loginPwdHash);
    }

//    @Override
//    public Boolean verifyCookie(HttpServletRequest request) throws Exception {
//        //        拿到请求中的cookie
//        Cookie[] cookies = request.getCookies();
////        判断Cookie中的token有效性判断用户是否登录
//        if (cookies != null) {
////            取出token名字的Cookie
//            for (int i = 0; i < cookies.length; i++) {
//                if ("token".equals(cookies[i].getName())) {
////                    取出这个cookie
//                    String tokenValue = cookies[i].getValue();
////                    解密token
//                    Claims claims = JwtUtils2.parseJWT(tokenValue);
//                    System.out.println(claims);
//                    String tokenValueDecrypt =  claims.getSubject();
//                    System.out.println(tokenValueDecrypt);
////                    因为之前是用","分隔的用户id和登录时间，所以需要拆解成两个部分
//                    String[] arrToken = tokenValueDecrypt.split(",");
//                    String uid = arrToken[0];
//                    String loginTime = arrToken[1];
//                    String uname = arrToken[2];
////                    对解码之后的token中的登录时间与数据库保存的登录时间做对比
////                    因为uid是一个String，需要转换为Long类型
//                    StudentInfo stuFindByName = studentInfoMapper.selectByUsername(uname);
//                    Long dblLogtime = stuFindByName.getLogAt();
//                    Long loginTimeLong = Long.parseLong(loginTime);
//                    if (loginTimeLong.equals(dblLogtime)) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }


}
