package com.task.Filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PreventLinkFilter implements Filter {

     private static  Logger logger = Logger.getLogger(PreventLinkFilter.class);
     //限制访问地址列表正则，在配置方法中从配置文件中读出来
     private static List<Pattern> urlLimit=new ArrayList<Pattern>();
     //允许访问列表，在配置方法中从配置文件中读出来
     private static List<String> urlAllow=new ArrayList<String>();
     //错误地址列表，在配置方法中从配置文件中读出来
    private static String urlError="";

    //必须过Fileter的请求
    protected boolean shouldBeFilter(HttpServletRequest request)throws ServletException{
        String path=request.getServletPath();
        for (int i=0;i<urlLimit.size();i++){
            Matcher matcher=urlLimit.get(i).matcher(path);//用限制的url一个个去匹配path
            if(matcher.matches()){
                logger.info("当前path为："+path+"应该被过滤");
                return true;
            }

        }
      return false;//未匹配到返回false
    }

    public void destroy(){}


    public void init(FilterConfig fc) throws ServletException {
        logger.info("防盗链配置开始");
        String filename;
        try{
            filename=fc.getServletContext().getRealPath("preventLink.properties");
            File f=new File(filename);
            InputStream is=new FileInputStream(f);
            Properties properties=new Properties();
            properties.load(is);
            //限制访问的地址正则
            String limit=properties.getProperty("url.limit");
            //解析字符串变成正则，放在urlLimit列表中
            parseRegx(limit);
            // 不受限的请求头
            String allow = properties.getProperty("url.allow");
            // 将所有允许访问的请求头放在urlAllow列表中
            urlAllow = parseStr(urlAllow, allow);
            urlError = properties.getProperty("url.error");
            }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest=(HttpServletRequest)request;
        HttpServletResponse httpResponse=(HttpServletResponse)response;
        if (null==httpRequest||null==httpResponse){
            return;//其中一个不存在就跳出去
        }
        //看是否应该被拦截
        if (!shouldBeFilter(httpRequest)) {
            chain.doFilter(request, response);
            return;
        }
        //查看请求中的referer
        String requestHeader = httpRequest.getHeader("referer");
        if (null == requestHeader) {
            httpResponse.sendRedirect(urlError);
            return;
        }
        for (int i = 0; i < urlAllow.size(); i++) {
            //判断是否是允许访问列表
            if (requestHeader.startsWith(urlAllow.get(i))) {
                chain.doFilter(httpRequest, httpResponse);
                return;
            }
        }
        //不是就去错误页面
        httpResponse.sendRedirect(urlError);
        return;
    }

    //将字符串解析成正则
    private void parseRegx(String str) {
        if (null != str) {
            String[] spl = str.split(",");
            if (null != spl) {
                for (int i = 0; i < spl.length; i++) {
                    Pattern p = Pattern.compile(spl[i].trim());
                    urlLimit.add(p);
                }
            }
        }
    }
        private List<String> parseStr(List<String> list,String str){

            if (null == str || str.trim().equals("")) {
                return null;
        }
           //以逗号为分割标记分割，然后存入spl中
            String[] spl = str.split(",");

            if (null != spl && spl.length > 0) {
                list = Arrays.asList(spl);
            }

            return list;

        }
}
