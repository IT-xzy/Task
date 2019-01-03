package com.mutesaid.controller;

import com.mutesaid.model.Response;
import com.mutesaid.service.ProfessionService;
import com.mutesaid.utils.AccessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class ProfessionController {
    @Resource
    private AccessService accessService;

    @RequestMapping(value = "/a/profession", method = RequestMethod.GET)
    @ResponseBody
    public Response findPofessionList() {
        Map<String, List> professionList = accessService.getProfessionService().findProfessionList();
        return new Response<>(0, "success", professionList);
    }
}
