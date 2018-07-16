package com.controller;

import com.pojo.Shop;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class JSONController {
    @RequestMapping(value="/kfc/{name}", method = RequestMethod.GET)
  @ResponseBody
    public Shop getShopInJSON(@PathVariable String name) {
        System.out.println("-----请求json数据--------");
        Shop shop = new Shop();
        shop.setName(name);
        shop.setStaffName(new String[]{"mkyong1", "mkyong2"});
        return shop;

    }
}


