package com.mutesaid.controller;


import com.mutesaid.model.Expert;
import com.mutesaid.model.Response;
import com.mutesaid.service.ExpertService;
import com.mutesaid.utils.AccessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Slf4j
public class ExpertController {
    @Resource
    private AccessService accessService;

    @RequestMapping(value = "/a/expert", method = RequestMethod.GET)
    @ResponseBody
    public Response findList() {
        List<Expert> expertList = accessService.getExpertService().findList();
        log.info("select expert list size = {}", expertList.size());
        return new Response<>(0, "success", expertList);
    }
}
