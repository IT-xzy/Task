package com.jnshu.controller;

import jnshu.model.Code;
import jnshu.model.User;
import jnshu.service.CodeService;
import jnshu.service.UserService;
import jnshu.util.SendCloudUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.List;
import java.util.Random;

@Controller
public class EmailController {
     Logger logger = Logger.getLogger(MessageController.class);
    @Autowired
    SendCloudUtil sendCloudUtil;

    @Autowired
    CodeService codeService;

    @Autowired
    UserService userService;


    @RequestMapping(value = "/messagemail", method = RequestMethod.GET)
    public String message() {
        return "jsf/message";
    }



    @RequestMapping(value = "/messagemail", method = RequestMethod.POST)
    public String getmessage(String phone) throws IOException {

        logger.info("email==================" + phone);
        Random random = new Random();
        String code = String.valueOf(random.nextInt(900000) + 100000);
        logger.info("code==================" + code);
        if (!ObjectUtils.isEmpty(phone)) {
            logger.info("email=====" + phone + "code====" + code);

            sendCloudUtil.send_common(phone, code);

            logger.info("input sengcloud");
            logger.info("email=====" + phone + "code====" + code);
            Boolean a = codeService.insert(phone,code);
            logger.info("input db code" + a);
            return "jsf/register";

        } else {
            logger.info("not email ");
            return "jsf/message";
        }
    }

    @RequestMapping(value = "/registermail", method = RequestMethod.POST)
    public String register(String code, String phone,String name,String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        logger.info("user===========" + user);
        if (!ObjectUtils.isEmpty(code)
                && !ObjectUtils.isEmpty(phone)
                && !ObjectUtils.isEmpty(user)) {
            List<Code> cod = codeService.selectByCode(phone, code);
            logger.info("cod===============" + cod);
            if (!ObjectUtils.isEmpty(cod)) {
                logger.info("yan zheng ma  zheng que");
                Boolean b = userService.insert(user);
                logger.info("input db user" + user);
                return "jsf/success";

            } else {
                logger.info(" code mei you zhe tiao shu jv ");
                return "jsf/message";
            }


        } else {
            logger.info("shu jv bu qvan ");
            return "jsf/message";
        }
    }

}
