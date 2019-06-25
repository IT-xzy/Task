package cn.wp.interceptor;

import cn.wp.encryption.DESUtil;
import cn.wp.model.User;
import cn.wp.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: interceptor @Description:利用spring框架提供的HandlerInterceptorAdapter，实现自定义拦截器 @Author:
 * 老王 @Date: 2019/5/18 15:10 @Version: 1.0
 */
@Service
public class LoginInterceptor implements HandlerInterceptor {

  Logger logger = Logger.getLogger(HandlerInterceptor.class);

  @Autowired UserService userService;

  /**
   * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，SpringMVC中的Interceptor拦截器
   * 是链式的，可以同时存在多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的
   * preHandle方法都会在Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是
   * 令preHandle的返回值为false，当preHandle的返回值为false的时候整个请求就结束了。
   */
  @Override
  public boolean preHandle(
      HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
      throws Exception {
    //        请求cookie里的信息,放入cookies
    Cookie[] cookies = httpServletRequest.getCookies();
    //        如果httpServletRequest里的cookies为空,就从httpServletResponse的header拿token.拿到后解析
    //        如果cookies的长度等于0,表示没有cookies,返回登录页面,让用户登录一下,发给用户一个cookie,下次登录的时候用户就有cookie
    if (cookies == null && cookies.length > 0) {
      logger.info("没有cookie呢=========================");
      //            从httpServletRequest.getHeader拿出token,然后解密
      String token = httpServletRequest.getHeader("token");
      DESUtil desUtil = new DESUtil();
      //            取出明文
      String mingwen = desUtil.decrypt(token);
      //            分割字符串
      String[] fenge = mingwen.split("\\|");
      System.out.println("时间戳=============" + fenge[0].toString());
      //            取出时间里的数字
      String timeStamp = fenge[0];
      //            转为long型
      Long time = desUtil.decryptToLong(timeStamp);
      logger.info("时间是============================" + time);
      if (System.currentTimeMillis() - time >= 30 * 60 * 1000) {
        System.out.println("token过期=========================");
        httpServletResponse.sendRedirect("/a/u/login");
        return false;
      } else {
        String idstr = fenge[2];
        logger.info("用户id==================" + idstr);
        Long idIs = desUtil.decryptToLong(idstr);
        logger.info("id is ==================" + idIs);
        //                判断id是否合法
        User user = userService.selectById(idIs);
        logger.info("打印出来查到的数据===============" + user);
        //                如果查出的数据为null,那么就返回登录页面.
        if (user == null) {
          httpServletResponse.sendRedirect("/a/u/login");
          return false;
        }
        return true;
      }
    } else {
      //            用户有cookies
      logger.info("cookies length=================" + cookies.length);
      //            遍历用户cookies,进行查看比对
      for (int i = 0; i < cookies.length; i++) {
        System.out.println("cookies名================" + cookies[i].getName());
        System.out.println("cookies值=============" + cookies[i].getValue());
        //                如果他的cookie与我给他发的token名字相等,那么可以返到页面里
        if (cookies[i].getName().equals("token")) {
          System.out.println("匹配成功，成功返回！！！！！！！！！！！！！！！！");
          logger.info("token is==========================" + cookies[i].getValue());
          String token = cookies[i].getValue();
          //                    解token,取出id 判断id是否不为空, 不为空,去数据库里查这个id对应的用户是否存在,存在通过拦截器,不存在返回
          DESUtil desUtil = new DESUtil();
          //                    拿出token的明文
          String mingwen = desUtil.decrypt(token);
          System.out.println("明文================" + mingwen);
          String[] strs = mingwen.split("\\|");
          //                    拿出时间戳的明文
          System.out.println("strs=======" + strs[0].toString());
          String timeStamp = strs[0];
          System.out.println("timeStamp=======" + timeStamp);
          Long time = Long.valueOf(timeStamp);
          System.out.println("time=======" + time);
          //                    判断时间戳是否过期
          if (System.currentTimeMillis() - time >= 30 * 60 * 1000) {
            System.out.println("token过期=====");
            //                        返回登录页面
            httpServletResponse.sendRedirect("/a/u/login");
            return false;
          }
          //                    拿出用户id的明文
          String idStr = strs[2];
          if (idStr != null && !idStr.equals("") && !idStr.equals("null")) {
            System.out.println("idStr=======" + idStr);
          }
          Long id = Long.valueOf(idStr);
          System.out.println("id=======" + id);
          //                    判断用户id是否合法
          User temp = userService.selectById(id);
          System.out.println("temp========================" + temp);
          if (temp == null) {
            //                        返回登录页面
            httpServletResponse.sendRedirect("/a/u/login");
            return false;
          }
          return true;
        }
      }
      System.out.println("token不一样=============================");
      //            返回登录页面
      httpServletResponse.sendRedirect("/a/u/login");
      return false;
    }
  }

  /** 在业务处理器处理请求完成之后,生成视图之前执行 */
  @Override
  public void postHandle(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      Object o,
      ModelAndView modelAndView)
      throws Exception {}

  /** 在DispatcherServlet完全处理完请求之后被调用，可用于清理资源 */
  @Override
  public void afterCompletion(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      Object o,
      Exception e)
      throws Exception {}
}
