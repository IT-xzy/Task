package cn.wp.controller;

import com.danga.MemCached.MemCachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName:MemcachedController @Description:memcached 功能测试 @Author: 老王 @Date: 2019/6/3
 * 10:58 @Version: 1.0
 */
@Controller
public class MemcachedController {
  @Autowired MemCachedClient memCachedClient;

  @RequestMapping(value = "/memcached")
  public void setMemCachedClient() {
    // 设置
    Boolean target = memCachedClient.set("me", "1433223");
    System.out.println("memcached 加载是否成功：" + target);
    String result = (String) memCachedClient.get("me");
    System.out.println("memcached 获取的结果：" + result);
    // 替换
    System.out.println("键对应的值 - " + memCachedClient.get("me"));
    target = memCachedClient.replace("me", "123456");
    System.out.println("replace 替换的状态:" + target);
    System.out.println("replace 替换的结果:" + memCachedClient.get("me"));
    // 移除
    memCachedClient.delete("me");
    System.out.println("delete 移除后结果：" + memCachedClient.get("me"));
  }
}
