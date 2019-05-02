package com.ju.wp;
/**
 * Author: 老王
 * Date: 2019/4/25 20:06
 */
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyHandler implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //装载模型数据和逻辑视图
        ModelAndView model = new ModelAndView();
        //添加模型数据
        model.addObject("name", "Tom");
        //添加逻辑视图
        model.setViewName("show");
        return model;
    }
}
