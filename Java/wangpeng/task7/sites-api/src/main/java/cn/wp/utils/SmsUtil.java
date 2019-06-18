package cn.wp.utils;

import com.cloopen.rest.sdk.CCPRestSmsSDK;

import java.util.HashMap;
import java.util.Set;

/** @ClassName: @Description: @Author: 老王 @Date: 2019/6/12 16:22 @Version: 1.0 */
public class SmsUtil {

  private String accountSid;
  private String accountToken;
  private String serverIp;
  private String serverPort;
  private String appId;
  private String templateId;
  private String time;

  public SmsUtil(
      String accountSid,
      String accountToken,
      String serverIp,
      String serverPort,
      String appId,
      String templateId,
      String time) {
    this.accountSid = accountSid;
    this.accountToken = accountToken;
    this.serverIp = serverIp;
    this.serverPort = serverPort;
    this.appId = appId;
    this.templateId = templateId;
    this.time = time;
  }

  public String setSms(String code, String phone) {
    HashMap<String, Object> result = null;
    // 初始化SDK
    CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
    // 初始化服务器地址和代码
    restAPI.init(serverIp, serverPort);
    // 初始化主账号和主账号令牌
    restAPI.setAccount(accountSid, accountToken);
    // 初始化应用id
    restAPI.setAppId(appId);
    // 调用发送模板短信的接口发送短信
    result = restAPI.sendTemplateSMS(phone, templateId, new String[] {code, time});

    System.out.println("SDKTestGetSubAccounts result=" + result);
    if ("000000".equals(result.get("statusCode"))) {
      // 正常返回输出data包体信息（map）
      HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
      Set<String> keySet = data.keySet();
      for (String key : keySet) {
        Object object = data.get(key);
        System.out.println(key + " ==== " + object);
      }
    } else {
      // 异常返回输出错误码和错误信息
      System.out.println("错误码:" + result.get("statusCode") + " 错误信息: " + result.get("statusMsg"));
    }
    return phone;
  }
}
