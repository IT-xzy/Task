package com.mutesaid.service.impl;

import com.mutesaid.mapper.UsrMapper;
import com.mutesaid.pojo.Usr;
import com.mutesaid.service.UsrService;
import com.mutesaid.utils.*;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import java.io.IOException;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Map;
import java.util.Objects;

@Service
public class UsrServiceImpl implements UsrService {
    private static final String JWT_KEY = "www.jnshu.com";

    @Autowired
    private UsrMapper usrMapper;

    @Autowired
    private SendMsgUtil sendMsgUtil;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    @Qualifier("uploadPic")
    private UploadPicUtil uploadPic;

    @Override
    public void insert(Usr usr, BindingResult error) {
        if (error != null && error.hasErrors()) {
            String msg = Objects.requireNonNull(error.getFieldError()).getDefaultMessage();
            throw new IllegalArgumentException(msg);
        }
        Boolean nameBeUsed = hasUsrName(usr.getName());
        Boolean phoneBeUsed = hasUsrName(usr.getPhone());
        Boolean emailBeUsed = hasUsrName(usr.getEmail());
        if (nameBeUsed || phoneBeUsed || emailBeUsed) {
            throw new IllegalArgumentException("Beused.usr.name");
        }
        Long currentTime = System.currentTimeMillis();
        String pwdIn = MD5Util.encrypt(usr.getPwd(), currentTime.toString());
        usr.setPwd(pwdIn);
        usr.setCreateAt(currentTime);
        usr.setUpdateAt(currentTime);
        usrMapper.insert(usr);
    }

    @Override
    public Boolean hasUsrName(String value) {
        return usrMapper.select(value) != null;
    }

    @Override
    public Usr isTrue(String value, String pwd) {
        Usr usr = usrMapper.select(value);
        if (usr == null) {
            throw new IllegalArgumentException("Input.usr.null");
        }
        Boolean isMatch = pwdMatch(pwd, usr);
        if (!isMatch) {
            throw new IllegalArgumentException("Input.usr.match");
        }
        return usr;
    }

    @Override
    public void isTrueCode(String code, Usr usr) {
        String redisCode = (String) redisTemplate.opsForValue().get(usr.getPhone());
        if (redisCode == null || !redisCode.equals(code)) {
            throw new IllegalArgumentException("Code.usr.error");
        }
    }

    @Override
    public Boolean pwdMatch(String pwd, Usr usr) {
        String pwdIn = MD5Util.encrypt(pwd, usr.getUpdateAt().toString());
        return usr.getPwd().equals(pwdIn);
    }

    @Override
    public Cookie setToken(Usr usr) {
        Map<String, Object> payload = new HashMap<>(1);
        payload.put("usrName", usr.getName());
        payload.put("usrId", usr.getId());

        String jwt = JJWTUtil.sign(payload, JWT_KEY);
        return CookieUtil.addCookie("token", jwt);
    }

    @Override
    public Integer phoneCode(String phone) {
        Integer num = 100000 + (int) (Math.random() * 900000);
        HashMap<String, Object> result = sendMsgUtil.sendTemplateSMS(phone, "1", new String[]{num.toString(), "1"});
        if ("000000".equals(result.get("statusCode"))) {
            redisTemplate.opsForValue().set(phone, num.toString());
//            redisTemplate.expire(phone, 60, TimeUnit.SECONDS);
            return num;
        } else {
            throw new IllegalArgumentException((String) result.get("statusMsg"));
        }
    }

    @Override
    public Usr matchEmail(String token) {
        Map map = JJWTUtil.verify(token.replace("*", "."), "www.jnshu.com");
        String email = (String) map.get("email");
        String redis = ((String) Objects.requireNonNull(redisTemplate.opsForValue().get(email))).replace(".", "*");

        if (!token.equals(redis)) {
            throw new IllegalArgumentException("Email.usr.error");
        }
        return (Usr) redisTemplate.opsForValue().get(email + "usr");
    }

    @Override
    public void uploadPic(Cookie[] cookies, MultipartFile pic) throws IOException {
        String id = CookieUtil.getUsr(cookies);
        String[] fileArray = Objects.requireNonNull(pic.getOriginalFilename()).split("[.]");
        String picSuff = fileArray[fileArray.length - 1];
        String picName = MD5Util.encrypt(id, "") + "." + picSuff;
        CloseableHttpResponse response = uploadPic.upload(pic.getInputStream(), picName);
        StatusLine status = response.getStatusLine();
        if (status.getStatusCode() != 200) {
            throw new InvalidPropertiesFormatException(status.getStatusCode() + status.getReasonPhrase());
        }
        usrMapper.setPic(id, picName);
    }

    @Override
    public String getPic(Cookie[] cookies) {
        String id = CookieUtil.getUsr(cookies);
        String picName = usrMapper.getPic(id);
        return uploadPic.getPic(picName);
    }

    @Override
    public void sendEmail(Usr usr) {
        SendEmailUtil.sendEmail(usr);
    }
}
