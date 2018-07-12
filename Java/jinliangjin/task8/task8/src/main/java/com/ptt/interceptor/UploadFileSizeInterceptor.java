package com.ptt.interceptor;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: UploadFileSizeInterceptor
 * @Description: 上传文件是拦截大小超过1M的文件。
 * @Author: Jin
 * @CreateDate: 2018/6/15 16:04
 * @Version: 1.0
 */
public class UploadFileSizeInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(UploadFileSizeInterceptor.class);
    private long maxSize;//上传文件的最大size
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request != null && ServletFileUpload.isMultipartContent(request)){
            logger.info("是MultipartContent");
            ServletRequestContext src = new ServletRequestContext(request);
            long fileSize = src.contentLength();
            if(fileSize > maxSize){
                logger.info("文件过大");
                request.setAttribute("message", "图片大小必须小于250kb");
                request.getRequestDispatcher("/it/u/photo").forward(request, response);
                return false;
            }
        }
        return true;
    }

    public void setMaxSize(long maxSize) {
        this.maxSize = maxSize;
    }
}
