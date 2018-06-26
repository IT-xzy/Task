package com.ptt.interceptor;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName: UploadFileTypeInterceptor
 * @Description: 拦截MultipartHttpServletRequest类型的请求。
 * @Author: Jin
 * @CreateDate: 2018/6/15 13:39
 * @Version: 1.0
 */
public class UploadFileTypeInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //判断请求类型
        if (request instanceof MultipartHttpServletRequest) {
            //强转为MultipartHttpServletRequest类型请求
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            //取出文件map
            Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
            Iterator<String> iterator = fileMap.keySet().iterator();
            //遍历map中的value值（即文件）
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                MultipartFile file = multipartRequest.getFile(key);
                //判断文件类型
                if (fileType(file.getOriginalFilename())) {
                    return true;
                }
            }
        }
        request.setAttribute("message", "文件类型错误");
        request.getRequestDispatcher("/it/u/photo").forward(request, response);
//        response.sendRedirect(request.getContextPath() + "/it/u/photo?message=文件类型不符合");
        return false;
    }

    /**
     * @Description: 判断文件类型，是允许的文件类型则返回true。
     * @return: boolean
     * @Date: 2018/6/15 13:55
     */
    private boolean fileType(String fileName) {
        boolean flag = false;
        //允许上传的图片后缀
        String suffixAllowed = "jpg,png,jpeg,gif";
        //根据文件名字获得文件后缀
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        //将得到的文件后缀去空格、变小写之后，看是否包含于suffixAllowed之中
        if (suffixAllowed.contains(suffix.trim().toLowerCase())) {
            flag = true;
        }
        return flag;
    }
}
