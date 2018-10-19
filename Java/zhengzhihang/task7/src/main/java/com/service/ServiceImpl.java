package com.service;
import com.aliyuncs.exceptions.ClientException;
import com.dao.Mapper;
import com.pojo.OcT;
import com.pojo.Occupation;
import com.pojo.Trainees;
import com.tools.*;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ServiceImpl implements ServiceIF {
    @Resource
    private Mapper mp;

    @Resource
    private AliMessage aliMessage;

    @Resource
    private AliEmail aliEmail;

    @Resource
    private AliUploadFile aliUploadFile;

    //声明一个日志
    private static org.apache.log4j.Logger logger= org.apache.log4j.Logger.getLogger(ServiceIF.class);
    //设置分钟(我redis设置的timeout是单位是s)
    private final static long min=60;
    //设置小时
    private final static long hour=min*60;
    //设置天
    private final static long day=hour*24;
    //设置月
    private final static long mouth=day*30;
    //设置空缓存有效时间：3min
    private final static long temporary=min*3;
    //生成一个15到30天到随机数
    private long ranTime=(long)(15*day+Math.random()*(30*day-15*day+1));
    //设置一个值，判断数据库是否被修改
    private boolean b=false;


    @Override
    //累计在学人数统计
    public int accountStudents() {
        return mp.accountTrainees();
    }

    @Override
    //找到工作人数统计
    public int countOccupation() {
        return mp.countWork();
    }

    @Override
    //课程在学人数统计
    public int lessonAll(int number) {
        return mp.lessonCount(number);
    }

    @Override
    //获取优秀学员类
    public List<Trainees> niceStudents() {
        return mp.niceTrainees();
    }

    @Override
    //遍历所有职业对象并且输出
    public List<Occupation> queryAllOccupation() {
        return mp.queryAllCareers();
    }

    @Override
    //得到职业对象和在学人数的复合类
    public List<OcT> queryAllOccupationAndLesson() {
        List<OcT> ocTS=mp.queryAllCareersAndLesson();
        for (int i=0;i<ocTS.size();i++){
            ocTS.get(i).setCourseSum(mp.lessonCount(ocTS.get(i).getId()));
        }
        return ocTS;
    }
    //根据账号查询密码
    @Override
    public Trainees checkPwd(String account) {
        return mp.checkPwd(account);
    }


    @Override
    public String findAccountById(int id) {
        return mp.findAccountById(id);
    }

    @Override
    public Trainees findTraineesById(int id) {
        return mp.findTraineesById(id);
    }

    @Override
    public String findPicById(int id) {
        return mp.findPicById(id);
    }
    @Override
    public int updatePicById(String pic, int id) {
        return mp.updatePicById(pic,id);
    }
    @Override
    public String uploadPic(int id) {
        long time=System.currentTimeMillis();
        String picName=id+String.valueOf(time);
        mp.updatePicById(picName,id);
        return picName;
    }

    //注册学员
    @Override
    public int loginTrainees(Trainees trainees) {
        //查找该账号有没有被使用
        Trainees tr=mp.checkPwd(trainees.getAccount());
        if(tr==null){
            //账号没有被注册，进行注册，并且返回1；
            Trainees add=new Trainees();
            add.setAccount(trainees.getAccount());
            add.setPassword(trainees.getPassword());
            add.setSalt(trainees.getSalt());
            add.setPhoneNumber(trainees.getPhoneNumber());
            add.setEmail(trainees.getEmail());
            mp.loginTrainees(add);
            return 0;
        }else {
            //账号已经被注册，不进行注册，并且返回0；
            return 1;
        }
    }

    @Override
    //登录接口
    public int enterPage(Trainees trainees) {
        Trainees tr= mp.checkPwd(trainees.getAccount());
        if(tr!=null){
            if(trainees.getPassword().equals(tr.getPassword())){
                //如果输入密码和账号密码相等，返回0值；且保存这个信息到缓存
                RedisTool.rdSet(trainees.getAccount(),trainees,3*min);
                return 0;

            }else {
                //如果输入密码和账号密码不等，返回1值；
                return 1;
            }
        }else {
            //如果没有这个账号，返回值2；
            return 2;
        }
    }

    //通过账号更新密码
    @Override
    public int updatePwd(String password, String account) {
        //获取这个学员列表
        Trainees trainees=mp.checkPwd(account);
        //获取盐值
        String salt=trainees.getSalt();
        //对密码进行MD5加密
        String pwd=MD5Util.MD5(password+salt);
        return mp.updatePwd(pwd,account);
    }

    /**
     * 邮箱验证码
     * key （mail , securecore)  (s+mail ,times) (m+account, mail)
     * @param mail
     * @param account
     */
    @Override
    public void getMailCore(String mail,String account) {
        logger.info("com.server.ServiceImpl.getMailCore的入参是 ："+"mail = "+mail+" ;  account = "+account);
        //获取随机验证码
        String secureCore=CharaterUtils.getRandomString(6);
        logger.info("com.server.ServiceImpl.getMailCore的验证码是"+secureCore);
        //根据邮箱添加邮箱随机验证码到缓存
        RedisTool.rdSet(mail,secureCore,3*min);
        //根据账号，添加邮箱到缓存；
        RedisTool.rdSet("m"+account,mail,day);
        //发送验证码到邮箱
        if(RedisTool.rdGetKey("s"+mail)){
            //有这个key，不用创建
            if(!PRA.prevent_R_Attack(mail)){
                //如果没有超过有效次数，就发送验证
                aliEmail.sample(mail,secureCore);
                //发送完累加一次添加记录
                PRA.addKeyvalue(mail);
            }else {
                logger.info("超过请求的有效次数");
            }
        }else {
            //不存在这个key，创建这个key
            RedisTool.rdSet("s"+mail,0,day);
            aliEmail.sample(mail,secureCore);
        }
    }

    /**
     *短信验证码
     * @param phoneNumber
     * @param account
     *保存该验证码到缓存中用于验证
     *
     * key （phoneNumber , securecore)  (s+phoneNumber ,times) (p+account, phoneNumber)
     */
    @Override
    public void getMessageCore(String phoneNumber, String account) {
        logger.info("com.server.ServiceImpl..getMessageCore的入参是 ："+"phoneNumber = "+phoneNumber+"  ;account ="+account);
        //获取随机验证码
        String secureCore=CharaterUtils.getRandomString(6);
        //根据电话号码添加短信随机验证码到缓存
        RedisTool.rdSet(phoneNumber,secureCore,3+min);
        //根据账号，存电话号码到缓存
        RedisTool.rdSet("p"+account,phoneNumber,day);
        //发送验证码到手机
        try {
            if(RedisTool.rdGetKey("s"+phoneNumber)){
                //有key,不用设置key
                if(!PRA.prevent_R_Attack(phoneNumber)){
                    //如果没有超过有效次数，就发送验证
                    aliMessage.sendSms(phoneNumber,secureCore);
                    //累加一次发送短信的次数
                    PRA.addKeyvalue(phoneNumber);
                }else {
                    logger.info("短信请求超过有效次数");
                }

            }else {
                //为该电话号码添加防攻击
                RedisTool.rdSet("s"+phoneNumber,0,day);
                aliMessage.sendSms(phoneNumber,secureCore);
            }
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
