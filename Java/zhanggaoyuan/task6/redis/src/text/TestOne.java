import com.alibaba.fastjson.JSON;
import jnshu.model.ExcellentStudent;
import jnshu.model.Profession;
import jnshu.model.RestUser;
import jnshu.service.ProfessionService;
import jnshu.service.StudentService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)是指让测试运行于Spring测试环境
@RunWith(SpringJUnit4ClassRunner.class)
//Spring整合JUnit4测试时，使用注解@ContextConfiguration引入一个或多个配置文件
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class TestOne {

    private static Logger logger = Logger.getLogger(TestOne.class);
    @Autowired
    StudentService studentService;
    ExcellentStudent student=new ExcellentStudent ();
    RestUser restUser = new RestUser ();

//    @Autowired
//    ProfessionService professionService;
//    Profession profession=new Profession ();


    long timeStamp = System.currentTimeMillis();  //获取当前时间戳,也可以是你自已给的一个随机的或是别人给你的时间戳(一定是long型的数据)

    //    @Test
//    public void MD5Test(){
//    String password = "!ytd1129097428";
//    String md1 = MD5Util.MD5(password);
//    String md2 = MD5Util.generate(password);
//    System.out.println("加密前:"+password);
//    System.out.println("普通MD5加密后:"+md1);
//    System.out.println("加盐MD5加密后:"+md2);
//    System.out.println("比较原文和加盐MD5加密之后是否一致:"+MD5Util.verify(password,md2));
//    }

//    @Test
//    public void jwt() {
//        JWTTokenDto jwtTokenDto=new JWTTokenDto ();
//        jwtTokenDto.setUserName ("zhang");
//        jwtTokenDto.setUserId ("1");
//        String r = JWTTokenUtil.createJWT (jwtTokenDto);//加密后生成token
//        logger.info (r);
//
//
//        String j = JWTTokenUtil.parseJWT (r, jwtTokenDto).toString ();
//        logger.info (j);
//
//    logger.info (11111);
//        Boolean brt = JWTTokenUtil.isVerify (r, jwtTokenDto);
//        logger.info (brt);
//    }

//
//    @Test
//    public void insertUser() {
//        restUser.setName ("zhangsan");
//        restUser.setPwd ("1314");
//        restUser.setSalt ("weidao");
//        restUser.setEmail ("520@qq.com");
//       int rs= studentService.insertUser (restUser);
//        logger.info (rs);
//    }

    @Test
    public void select111() {
List list=studentService.selectInfo ();
logger.info (JSON.toJSONString (list));
    }



//
//
//    @Test
//    public void selectStudent(){
//        List rs=studentService.selectStudent ();
//        logger.info (JSON.toJSONString (rs));
//    }
//
//    @Test
//    public void insertProfession() {
//        for(int i=0;i<10;i++) {
//            profession.setImg ("t11/imges/687.png");
//            profession.setProfessionName ("Web前端工程师");
//            profession.setProfessionDescription ("Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。");
//            profession.setProfessionDetail ("iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。");
//            profession.setThreshold ("1");
//            profession.setDifficultyLevel ("2");
//            profession.setGrowthCycle ("1-3");
//            profession.setNeed ("345");
////            Map mp = new HashMap ();
////            mp.put (1, "5k-10k/月");
////            mp.put (2,"9k-15k/月" );
////            mp.put (3,"15k-50k/月" );
////            String st=JSON.toJSONString (mp);
////            logger.info (st);
////            profession.setSalary (st);
//            profession.setSalary ("5k-10k/月,9k-15k/月,15k-50k/月");
//            profession.setLearning ("1314");
//            profession.setHint ("提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础");
//            profession.setCreatTime (timeStamp);
//            profession.setUpdateTime (timeStamp);
//            int rs = professionService.insert (profession);
////            logger.info (rs);
//        }
//    }
//    @Test
//    public void selectProfession(){
////        List rs=professionService.selectProfession ();
////        logger.info (JSON.toJSONString (rs));
////        logger.info (timeStamp);
//
//        //long timeStamp = 1495777335060;//直接是时间戳
//        long timeStamp1 = System.currentTimeMillis();  //获取当前时间戳,也可以是你自已给的一个随机的或是别人给你的时间戳(一定是long型的数据)
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//这个是你要转成后的时间的格式
//        String sd = sdf.format(new Date (timeStamp1));   // 时间戳转换成时间
//        System.out.println(sd);//打印出你要的时间
//    }

}
