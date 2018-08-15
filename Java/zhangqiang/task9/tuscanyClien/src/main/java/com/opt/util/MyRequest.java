package com.opt.util;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.List;

//使用HttpServletRequestWrapper重写请求参数
public class MyRequest extends HttpServletRequestWrapper {
    public MyRequest(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        String str = super.getParameter(name);
        List<String> list = FilterStringUtil.getFilterString();
        for(String word : list){
            str = str.replaceAll(word, "请文命用语");
        }
        return str;
    }
}