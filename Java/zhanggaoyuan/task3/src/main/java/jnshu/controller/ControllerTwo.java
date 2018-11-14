package jnshu.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import jnshu.model.Return;
import jnshu.model.Studio;
import jnshu.model.Visitor;
import jnshu.service.GuestbookService;
import jnshu.service.ProductionService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ControllerTwo {
    private static Logger logger = Logger.getLogger (ControllerOne.class);//引入日志配置
    long timeStamp = System.currentTimeMillis ();//获取当前时间戳

    @Resource
    GuestbookService guestbookService;
    @Resource
    ProductionService productionService;

    //查询留言信息
    @ResponseBody
    @RequestMapping(value = "/guestbook", method = RequestMethod.GET)
    public Return selectGuestbook(int currentPage, int pageSize, int productionId) {
        logger.info (currentPage + "," + pageSize + "," + productionId);
        List rs = guestbookService.selectGuestbook (currentPage, pageSize, productionId);
        logger.info (rs);

        PageInfo<List> pageInfo = new PageInfo<> (rs);
        Map rt = new HashMap ();
        rt.put ("guestbookData",rs );
        Return rb = new Return ();
        rb.setData (rt);
        rb.setTotal (pageInfo.getTotal ());
        logger.info (JSON.toJSONString (rb));
        return rb;
    }

    //    新增留言
    @ResponseBody
    @RequestMapping(value = "/guestbook", method = RequestMethod.POST)
    public Return insertGuestbook(@RequestBody Visitor visitor) {
        visitor.setVisitorCreatTime (timeStamp);
        visitor.setUpdateTime (timeStamp);
        logger.info (JSON.toJSONString (visitor));
        int rs = guestbookService.insertVisitor (visitor);
        Return rb = new Return ();
        rb.setCode (rs);
        logger.info (rb);
        return rb;
    }

    //    查询工作室信息
    @ResponseBody
    @RequestMapping(value = "/studio", method = RequestMethod.GET)
    public Return selectStudio() {
        Studio rs = productionService.selectStudio ();
        logger.info (rs);
//        String rt0 = JSON.toJSONString (rs);
        logger.info (JSON.toJSONString (rs));
        Map rt = new HashMap ();
        rt.put ("studioData",rs );
        Return rb = new Return ();
        rb.setData (rt);
        logger.info (JSON.toJSONString (rb));
        return rb;
    }

    //    查询艺术家信息
    @ResponseBody
    @RequestMapping(value = "/artist", method = RequestMethod.GET)
    public Return selectArtist() {
        List rs = productionService.selectArtist ();
//        String rt = JSON.toJSONString (rs);
        logger.info (rs);
        Map rt = new HashMap ();
        rt.put ("artistData",rs );

        Return rb = new Return ();
        rb.setData (rt);
        logger.info (JSON.toJSONString (rb));
        return rb;
    }

    //    查询成员信息
    @ResponseBody
    @RequestMapping(value = "/worker", method = RequestMethod.GET)
    public Return selectWorker(int currentPage, int pageSize ) {
        logger.info (currentPage+","+pageSize);
        List rs=productionService.selectWorker ( currentPage,  pageSize);
//        String rt = JSON.toJSONString (rs);
        logger.info (rs);
        Map rt = new HashMap ();
        rt.put ("workerData",rs );

        PageInfo pageInfo = new PageInfo (rs);
        Return rb = new Return ();
        rb.setTotal (pageInfo.getTotal ());
        rb.setData (rt);
        logger.info (JSON.toJSONString (rb));
        return rb;
    }
}
