package com.jnshu.controller;

import com.jnshu.pojo.Reply;
import com.jnshu.pojo.ResultBean;
import com.jnshu.service.ReplyService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/21 - 17:12
 */
@Controller
public class ReplyController {
    private static Logger logger = Logger.getLogger(ReplyController.class);

    @Autowired
    ReplyService replyService;

    @ResponseBody
    @RequestMapping(value = "/reply",method = RequestMethod.GET)
    public ResultBean selectByDynamic(@RequestParam(value = "id",required = false) long id,
                                      @RequestParam(value = "replyName", required = false) String replyName){
        logger.info(id+","+replyName);
        logger.info("-----查询被调用-----");
        ResultBean resultBean = new ResultBean();
        List<Reply> reply = replyService.selectByDynamic(id,replyName);
        if (reply == null || reply.size() == 0){
            resultBean.setCode(-1);
            resultBean.setMsg("查询全部失败");
            resultBean.setData("无法查找结果");
        }else {
            resultBean.setCode(200);
            resultBean.setMsg("查询全部成功");
            resultBean.setData(reply);
        }
        logger.info("：查询结果"+reply);
        return resultBean;
    }

    @ResponseBody
    @RequestMapping(value = "/reply",method = RequestMethod.POST)
    public ResultBean insertBanner(Reply record) {
        logger.info("----添加被调用-----");
        logger.info("：添加的数据" + record);
        ResultBean resultBean = new ResultBean();
        int x = replyService.insert(record);
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
    @RequestMapping(value = "/reply/{id}", method = RequestMethod.PUT)
    public ResultBean updateBanner(@RequestParam Long id, Reply record) {
        logger.info("----更新方法被调用-----");
        logger.info("：更新内容" + record);
        ResultBean resultBean = new ResultBean();
        int x = replyService.updateByPrimaryKey(record);
        if (x == 0) {
            resultBean.setCode(-1);
            resultBean.setMsg("修改失败");
        } else {
            resultBean.setCode(200);
            resultBean.setMsg("修改成功");
        }
        logger.info("更新的内容"+record);
        return resultBean;
    }

    @ResponseBody
    @RequestMapping(value = "/reply/{id}", method = RequestMethod.DELETE)
    public ResultBean deleteBanner(@PathVariable Long id) {
        logger.info("----删除方法被调用-----");
        logger.info("：删除数据的id为" + id);
        ResultBean resultBean = new ResultBean();
        int x = replyService.deleteByPrimaryKey(id);
        if (x == 0) {
            resultBean.setCode(-1);
            resultBean.setMsg("删除失败");
        } else {
            resultBean.setCode(200);
            resultBean.setMsg("删除成功");
        }
        logger.info("删除的ID"+id);
        return resultBean;
    }

    @ResponseBody
    @RequestMapping(value = "/reply/{id}", method = RequestMethod.GET)
    public ResultBean getId(@PathVariable Long id){
        logger.info("：获取传参id为："+id);
        ResultBean resultBean = new ResultBean();
        Reply record = replyService.selectByPrimaryKey(id);
        logger.info("结果"+record);
        if (record == null){
            resultBean.setCode(-1);
            resultBean.setMsg("查询ID失败");

        } else {
            resultBean.setCode(200);
            resultBean.setMsg("查询ID成功");
            resultBean.setData(record);
        }
        logger.info("查询的ID"+id);
        return resultBean;
    }
}
