package com.artist.controller;
import com.artist.pojo.Message;
import com.artist.pojo.StatusCode;
import com.artist.service.MessageService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;

@Controller
public class MessageController {
    private Logger logger=Logger.getLogger(MessageController.class);
    @Resource(name = "messageServiceImpl")
    private MessageService messageService;
    @RequestMapping(value = "/production/message",method = RequestMethod.POST)
    @ResponseBody
    public StatusCode saveMessage(@RequestBody @Validated Message message){
        logger.info("saveMessage()");
        logger.info(message);
        String str =messageService.saveMessage(message);
        logger.info(str);
        StatusCode statusCode = new StatusCode();
        statusCode.setCode(200);
        statusCode.setMessage(str);
        return statusCode;
    }
}
