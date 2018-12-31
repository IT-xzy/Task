package com.mutesaid.rmi_demo_web.controller;

import com.mutesaid.rmi_demo_core.model.Response;
import com.mutesaid.rmi_demo_core.model.Usr;
import com.mutesaid.rmi_demo_core.service.UsrService;
import com.mutesaid.rmi_demo_web.utils.CookieUtil;
import com.mutesaid.rmi_demo_web.utils.MD5Util;
import com.mutesaid.rmi_demo_web.utils.UploadPicUtil;
import io.jsonwebtoken.lang.Collections;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

@RestController
@Slf4j
public class UsrController {

    @Resource
    private UsrService usrService;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @PostMapping("/a/usr")
    public Response addUsr(@RequestBody Usr usr){
        log.info("新增用户 usr = {}", usr);
        if(usr.getName()==null || usr.getPwd()==null){
            return new Response<>(-1, "用户名或密码不能为空", null);
        }
        // 判断是否重名
        ArrayList<Usr> check = usrService.findByValue(usr.getName());
        log.info("check = {}", check.size());
        if(!Collections.isEmpty(check)){
            return new Response<>(-1, "用户名已存在", null);
        }
        String email = usr.getEmail();
        // 验证邮箱
        if(email != null){
            String result = redisTemplate.opsForValue().get(email);
            if(result==null){
                log.info("邮箱未验证");
                return new Response<>(-1, "邮箱验证错误", email);
            }
        }
        // 加密密码
        usr.setCreateAt(System.currentTimeMillis());
        usr.setUpdateAt(System.currentTimeMillis());
        String encodepwd = MD5Util.encrypt(usr.getPwd(), usr.getUpdateAt().toString());
        usr.setPwd(encodepwd);

        Long result = usrService.insert(usr);
        log.info("新增id = {}", result);

        return new Response<>(0, "success", result);
    }

    @PostMapping("/a/u/upload")
    public Response uploadPic(MultipartFile pic, HttpServletRequest request) {
        Long mid = CookieUtil.getUid(request);
        log.info("上传图片 mid = {}", mid);
        if(!pic.isEmpty()) {
            try{
                String[] fileArray = Objects.requireNonNull(pic.getOriginalFilename()).split("[.]");
                String picSuff = fileArray[fileArray.length - 1];
                log.info("文件类型 picSuff = {}", picSuff);
                String picName = MD5Util.encrypt(mid.toString(), "") + "." + picSuff;
                log.info("文件名 picName = {}", picName);
                String result = UploadPicUtil.uploadPic(pic.getInputStream(), picName);

                if(result != null) {
                    log.info("上传成功");
                    Usr usr = usrService.findById(mid);
                    usr.setPic(result);
                    usrService.update(usr);
                    return new Response<>(0, "success", result);
                }else {
                    log.info("上传失败");
                    return new Response<>(-1, "请求错误", null);
                }
            }catch (IOException e){
                e.printStackTrace();
                return new Response<>(-1, "请求错误", null);
            }
        }
        return new Response<>(-1, "请求错误", null);
    }
}
