package com.jnshu.controller;

import com.jnshu.pojo.ResultBean;
import com.jnshu.pojo.Studio;
import com.jnshu.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author pipiretrak
 * @date 2019/3/21 - 17:28
 */
@Controller
public class StudioController {
    private static Logger logger = Logger.getLogger(String.valueOf(BannerController.class));
    @Autowired
    StudioService studioService;

    @ResponseBody
    @RequestMapping(value = "/studio",method = RequestMethod.GET)
    public ResultBean selectByDynamic(@RequestParam(value = "name",required = false) String name,
                                      @RequestParam(value = "status", required = false) Integer status){
        logger.info(name+","+status);
        logger.info("-----查询被调用-----");
        ResultBean resultBean = new ResultBean();
        List<Studio> studio = studioService.selectByDynamic(name,status);
        if (studio == null || studio.size() == 0){
            resultBean.setCode(-1);
            resultBean.setMsg("查询全部失败");
            resultBean.setData("无法查找结果");
        }else {
            resultBean.setCode(200);
            resultBean.setMsg("查询全部成功");
            resultBean.setData(studio);
        }
        logger.info("：查询结果"+studio);
        return resultBean;
    }

    @ResponseBody
    @RequestMapping(value = "/studio",method = RequestMethod.POST)
    public ResultBean insertBanner(Studio record) {
        logger.info("----添加被调用-----");
        logger.info("：添加的数据" + record);
        ResultBean resultBean = new ResultBean();
        int x = studioService.insert(record);
        logger.info("结果" + x);
        if (x == 0) {
            resultBean.setCode(-1);
            resultBean.setMsg("添加失败");
        } else {
            resultBean.setCode(200);
            resultBean.setMsg("添加成功");
        }
        return resultBean;
    }

    @ResponseBody
    @RequestMapping(value = "/studio/{id}", method = RequestMethod.PUT)
    public ResultBean updateBanner(@RequestParam Long id, Studio record) {
        logger.info("----更新方法被调用-----");
        logger.info("：更新内容" + record);
        ResultBean resultBean = new ResultBean();
        int x = studioService.updateByPrimaryKey(record);
        if (x == 0) {
            resultBean.setCode(-1);
            resultBean.setMsg("修改失败");
        } else {
            resultBean.setCode(200);
            resultBean.setMsg("修改成功");
        }
        return resultBean;
    }

    @ResponseBody
    @RequestMapping(value = "/studio/{id}", method = RequestMethod.DELETE)
    public ResultBean deleteBanner(@PathVariable Long id) {
        logger.info("----删除方法被调用-----");
        logger.info("：删除数据的id为" + id);
        ResultBean resultBean = new ResultBean();
        int x = studioService.deleteByPrimaryKey(id);
        if (x == 0) {
            resultBean.setCode(-1);
            resultBean.setMsg("删除失败");
        } else {
            resultBean.setCode(200);
            resultBean.setMsg("删除成功");
        }
        return resultBean;
    }

    @ResponseBody
    @RequestMapping(value = "/studio/{id}", method = RequestMethod.GET)
    public ResultBean getId(@PathVariable Long id){
        logger.info("：获取传参id为："+id);
        ResultBean resultBean = new ResultBean();
        Studio record = studioService.selectByPrimaryKey(id);
        logger.info("结果"+record);
        if (record == null){
            resultBean.setCode(-1);
            resultBean.setMsg("查询ID失败");

        } else {
            resultBean.setCode(200);
            resultBean.setMsg("查询ID成功");
            resultBean.setData(record);
        }
        return resultBean;
    }
}
