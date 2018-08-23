package com.task8.util;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by SongWu on 2018/8/10
 */
public class FileUploadInterceptor extends HandlerInterceptorAdapter {

    private long maxSize;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断是否文件上传
        if(request!=null && ServletFileUpload.isMultipartContent(request)) {
            ServletRequestContext ctx = new ServletRequestContext(request);
            //获取上传文件尺寸大小
            long requestSize = ctx.contentLength();
            if (requestSize > maxSize) {
                //当上传文件大小超过指定大小限制后，模拟抛出MaxUploadSizeExceededException异常
                throw new MaxUploadSizeExceededException(maxSize);
            }
        }
        return true;
    }





    public void setMaxSize(long maxSize) {
        this.maxSize = maxSize;
    }
}
