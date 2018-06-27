package serviceImpl;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import dao.PermissionMapper;
import dao.RoleMapper;
import dao.UserMapper;

import dao.UserRoleMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import pojo.Permission;
import pojo.Role;
import pojo.User;
import service.UserRmiService;
import shiro.ShiroToken;
import utils.*;
import utils.json.JsonResult;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class UserRmiServiceImpl implements UserRmiService {
    Logger logger = LoggerFactory.getLogger(UserRmiServiceImpl.class);
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    PermissionMapper permissionMapper;
    @Autowired
    RoleMapper roleMapper;
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
        if (phonenumbertest(user)) {
            if ((time - Long.valueOf(array[1])) < 1000 * 60 * 5) {
                if (array[0].equals(phonecode)) {
                    MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) httpServletRequest;
                    String fileName =  multipartHttpServletRequest.getFile("photo").getOriginalFilename();
                    String[] filename = fileName.split("\\.");
                    String fileName1 = user.getName()+"headimage"+System.currentTimeMillis()+"."+filename[filename.length-1];
                    if (ossutils.uploadimage(multipartHttpServletRequest.getFile("photo"),user,fileName1)) {
                        if (nametest(user)) {
                            try {
                                user.setImage(fileName1);
                                user.setCreateTime(System.currentTimeMillis());
                                //把用户角色写死
                                Long id = insert(user);
                                userRoleMapper.insert(id,4L);
                                logger.info("用户注册成功{}", user);
                                return new JsonResult(0, "处理成功", null);
                            } catch (Exception e) {
                                logger.info("注册失败" + e.getMessage(), e);
                                return new JsonResult(-1, "注册失败", null);
                            }
                        } else return new JsonResult(-1, "用户名已存在", null);
                    } else return new JsonResult(-1,"图片上传失败",null);
                } else return new JsonResult(-1, "验证码错误", null);
            } else return new JsonResult(-1, "验证码过期", null);
        }else return new JsonResult(-1, "手机号已被注册", null);
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
        } catch (ClientException e) {
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
        } catch (IOException e) {
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
        if (emailtest(user)) {
            if ((time - Long.valueOf(array[1])) < 1000 * 60 * 5) {
                if (array[0].equals(emailcode)) {
                    if (nametest(user)) {
                        try {
                            insert(user);
                            logger.info("用户注册成功{}", user);
                            return new JsonResult(0, "注册成功", null);
                        } catch (Exception e) {
                            logger.info("用户注册失败{}", user);
                            return new JsonResult(-1, "注册失败", null);
                        }
                    } else return new JsonResult(-1, "用户名已存在", null);
                } else return new JsonResult(-1, "验证码错误", null);
            } else return new JsonResult(-1, "验证码过期", null);
        }else return new JsonResult(-1,"邮箱已被注册",null);
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
        if (signcodeSession.equalsIgnoreCase(signcode)) {
            //验证用户名是否存在
            if (nametest(user)) {
                try {
                    insert(user);
                    return new JsonResult(0,"注册成功",null);
                } catch (Exception e) {
                    logger.error("异常"+e.getMessage(),e);
                    return new JsonResult(-1,"未知错误",null);
                }
            }
            //返回用户名错误
            return new JsonResult(-1, "用户名已存在", new Date());
        }
        //返回验证码错误信息
        return new JsonResult(-1, "验证码错误", new Date());
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
            if ((time - Long.valueOf(array[1])) < 1000 * 60 * 5) {
                if (array[0].equals(phonecode)) {
                   return new JsonResult(0,"登陆成功",null);
                } else return new JsonResult(-1, "验证码错误", null);
            } else return new JsonResult(-1, "验证码过期", null);
        }else return new JsonResult(-1, "手机号不存在", null);
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
        if (signcodeSession.equalsIgnoreCase(signcode)) {
            //取出发送验证码的时间戳
            String str = (String) httpSession.getAttribute("emailcode");
            String[] array = str.split("\\.");
            //获取系统当前时间戳
            Long time = System.currentTimeMillis();
            //比较两个时间戳,有效时间5分钟
            if (!emailtest(user)) {
                if ((time - Long.valueOf(array[1])) < 1000 * 60 * 5) {
                    if (array[0].equals(emailcode)) {
                        if (emailpdtest(user)) {
                            return new JsonResult(0, "登陆成功", null);
                        }return new JsonResult(-1, "密码错误", null);
                    }return new JsonResult(-1, "验证码错误", null);
                }return new JsonResult(-1, "验证码过期", null);
            }return new JsonResult(-1, "邮箱不存在", null);
        } return new JsonResult(-1, "图形验证码错误", null);
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
        if (signcodeSession.equalsIgnoreCase(signcode)) {
            User user1 = userMapper.selectbyname(user);
            //如果有这个用户
            if (user1 !=null) {
                //当前Subject
                Subject currentUser = SecurityUtils.getSubject();
                String password = Md5.passwordtest(user.getPassword(), user1.getSalt());
                ShiroToken shiroToken = new ShiroToken(user1.getName(), password);
                try {
                    shiroToken.setRememberMe(true);
                    currentUser.login(shiroToken);
                    logger.info("登陆成功");
                    return new JsonResult(0, "登陆成功", JSON.toJSONString(user1));
                } catch (AuthenticationException e) {//登录失败
                    logger.info("登陆失败" + e.getMessage(), e);
                    return new JsonResult(-1, "用户名或密码错误", null);
                }
            }return new JsonResult(-1,"用户名或密码错误",null);
        }
        //返回验证码错误信息
        return new JsonResult(-1, "验证码错误", new Date());
    }

    /**
     * 更新个人资料
     * @param user
     * @param httpServletRequest
     * @return
     */
    public JsonResult upadate(User user,HttpServletRequest httpServletRequest){
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) httpServletRequest;
        String fileName =  multipartHttpServletRequest.getFile("photo").getOriginalFilename();
        String[] filename = fileName.split("\\.");
        String fileName1 = user.getName()+"headimage"+System.currentTimeMillis()+"."+filename[filename.length-1];
        if (ossutils.uploadimage(multipartHttpServletRequest.getFile("photo"),user,fileName1)){
            return new JsonResult(0,"头像修改成功",null);
        }
        else return new JsonResult(-1,"图片上传失败",null);
    }

    /**
     * 登出
     */
    public void logout(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()){
            subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
            if (logger.isDebugEnabled()) {
                logger.debug("用户"+"退出登录");
            }
        }
    }

    /**
     * 个人资料
     * @param id
     * @param httpServletResponse
     * @param httpServletRequest
     */
    public void profile(Long id, HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest){
        User user = selectbyid(id);
        user.setImage(ossutils.getCutUrl(user.getImage()));
        httpServletRequest.setAttribute("user", user);
    }

    /**
     * 生成验证码
     * @param httpServletResponse
     * @param httpServletRequest
     * @throws ServletException
     * @throws IOException
     */
    public void service(HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest) throws ServletException, IOException{
        VerificationCode verificationCode = new VerificationCode();
        //获取验证码图片
        BufferedImage bufferedImage = verificationCode.getImage();
        //获取验证码内容
        String text = verificationCode.getText();
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证
        StringBuffer randomCode = new StringBuffer();
        randomCode.append(text);
        // 将验证码保存到Session中
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.setAttribute("signcode", randomCode.toString());
        System.out.println("session-signcode" + randomCode.toString());
        // 禁止图像缓存
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setHeader("Cache-Control", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        // 将图像输出到Servlet输出流中
        ImageIO.write(bufferedImage, "jpeg", servletOutputStream);
        servletOutputStream.flush();
        servletOutputStream.close();
    }


    /**
     * 根据id查找用户，通过自增id
     * @param id
     * @return
     */
    public User selectbyid(Long id){
        System.out.print("8082端口被调用\n");
        return userMapper.selectbyid(id);
    }

    /**
     * 根据用户登陆时的账户密码验证，需要放入map
     * @param map
     * @return
     */
    public User login(Map<String, Object> map){
        return userMapper.login( map);
    }

    /**
     * 用户注册的时候给其赋权限
     * @param uid
     * @param rid
     */
    public void insert(@Param("uid")Long uid, @Param("rid")Long rid){
         userRoleMapper.insert(uid,rid);
    }

    /**
     * 根据用户名拿到用户权限
     * @param username
     * @return
     */
    public  Set<Permission> findePerByUser(String username){
        return permissionMapper.findeByUser(username);
    }

    /**
     * 根据用户名获得角色
     * @param username
     * @return
     */
    public Set<Role> findeRoleByUser(String username){
        return roleMapper.findeByUser(username);
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
