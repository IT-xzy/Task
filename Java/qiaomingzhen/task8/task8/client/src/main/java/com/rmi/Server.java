package com.rmi;
/*
 * @ClassName:Server
 * @Description:TODO
 * @Author qiao
 * @Date 2018/9/11 22:18
 **/

import com.service.CompanyService;
import com.service.ProfService;
import com.service.TelCodeService;
import com.service.UserService;
import com.service.thirdParty.EmailService;
import com.service.thirdParty.QiNiuService;
import com.service.thirdParty.TelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class Server {

    @Autowired
    ServerA serverA;
    @Autowired
    ServerB serverB;

    //获取随机1、2
    int getRandom() {
        Random random = new Random();
        return random.nextInt(2) + 1;
    }

    //通过随机数确定加载顺序
    Map getServer() {
        Map map = new HashMap();
        if (this.getRandom() == 1) {
            map.put("server1", serverA);
            map.put("server2", serverB);
        } else {
            map.put("server1", serverB);
            map.put("server2", serverA);
        }
        return map;
    }


    //通过try catch，捕获异常，切换Service
    public UserService getUserService() {
        Map map = this.getServer();
        RMIServer rmiServer;
        UserService userService;
        try {
            rmiServer = (RMIServer) map.get("server1");
            userService = rmiServer.getUserService();
            //验证是否报空指针
            userService.checkService();
//            rmiServer.getName();
//            return userService;
        } catch (Exception e) {
            rmiServer = (RMIServer) map.get("server2");
            userService = rmiServer.getUserService();
            userService.checkService();
//            rmiServer.getName();
//            return userService;
        }

        return userService;
    }

    public TelCodeService getTelCodeService() {
        Map map = this.getServer();
        RMIServer rmiServer;
        TelCodeService telCodeService;
        try {
            rmiServer = (RMIServer) map.get("server1");
            telCodeService = rmiServer.getTelCodeService();
            //验证是否报空指针
            telCodeService.checkService();
            rmiServer.getName();
            return telCodeService;
        } catch (Exception e) {
            rmiServer = (RMIServer) map.get("server2");
            telCodeService = rmiServer.getTelCodeService();
            telCodeService.checkService();
            rmiServer.getName();
            return telCodeService;
        }
    }

    public ProfService getProfService() {
        Map map = this.getServer();
        RMIServer rmiServer;
        ProfService profService;
        try {
            rmiServer = (RMIServer) map.get("server1");
            profService = rmiServer.getProfService();
            //验证是否报空指针
            profService.checkService();

            rmiServer.getName();
            return profService;
        } catch (Exception e) {
            rmiServer = (RMIServer) map.get("server2");
            profService = rmiServer.getProfService();
            profService.checkService();
            rmiServer.getName();
            return profService;
        }
    }

    public CompanyService getCompanyService() {
        Map map = this.getServer();
        RMIServer rmiServer;
        CompanyService companyService;
        try {
            rmiServer = (RMIServer) map.get("server1");
            companyService = rmiServer.getCompanyService();
            //验证是否报空指针
            companyService.checkService();
            rmiServer.getName();
            return companyService;
        } catch (Exception e) {
            rmiServer = (RMIServer) map.get("server2");
            companyService = rmiServer.getCompanyService();
            companyService.checkService();
            rmiServer.getName();
            return companyService;
        }
    }

    public EmailService getEmailService() {
        Map map = this.getServer();
        RMIServer rmiServer;
        EmailService emailService;
        try {
            rmiServer = (RMIServer) map.get("server1");
            emailService = rmiServer.getEmailService();
            //验证是否报空指针
            emailService.checkService();
            rmiServer.getName();
            return emailService;
        } catch (Exception e) {
            rmiServer = (RMIServer) map.get("server2");
            emailService = rmiServer.getEmailService();
            emailService.checkService();
            rmiServer.getName();
            return emailService;
        }
    }

    public QiNiuService getQiNiuService() {
        Map map = this.getServer();
        RMIServer rmiServer;
        QiNiuService qiNiuService;
        try {
            rmiServer = (RMIServer) map.get("server1");
            qiNiuService = rmiServer.getQiNiuService();
            //验证是否报空指针
            qiNiuService.checkService();
            rmiServer.getName();
            return qiNiuService;
        } catch (Exception e) {
            rmiServer = (RMIServer) map.get("server2");
            qiNiuService = rmiServer.getQiNiuService();
            qiNiuService.checkService();
            rmiServer.getName();
            return qiNiuService;
        }
    }

    public TelService getTelService() {
        Map map = this.getServer();
        RMIServer rmiServer;
        TelService telService;
        try {
            rmiServer = (RMIServer) map.get("server1");
            telService = rmiServer.getTelService();
            //验证是否报空指针
            telService.checkService();
            rmiServer.getName();
            return telService;
        } catch (Exception e) {
            rmiServer = (RMIServer) map.get("server2");
            telService = rmiServer.getTelService();
            telService.checkService();
            rmiServer.getName();
            return telService;
        }
    }


}


//    TelCodeService telCodeService;
//    ProfService profService;
//    CompanyService companyService;
//    EmailService emailService;
//    QiNiuService qiNiuService;
//    TelService telService;


// switch (service) {
//         case "userService":
//         break;
//         case "telCodeService":
//         break;
//         case "profService":
//         break;
//         case "companySevice":
//         break;
//         case "emailService":
//         break;
//         case "qiNiuService":
//         break;
//         case "telService":
//         break;
//         }


//   switch (service) {
//           case "userService":
//           userService = rmiServer.getUserService();
//           break;
//           case "telCodeService":
//           telCodeService = rmiServer.getTelCodeService();
//
//           break;
//           case "profService":
//           profService = rmiServer.getProfService();
//
//           break;
//           case "companySevice":
//           companyService = rmiServer.getCompanyService();
//
//           break;
//           case "emailService":
//           emailService = rmiServer.getEmailService();
//
//           break;
//           case "qiNiuService":
//           qiNiuService = rmiServer.getQiNiuService();
//
//           break;
//           case "telService":
//           telService = rmiServer.getTelService();
//           break;
//           }