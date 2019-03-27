package com.jnshu.controller;

import com.jnshu.pojo.FirstWork;
import com.jnshu.pojo.ResultBean;
import com.jnshu.pojo.SecondWork;
import com.jnshu.service.FirstWorkService;
import com.jnshu.service.SecondWorkService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/21 - 11:27
 */
@Controller
public class FirstWorkController {
    private static Logger logger = Logger.getLogger(FirstWorkController.class);

    @Autowired
    FirstWorkService firstWorkService;

    @Autowired
    SecondWorkService secondWorkService;

    @ResponseBody
    @RequestMapping(value = "/first",method = RequestMethod.GET)
    public ResultBean selectByDynamic(@RequestParam(value = "name",required = false) String name,
                                      @RequestParam(value = "status", required = false) Integer status){
        logger.info(name+","+status);
        logger.info("-----查询被调用-----");
        ResultBean resultBean = new ResultBean();
        List<FirstWork> first = firstWorkService.selectByDynamic(name,status);
        if (first == null || first.size() == 0){
            resultBean.setCode(-1);
            resultBean.setMsg("查询全部失败");
            resultBean.setData("无法查找结果");
        }else {
            resultBean.setCode(200);
            resultBean.setMsg("查询全部成功");
            resultBean.setData(first);
        }
        logger.info("：查询结果"+first);
        return resultBean;
    }

    @ResponseBody
    @RequestMapping(value = "/first/{firstId}",method = RequestMethod.GET)
    public ResultBean selectFirstId(@PathVariable long firstId){
        logger.info("查询的id"+firstId);
        logger.info("----被调用----");
        ResultBean resultBean = new ResultBean();
        List<SecondWork> second = secondWorkService.selectFirstId(firstId);
        if (second == null || second.size() == 0){
            resultBean.setCode(-1);
            resultBean.setMsg("查询全部失败");
            resultBean.setData("无法查找结果");
        }else {
            resultBean.setCode(200);
            resultBean.setMsg("查询全部成功");
            resultBean.setData(second);
        }
        logger.info("：查询结果"+second);
        return resultBean;
    }

    @ResponseBody
    @RequestMapping(value = "/first",method = RequestMethod.POST)
    public ResultBean insertBanner(FirstWork record) {
        logger.info("----添加被调用-----");
        logger.info("：添加的数据" + record);
        ResultBean resultBean = new ResultBean();
        int x = firstWorkService.insert(record);
        logger.info("结果" + x);
        if (x == 0) {
            resultBean.setCode(-1);
            resultBean.setMsg("添加失败");
        } else {
            resultBean.setCode(200);
            resultBean.setMsg("添加成功");
        }
        logger.info("添加的数据："+record);
        return resultBean;
    }

    @ResponseBody
    @RequestMapping(value = "/first/{id}", method = RequestMethod.PUT)
    public ResultBean updateBanner(@RequestParam Long id, FirstWork record) {
        logger.info("----更新方法被调用-----");
        logger.info("：更新内容" + record);
        ResultBean resultBean = new ResultBean();
        int x = firstWorkService.updateByPrimaryKey(record);
        if (x == 0) {
            resultBean.setCode(-1);
            resultBean.setMsg("修改失败");
        } else {
            resultBean.setCode(200);
            resultBean.setMsg("修改成功");
        }
        logger.info("修改的数据"+record);
        return resultBean;
    }

    @ResponseBody
    @RequestMapping(value = "/first/{id}", method = RequestMethod.DELETE)
    public ResultBean deleteBanner(@PathVariable Long id) {
        logger.info("----删除方法被调用-----");
        logger.info("：删除数据的id为" + id);
        ResultBean resultBean = new ResultBean();
        int x = firstWorkService.deleteByPrimaryKey(id);
        if (x == 0) {
            resultBean.setCode(-1);
            resultBean.setMsg("删除失败");
        } else {
            resultBean.setCode(200);
            resultBean.setMsg("删除成功");
        }
        logger.info("删除的ID："+id);
        return resultBean;
    }

//    @ResponseBody
//    @RequestMapping(value = "/first/{id}", method = RequestMethod.GET)
//    public ResultBean getId(@PathVariable Long id){
//        logger.info("：获取传参id为："+id);
//        ResultBean resultBean = new ResultBean();
//        SecondWork record = secondWorkService.selectByPrimaryKey(id);
//        logger.info("结果"+record);
//        if (record == null){
//            resultBean.setCode(-1);
//            resultBean.setMsg("查询ID失败");
//
//        } else {
//            resultBean.setCode(200);
//            resultBean.setMsg("查询ID成功");
//            resultBean.setData(record);
//        }
//        return resultBean;
//    }
}
