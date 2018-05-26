package serviceImpl;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import dao.UserMapper;

import dao.UserRoleMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import pojo.User;
import service.UserService;
import shiro.ShiroToken;
import utils.*;
import utils.json.JsonResult;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRoleMapper userRoleMapper;
    //金山云上传工具
    @Autowired
    Ossutils ossutils;
    //七牛云上传工具
    QiniuyunUtils qiniuyunUtils = new QiniuyunUtils();


    /**
     *手机注册验证
     * @param httpSession 取session中的验证码
     * @param phonecode 用户输入的验证码
     * @return 判断正确错误
     */
    public JsonResult testphonecode(HttpSession httpSession, String phonecode, @RequestParam User user, HttpServletRequest httpServletRequest) {
        //取出发送验证码的时间戳
        String str = (String) httpSession.getAttribute("phonecode");
        String[] array = str.split("\\.");
        //获取系统当前时间戳
        Long time = System.currentTimeMillis();
        //比较两个时间戳,有效时间5分钟
        if (!phonenumbertest(user)) {
            return new JsonResult(-1, "手机号已被注册", null);
        }
        if ((time - Long.valueOf(array[1])) > 1000 * 60 * 5) {
            return new JsonResult(-1, "验证码过期", null);
        }
        if (!array[0].equals(phonecode)) {
            return new JsonResult(-1, "验证码错误", null);
        }
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) httpServletRequest;
        String fileName =  multipartHttpServletRequest.getFile("photo").getOriginalFilename();
        String[] filename = fileName.split("\\.");
        String fileName1 = user.getName()+"headimage"+System.currentTimeMillis()+"."+filename[filename.length-1];
        if (!ossutils.uploadimage(multipartHttpServletRequest.getFile("photo"),user,fileName1)) {
            return new JsonResult(-1, "图片上传失败", null);
        }
        if (!nametest(user)) {
            return new JsonResult(-1, "用户名已存在", null);
        }
        try {
            user.setImage(fileName1);
            user.setCreateTime(System.currentTimeMillis());
            //把用户角色写死
            Long id = insert(user);
            userRoleMapper.insert(id,4L);
            logger.info("用户注册成功{}", user);
            return new JsonResult(0, "处理成功", null);
        }
        catch (Exception e) {
            logger.info("注册失败" + e.getMessage(), e);
            return new JsonResult(-1, "注册失败", null);
        }
    }

    /**
     * 手机验证码生成
     * @param httpSession 存放验证码
     * @param user
     * @return Json对象
     */
    public JsonResult phonecode(HttpSession httpSession, User user){
        String phonecode = String.valueOf(RandomUtils.randomnumber(1000,10000));
        try {
            SendSmsResponse sendSmsResponse=MobileUtils.sendSms(user.getPhonenumber(),phonecode);
            if (sendSmsResponse.getCode().equals("isv.MOBILE_NUMBER_ILLEGAL")){
                logger.info("非法手机号:"+user.getPhonenumber()+"短信发送失败");
                return new JsonResult(-1,"非法手机号",null);
            }
            else if (sendSmsResponse.getCode().equals("OK")){
                logger.info("短信发送成功");
                //设置有效期限（5分钟）
                String time = String.valueOf(System.currentTimeMillis());
                httpSession.setAttribute("phonecode",phonecode+"."+time);
                return new JsonResult(0,"处理成功",phonecode);
            }
            else {
                logger.info(sendSmsResponse.getMessage());
                return new JsonResult(-1,"短信发送错误",null);
            }
        }
        catch (ClientException e) {
            logger.info("短信发送错误:"+e.getErrMsg());
            return new JsonResult(-1,"未知错误",null);
        }
    }

    /**
     *邮箱验证码生成
     * @param user
     * @return
     */
    public JsonResult emailcode(HttpSession httpSession,User user){
        String emailcode = String.valueOf(RandomUtils.randomnumber(1000,10000));
        try {
            EmailUtils.send_template(user,emailcode);
            //设置有效期限（5分钟）
            String time = String.valueOf(System.currentTimeMillis());
            httpSession.setAttribute("emailcode",emailcode+"."+time);
            return new JsonResult(0,"处理成功",null);
        }
        catch (IOException e) {
            logger.info(e.getMessage());
            return new JsonResult(-1,"发送邮件异常",null);
        }
    }

    /**
     *邮箱注册验证
     * @param httpSession
     * @param emailcode
     * @param user
     * @return
     */
    public JsonResult testemailcode(HttpSession httpSession,String emailcode,User user){
        //取出发送验证码的时间戳
        String str = (String) httpSession.getAttribute("emailcode");
        String[] array = str.split("\\.");
        //获取系统当前时间戳
        Long time = System.currentTimeMillis();
        //比较两个时间戳,有效时间5分钟
        if (!emailtest(user)) {
            return new JsonResult(-1, "邮箱已被注册", null);
        }
        if ((time - Long.valueOf(array[1])) > 1000 * 60 * 5) {
            return new JsonResult(-1, "验证码过期", null);
        }
        if (!array[0].equals(emailcode)) {
            return new JsonResult(-1, "验证码错误", null);
        }
        if (!nametest(user)) {
            return new JsonResult(-1, "用户名已存在", null);
        }
        try {
            insert(user);
            logger.info("用户注册成功{}", user);
            return new JsonResult(0, "注册成功", null);
        }
        catch (Exception e) {
            logger.info("用户注册失败{}", user);
            return new JsonResult(-1, "注册失败", null);
        }
    }

    /**
     * 普通注册验证（验证码由controller生成）
     * @param httpSession
     * @param signcode
     * @param user
     * @return
     */
    public JsonResult testcommon(User user,String signcode,HttpSession httpSession){
        // 取出sesson中的验证码
        String signcodeSession = (String) httpSession.getAttribute("signcode");
        //如果验证码检验通过
        if (!signcodeSession.equalsIgnoreCase(signcode)) {
            return new JsonResult(-1, "验证码错误", new Date());
        }
        //验证用户名是否存在
        if (!nametest(user)) {
            return new JsonResult(-1, "用户名已存在", new Date());
        }
        try {
            insert(user);
            return new JsonResult(0,"注册成功",null);
        }
        catch (Exception e) {
            logger.error("异常"+e.getMessage(),e);
            return new JsonResult(-1,"未知错误",null);
        }
    }

    /**
     * 手机快捷登陆验证
     * @param user  手机号码
     * @param phonecode   手机验证码
     * @param httpSession
     * @return
     */
    public JsonResult phonelogin(User user,@RequestParam("phonecode") String phonecode,HttpSession httpSession){
        //取出发送验证码的时间戳
        String str = (String) httpSession.getAttribute("phonecode");
        String[] array = str.split("\\.");
        //获取系统当前时间戳
        Long time = System.currentTimeMillis();
        //比较两个时间戳,有效时间5分钟
        if (!phonenumbertest(user)) {
            return new JsonResult(-1, "手机号不存在", null);
        }
        if ((time - Long.valueOf(array[1])) > 1000 * 60 * 5) {
            return new JsonResult(-1, "验证码过期", null);
        }
        if (!array[0].equals(phonecode)) {
            return new JsonResult(-1, "验证码错误", null);
        }
        else  return new JsonResult(0,"登陆成功",null);
    }

    /**
     * 邮箱快捷登陆验证
     * @param user 用户名和密码
     * @param emailcode 邮箱验证码
     * @param httpSession
     * @param signcode 图形验证码
     * @return
     */
    public JsonResult emaillogin(User user,String emailcode,HttpSession httpSession,String signcode) {
        String signcodeSession = (String) httpSession.getAttribute("signcode");
        //如果验证码检验通过
        if (!signcodeSession.equalsIgnoreCase(signcode)) {
            return new JsonResult(-1, "图形验证码错误", null);
        }
        //取出发送验证码的时间戳
        String str = (String) httpSession.getAttribute("emailcode");
        String[] array = str.split("\\.");
        //获取系统当前时间戳
        Long time = System.currentTimeMillis();
        //比较两个时间戳,有效时间5分钟
        if (!emailtest(user)) {
            return new JsonResult(-1, "邮箱不存在", null);
        }
        if ((time - Long.valueOf(array[1])) > 1000 * 60 * 5) {
            return new JsonResult(-1, "验证码过期", null);
        }
        if (!array[0].equals(emailcode)) {
            return new JsonResult(-1, "验证码错误", null);
        }
        if (!emailpdtest(user)) {
            return new JsonResult(-1, "密码错误", null);
        }
        else return new JsonResult(0, "登陆成功", null);
    }

    /**
     * 普通登陆验证(shiro授权 记住我功能）
     * @param user
     * @param signcode
     * @param httpSession
     * @return
     */
    public JsonResult commonlogin(User user,@RequestParam("signcode") String signcode,HttpSession httpSession){
        String signcodeSession = (String) httpSession.getAttribute("signcode");
        //如果验证码检验通过
        if (!signcodeSession.equalsIgnoreCase(signcode)) {
            return new JsonResult(-1, "验证码错误", new Date());
        }
        User user1 = userMapper.selectbyname(user);
        //如果有这个用户
        if (user1 ==null) {
            return new JsonResult(-1, "用户名或密码错误", null);
        }
        //当前Subject
        Subject currentUser = SecurityUtils.getSubject();
        String password = Md5.passwordtest(user.getPassword(), user1.getSalt());
        ShiroToken shiroToken = new ShiroToken(user1.getName(), password);
        try {
            shiroToken.setRememberMe(true);
            currentUser.login(shiroToken);
            logger.info("登陆成功");
            return new JsonResult(0, "登陆成功", JSON.toJSONString(user1));
        }
        catch (AuthenticationException e) {//登录失败
            logger.info("登陆失败" + e.getMessage(), e);
            return new JsonResult(-1, "用户名或密码错误", null);
        }
    }
    /**
     * 普通4位验证码生成
     * @param httpSession
     * @param signcode
     * @return
     */
    public boolean signcodetest(HttpSession httpSession,String signcode){
        String signcodeSession = (String) httpSession.getAttribute("signcode");
        if (signcode.equalsIgnoreCase(signcodeSession)){
            return true;
        }
        else return false;
    }

    /**
     * 用户名检测
     * @param user
     * @return 和数据库中不重复返回true
     */
    public boolean nametest(User user){
       if (userMapper.selectbyname(user)!=null){
           return false;
       }
       else return true;
    }

    /**
     *邮箱检测
     * @param user
     * @return 和数据库中不重复返回true
     */
    public boolean emailtest(User user){
        if (userMapper.selectbyemail(user)!=null){
            return false;
        }
        else return true;
    }

    /**
     * 手机号检测
     * @param user
     * @return 和数据库中不重复返回true
     */
    public boolean phonenumbertest(User user){
        if (userMapper.selectbyphonenumber(user)!=null){
            return false;
        }
        else return true;
    }

    /**
     * 邮箱和密码是否匹配
     * @param user 邮箱、密码
     * @return 匹配则返回true
     */
    public boolean emailpdtest(User user){
        String salt = userMapper.selectbyemail(user).getSalt();
        Md5 md5 = new Md5();
        String pd = Md5.passwordtest(user.getPassword(), salt);
        return pd.equals(userMapper.selectbyemail(user).getPassword());
    }

    /**
     * 用户名、密码匹配检测
     * @param user
     * @return 和数据库密码一样返回true
     */
    public boolean passwordtest(User user) {
        String salt = userMapper.selectbyname(user).getSalt();
        Md5 md5 = new Md5();
        String pd = Md5.passwordtest(user.getPassword(), salt);
        return pd.equals(userMapper.selectbyname(user).getPassword());
    }

    /**
     * MD5加盐生成加密用户插入用户
     * @param user
     * @throws Exception
     */
    public Long insert(User user) throws Exception{
        //创建用户之后不会直接登陆
        user.setCreateTime(System.currentTimeMillis());
        String user_password = user.getPassword();
        Md5 md5 = new Md5();
        List<String> list = md5.passwordsalt(user_password);
        user.setPassword(list.get(1));
        user.setSalt(list.get(0));
        userMapper.insert(user);
        Long id = user.getId();
        return id;
    }
}
