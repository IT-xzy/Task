package jnshu.tool.api;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.apache.log4j.Logger;
import org.json.JSONException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


/**
 * @author zgy
 */
public class Sms {

    private static Logger logger = Logger.getLogger (Sms.class);

    private int appid;//短信应用SDK AppID

    private String appkey;//短信应用SDK AppKey

    private int templateId;//短信模板ID，需要在短信应用中申请

//    private String smsSign;//签名


    /**
     * @param telNum 输入电话号码
     * @return 1 或者 0
     */
    public int smsUtil(String telNum, String num) {
        logger.info (appid + "," + appkey);
        logger.info ("开始短信验证码发送");

        int rs = 0;
        // 需要发送短信的手机号码
        String[] phoneNumbers = {telNum};
        try {
            String[] params = {num, "5"};
            SmsSingleSender ssender = new SmsSingleSender (appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam ("86", phoneNumbers[0],
// 签名参数未提供或者为空时，会使用默认签名发送短信
                    templateId, params, "", "", "");

            System.out.println (result);
            logger.info ("短信验证码发送完毕");

//            成功则返回1
            rs = 1;
        } catch ( HTTPException e ) {
            // HTTP响应码错误
            e.printStackTrace ();
        } catch ( JSONException e ) {
            // json解析错误
            e.printStackTrace ();
        } catch ( IOException e ) {
            // 网络IO错误
            e.printStackTrace ();
        }
        return rs;
    }

    public void setAppid(int appid) {
        this.appid = appid;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }
//
//    public void setSmsSign(String smsSign)  {
////给字符串转码
//        this.smsSign = smsSign;
//    }
}
