package com.util.task7;
/*
 * @ClassName:NoteUtil
 * @Description:TODO
 * @Author qiao
 * @Date 2018/8/23 14:38
 **/

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.mapper.TelCodeMapper;
import com.model.Code;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Random;


public class NoteUtil {

    private static Logger logger = Logger.getLogger("NoteUtil.class");
    private String accountSid;
    private String accountToken;
    private String serverIp;
    private String serverPort;
    private String appId;
    private String templateId;
    private String time;
    @Autowired
    private TelCodeMapper telCodeMapper;

    public static String getRangCode() {
        return String.valueOf(100000 + new Random().nextInt(899999));
    }

    public NoteUtil(String accountSid, String accountToken, String serverIp, String serverPort, String appId, String templateId, String time) {
        this.accountSid = accountSid;
        this.accountToken = accountToken;
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        this.appId = appId;
        this.templateId = templateId;
        this.time = time;
    }

    public boolean sendNote(String tel, String rand_Code) {
        boolean b = false;
        try {
            HashMap<String, Object> result = null;
            //初始化SDK
            CCPRestSmsSDK restAPI = new CCPRestSmsSDK();

            restAPI.init(serverIp, serverPort);

            restAPI.setAccount(accountSid, accountToken);

            restAPI.setAppId(appId);

//            result = restAPI.sendTemplateSMS(tel, templateId, new String[]{rand_Code, time});
            result = restAPI.sendTemplateSMS(tel, templateId, new String[]{rand_Code, time});

            System.out.println("SDKTestGetSubAccounts result=" + result);
            if ("000000".equals(result.get("statusCode"))) {
                b = true;
            } else {
                //异常返回输出错误码和错误信息
                logger.error("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return b;
    }

    /**
     * @param rand_Code, key]
     * @return boolean
     * @mathodName checkNote
     * @Description 短信验证码验证
     * @date 2018/8/25 20:12
     */
    public boolean checkRandCode(String rand_Code, long tel) {
        try {
            Code code = telCodeMapper.findTel(tel);
            logger.info(code.toString());
            //数据库中tel和randCode验证
            if (rand_Code.equals(String.valueOf(code.getTelCode()))) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param
     * @return com.util.Result
     * @mathodName getRandCode
     * @Description 发送验证码
     * @date 2018/8/25 20:11
     */
    public boolean sendRandCode(Code code, String rand_Code) {
        boolean b = false;
        System.out.println(code.toString());
        //发送短信验证码
        if (this.sendNote(String.valueOf(code.getTel()), rand_Code)) {
            logger.info("success!");
            code.setTelCode(rand_Code);
            //添加验证码到数据库
            if (code.getUpdateTime() == code.getCreatTime()) {
                //创建时间和更新时间一致，新增手机号信息
                telCodeMapper.addTel(code);
            } else {
                //不一致，更新手机号信息
                telCodeMapper.updateSum(code);
            }
            b = true;
        }
        return b;
    }

    /**
     * @param tel, rand_Code]
     * @return boolean
     * @mathodName checkTelSum
     * @Description 判断手机号，是否允许发送
     * @date 2018/9/8 20:54
     */
    public Code checkTelSum(long tel) {
        logger.info(tel);
        Code code = telCodeMapper.findTel(tel);
        if (code == null) {
            //code为null，设置次数为1
            long time = System.currentTimeMillis();
            return new Code().setTel(tel).setCreatTime(time).setUpdateTime(time).setTelSum(1);
        }
        if (!DayUtils.IsToday(code.getUpdateTime())) {
            //code时间不为当天，设置次数为1
            code.setUpdateTime(System.currentTimeMillis());
            code.setTelSum(1);
            return code;
        }
        if (code.getTelSum() < 5) {
            //code次数小于5，设置次数 +1
            code.setTelSum(code.getTelSum() + 1);
            return code;
        }
        return null;
    }
}
//
//        logger.info(tel);
//        Code code = new Code();
//        logger.info(code.toString());
//        boolean b = true;
//
//        //数据库根据tel查询
//        if (telCodeMapper.findTel(tel) == null) {
//            //手机号不存在，新增tel记录，次数为1
//            logger.info(code.toString());
//            code = this.sendRandCode(tel, rand_Code);
//            code.setTelSum(1);
//            telCodeMapper.addTel(code);
//        } else {
//            code = telCodeMapper.findTel(tel);
//            code.setTel(tel);
//            long day = code.getUpdateTime();
//            code.setUpdateTime(System.currentTimeMillis());
//            int sum = code.getTelSum();
//            if ( {
//                //更新时间为当天，次数+1
//                if (sum < 3) {
//                    code = this.sendRandCode(tel, rand_Code);
//                    //手机号存在，次数小于5
//                    code.setTelSum(sum + 1);
//                    System.out.println(code.toString());
//                    logger.info(code.toString());
//                    telCodeMapper.updateSum(code);
//                } else {
//                    //次数大于5，返回false
//                    b = false;
//                }
//            } else {
//                code = this.sendRandCode(tel, rand_Code);
//                //更新时间不为当天，次数设为1
//                code.setTelSum(1);
//                System.out.println(code.toString());
//                logger.info(code.toString());
//                telCodeMapper.updateSum(code);
//            }
//        }
//        return b;
//    }

//}
