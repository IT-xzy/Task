package com.suger.controller;

import com.suger.util.MemcacheUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author suger
 * @date 2018/12/4 20:33
 * 测试缓存配置
 */
@Controller
public class MemcachedTest {

    @RequestMapping("/memcached")
    public void setMemcachedServer() {
        // 设置、获取
        Boolean target = MemcacheUtils.set("zql", "20181204");
        System.out.println("memcached 加载是否成功：" + target);
        String result = (String) MemcacheUtils.get("zql");
        System.out.println("memcached 获取的结果：" + result);
        // 替换
        System.out.println("键对应的值 - " + MemcacheUtils.get("zql"));
        target = MemcacheUtils.replace("zql", "123456");
        System.out.println("replace 替换的状态:" + target);
        System.out.println("replace 替换的结果:" + MemcacheUtils.get("zql"));
        // 移除
        MemcacheUtils.delete("zql");
        System.out.println("delete 移除后结果：" + MemcacheUtils.get("zql"));

    }
}
