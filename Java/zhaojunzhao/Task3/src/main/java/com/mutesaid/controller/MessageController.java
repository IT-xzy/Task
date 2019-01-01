package com.mutesaid.controller;

import com.mutesaid.pojo.Message;
import com.mutesaid.service.MessageService;
import com.mutesaid.util.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private ResponseBo responseBo;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Map getMsgList(String workName, String status) {
        try{
            Boolean statusIn = (status==null || "".equals(status))?null:Integer.parseInt(status)!=0;
            String workNameIn = (workName==null || "".equals(workName))?null:workName;
            List<Message> msgList = messageService.getMsgList(workNameIn, statusIn);
            return responseBo.msg("sucess", msgList);
        }catch (Exception e){
            return responseBo.msg("fail");
        }


    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map getMsg(@PathVariable("id") String id) {
        try{
            Message msg = messageService.getMsg(Long.parseLong(id));
            return responseBo.msg("success", msg);
        }catch (Exception e){
            return responseBo.msg("fail");
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map deleteMsg(@PathVariable("id") String id) {
        try{
            messageService.deleteMsg(Long.parseLong(id));
            return responseBo.msg("success");
        }catch (Exception e){
            return responseBo.msg("fail");
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Map updateStatus(@PathVariable("id") String id) {
        try{
            messageService.updateStatus(Long.parseLong(id));
            return responseBo.msg("success");
        }catch (Exception e){
            return responseBo.msg("fail");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Map insertMsg(@RequestBody Map<String, String> map) {
        try{
            messageService.insertMsg(map.get("content"), Long.parseLong(map.get("workId")));
            return responseBo.msg("success");
        }catch (Exception e){
            return responseBo.msg("fail");
        }
    }
}
