package com.oto.dao;

import com.oto.pojo.homepage;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import sun.jvm.hotspot.ui.action.FindAction;

import javax.management.Query;
import java.util.List;

/**
 * @author: 刘军鹏
 * @program: task4
 * @description:
 * @create: 2018/6/5 下午5:41
 */

public interface homepageDao {
    
//    homepage findhomeByid(Integer id);
    
    List<homepage> findAll();


}
