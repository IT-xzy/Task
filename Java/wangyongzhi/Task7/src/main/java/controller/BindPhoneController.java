package controller;

import domain.entity.StuApply;
import domain.entity.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.StuApplyService;
import service.cache.util.MemcachedUtil;
import thirdApi.com.cloopen.util.SmsUtil;
import util.GetUserUtil;
import util.PhoneFormatCheckUtils;
import util.RandomCode;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 绑定手机号
 */
@Controller
@RequestMapping(value = "/")
public class BindPhoneController {
    private Logger logger = LoggerFactory.getLogger(BindPhoneController.class);


    @Autowired
    StuApplyService stuApplyService;
    @Autowired
    GetUserUtil getUserUtil;
    @Autowired
    MemcachedUtil memcachedUtil;
    @Autowired
    SmsUtil smsUtil;

    /**
     * 绑定手机号接口
     */
    @RequestMapping(value = "/u/bindPhone", method = RequestMethod.GET)
    public String getBindPhone() {
        return "bindData/bindPhone";
    }

    /**
     * 提交图形验证码并发送手机验证码
     */
    @RequestMapping(value = "/u/bindPhone", method = RequestMethod.POST)
    public String postBindPhone(@RequestParam String telephone, @RequestParam String imageCode, HttpServletRequest request, Model model) {

        Map map = new HashMap();

        //Session中存好的图形验证码数值
        String piccode = (String) request.getSession().getAttribute("piccode");

        //生成6位验证码
        String secureCode = RandomCode.getSixRandom();
        //如果手机号符合规格，把手机和验证码存入缓存，并跳转验证码输入页面
        if (PhoneFormatCheckUtils.isPhoneLegal(telephone)) {

            //查询手机号是否已经被绑定过
            if (stuApplyService.getByPhone(telephone) == null) {

                // 图片验证码判断
                if (imageCode.equals(piccode)) {

                    //获得username
                    Users user = getUserUtil.getUser(request);

                    String phone = user.getUsername() + "telephone";

                    String code = user.getUsername() + "code";

                    memcachedUtil.setValue(phone, 300, telephone);

                    memcachedUtil.setValue(code, 300, secureCode);

                    logger.info("telephone和code已经存入缓存");

                    //发送短信验证码
                    smsUtil.sendCode(telephone, secureCode);

                    return "bindData/inputCode";
                } else {
                    //验证失败返回提示
                    map.put("error", "图形验证码错误，请重新输入。");
                    model.addAttribute("map", map);
                    logger.info("Wrong imageCode!");
                }
            } else {
                map.put("warning", "手机号已经被绑定过，请重新输入");
                model.addAttribute("map", map);
                logger.info("This telephone has been binded!");
            }
        } else {
            map.put("warning", "您输入的手机号格式有误，请重新输入。");
            model.addAttribute("map", map);
            logger.info("This is not a phoneNumber!");
        }
        return "bindData/bindPhone";
    }

    /**
     * 验证手机验证码
     */
    @RequestMapping(value = "/u/verifycode", method = RequestMethod.POST)
    public String verifyCode(@RequestParam String secureCode, HttpServletRequest request, Model model) throws Exception {

        //获得username
        Users user = getUserUtil.getUser(request);
        String username = user.getUsername();

        String phone = user.getUsername() + "telephone";

        String code = user.getUsername() + "code";
        //取出缓存中的电话
        String telephone = (String) memcachedUtil.getValue(phone);
        //取出缓存中的code
        String verifycode = (String) memcachedUtil.getValue(code);

        //防止出现空指针异常
        if (verifycode != null && verifycode.equals(secureCode)) {
            StuApply stu = stuApplyService.getByUsername(username);
            stu.setTelephone(telephone);
            stuApplyService.updateByUsername(stu);
            logger.info("Binding successfully!");
            return "redirect:/u/showInfo";
        } else {
            Map map = new HashMap();
            map.put("warning", "验证码错误，请重新输入！");
            model.addAttribute("map", map);
            logger.info("Wrong verifycode!");
        }
        return "bindData/inputCode";
    }
}
