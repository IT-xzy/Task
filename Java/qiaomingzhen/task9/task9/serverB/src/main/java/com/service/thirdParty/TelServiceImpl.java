package com.service.thirdParty;
/*
 * @ClassName:TelServiceImpl
 * @Description:TODO
 * @Author qiao
 * @Date 2018/9/13 13:41
 **/

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.model.Code;
import com.service.TelCodeService;
import com.util.task7.DayUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Random;

public class TelServiceImpl implements TelService {

    private static Logger logger = Logger.getLogger("TelServiceImpl.class");
    private String accountSid;
    private String accountToken;
    private String serverIp;
    private String serverPort;
    private String appId;
    private String templateId;
    private String time;
    @Autowired
    private TelCodeService telCodeService;



    public TelServiceImpl(String accountSid, String accountToken, String serverIp, String serverPort, String appId, String templateId, String time) {
        this.accountSid = accountSid;
        this.accountToken = accountToken;
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        this.appId = appId;
        this.templateId = templateId;
        this.time = time;
    }

    public String getRangCode() {
        return String.valueOf(100000 + new Random().nextInt(899999));
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
            Code code = telCodeService.findTel(tel);
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
                telCodeService.addTel(code);
            } else {
                //不一致，更新手机号信息
                telCodeService.updateSum(code);
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
        Code code = telCodeService.findTel(tel);
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

    @Override
    public void checkService() {

    }
}


