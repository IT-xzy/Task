package jnshu.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import jnshu.model.Production;
import jnshu.model.Return;
import jnshu.service.MenuService;
import jnshu.service.ProductionService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ControllerOne {
    private static Logger logger = Logger.getLogger (ControllerOne.class);//引入日志配置
    @Resource
    MenuService menuService;
    @Resource
    ProductionService productionService;
    long timeStamp = System.currentTimeMillis ();//获取当前时间戳

    //    查询banner信息
    @ResponseBody
    @RequestMapping(value = "/banner", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String SelectBanner() {
        List rt = menuService.selectBanner ();
        String rs = JSON.toJSONString (rt);
        logger.info (rs);
        return rs;
    }

    //    查询菜单信息
    @ResponseBody
    @RequestMapping(value = "/menu", method = RequestMethod.GET, produces = "text/html;charset=utf-8")
    public String selectMenu() {
        List rt = menuService.selectMenu ();
        String rs = JSON.toJSONString (rt);
        logger.info (rs);
        return rs;
    }

    //    查询作品简单信息
    @ResponseBody
    @RequestMapping(value = "/production", method = RequestMethod.GET)
    public Return selectProduction(int currentPage, int pageSize) {
//
        logger.info (currentPage+","+pageSize);
        List rs = productionService.selectProduction (currentPage, pageSize);
        logger.info (rs);
        PageInfo<List> pageInfo = new PageInfo<List> (rs);
        long total=pageInfo.getTotal ();
        Map ra = new HashMap ();
        ra.put ("productionData", rs);
        Return rb = new Return ();
        rb.setCode (1);
        rb.setData (ra);
        rb.setTotal (total);
        logger.info (JSON.toJSONString (rb));
        return rb;
    }

    //    关键字查询
    @ResponseBody
    @RequestMapping(value = "/keyword", method = RequestMethod.GET)
    public Return selectProduction(int currentPage, int pageSize, String data) {
        logger.info (currentPage+","+pageSize+","+data);
        List rs = productionService.selectKeyword (currentPage, pageSize, data);
        logger.info (JSON.toJSONString (rs));
        PageInfo<List> pageInfo = new PageInfo<List> (rs);
        long total=pageInfo.getTotal ();
        Map rt = new HashMap ();
        rt.put ("keywordData", rs);
        Return rb = new Return ();
        rb.setCode (1);
        rb.setData (rt);
        rb.setTotal (total);
        logger.info (JSON.toJSONString (rb));
        return rb;
    }

    //查询二级菜单对应的作品信息
    @ResponseBody
    @RequestMapping(value = "/submenu", method = RequestMethod.GET)
    public Return selectSubmenu(int currentPage, int pageSize, int submenuId) {
        logger.info (currentPage+","+pageSize+","+submenuId);
        List rs = productionService.selectSubmenu (currentPage, pageSize, submenuId);
//        String rt = JSON.toJSONString (rs);
        PageInfo<List> pageInfo = new PageInfo<> (rs);
        Map rt = new HashMap ();
        rt.put ("submenuData",rs );
        Return rb = new Return ();
        rb.setTotal (pageInfo.getTotal ());
        rb.setData (rt);
        logger.info (rb.toString ());
        return rb;
    }
//查询作品详细信息
    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Return selectProductionDetail (int productionId) {
        logger.info (productionId);
        Production rs = productionService.selectProductionDetail (productionId);
        String st = JSON.toJSONString (rs);
        logger.info (st);
        Map rt = new HashMap ();
        rt.put ("detailData",rs );
        Return rb = new Return ();
        rb.setData (rt);
        logger.info (rb.toString ());
        return rb;
    }
}
