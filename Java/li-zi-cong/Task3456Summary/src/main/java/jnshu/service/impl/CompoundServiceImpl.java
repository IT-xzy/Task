package jnshu.service.impl;

import jnshu.util.MemcacheUtil;
import jnshu.util.SerializeUtil;
import jnshu.pojo.Job;
import jnshu.pojo.LoginAccount;
import jnshu.pojo.RegisterAccount;
import jnshu.pojo.Student;
import jnshu.service.CompoundService;


//import jnshu.util.MemcachedServicesUtil;
import jnshu.util.DES;
import jnshu.util.MD5;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompoundServiceImpl implements CompoundService {
    private  Logger logger = LogManager.getLogger(CompoundServiceImpl.class);

//    缓存逻辑需要的静态变量
    static boolean flag=true;
    static float index=0;
    static float count=0;
    static float wait=0;

    @Autowired
    private AccountServiceImpl accountService;

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private JobServiceImpl jobService;


//    @Autowired
//    @Qualifier("memcachedUtil")
//    MemcachedServicesUtil memcachedServicesUtil;

    private List<?> memcached(String key){
        try {
            if (MemcacheUtil.get(key)!=null) {
                index++;
                List<Object> object = SerializeUtil.unserializeList((byte[]) MemcacheUtil.get(key));
                System.out.println("@命中缓存,命中率:"+(int)(index/(wait+count+index)*100)+"%  命中数:"+(int)index+" ,总请求数:"+(int)(wait+count+index));
                return object;
            }
            else if (flag==true){
                flag=false;
                count++;
                List<Student>temp=studentService.listExcellent();
                System.out.println("！穿f透缓存,穿透率:"+(count/(wait+count+index)*100)+"%  穿透数:"+(int)count);
                if (temp!=null){
                    System.out.println("锁中:已从DB获得新值");
                    MemcacheUtil.set(key,SerializeUtil.serializeList(temp));
                    flag=true;
                    return SerializeUtil.unserializeList((byte[]) MemcacheUtil.get(key));
                }else if (temp==null) {
                    System.out.println("锁中:从DB未获得新值");
                    MemcacheUtil.set(key,SerializeUtil.serialize("false"));
                    return null;
                }
            }else if (flag==false){
                wait++;
                System.out.println("~未命中缓存, 未命中数:"+(int)(wait));
                Thread.sleep(500);
                return memcached(key);
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    private List<?>redis(String key)throws Exception{
        Jedis redis = new Jedis("localhost",6379);
        if (redis.exists(key.getBytes())){
            System.out.println("命中缓存");
            return SerializeUtil.unserializeList(redis.get(key.getBytes()));
        }else {
            if (flag==true){
                flag=false;
                List<Student>list=studentService.listExcellent();
                System.out.println("未命中缓存，开始穿透");
                if (list!=null){
                    System.out.println("DB获取到值，开始写入缓存并返回");
                    redis.set(key.getBytes(),SerializeUtil.serializeList(list));
                    flag=true;
                    return SerializeUtil.unserializeList(redis.get(key.getBytes()));
                }else {
                    System.out.println("DB未获取到值，不作处理");
                    redis.setex(key,3600,"NulL");
                    return null;
                }
            }else if (flag==false){
                System.out.println("等待线程数:"+(++wait));
                Thread.sleep(500);
                return redis(key);
            }
        }
        return null;
    }



    @Override
    public List<Student> homePage() throws Exception {
        int count = 0;

//        System.out.println("***********objtoString"+objects.toString());

//        无缓存
        List<Student>students=studentService.listExcellent();

//        memcached
//        List<Student>students=(List<Student>) memcached(("listExcellent"));

//        redis
//        List<Student>students=(List<Student>) redis("listStudent");

        if (students==null)
            return null;



//       统计优秀学员人数
//        for (Student student : students) {
//            if (student.getExcellent() == 1)
//                count++;
//        }
//        System.out.println("students.size:"+students.size());
//        System.out.println("count:"+count);


//        生成优秀学员总人数以内的不重复随机数，装进4位的数组里
//                    num[i] = (int) (Math.random() * count);
        int[] num = new int[4];
        for (int i = 0; i < 4; i++) {
            num[i] = (int) (Math.random() * students.size());
            for (int j = 0; j < num.length; j++) {
                if (num[i] == num[j] && i != j) {
                    num[i] = (int) (Math.random() * students.size());
                    j = -1;
                }
            }
        }

//        获取优秀学员集合(V2:重排集合)
//        List<Student> studentList = new ArrayList<>();
//        for (Student l : students) {
////            if (l.getExcellent() == 1)
//                studentList.add(l);
//        }

//        用不重复随机数组作为下标供优秀学员集合取值，然后封装进新的集合
        List<Student> studentList2 = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            studentList2.add(students.get(num[i]));
        }

//        Test
//        List<Student>list = sumMapper.listStudent();
//        System.out.println("IMPL：");
//        list.forEach(System.out::println);

        return studentList2;
    }

    @Override
    public List<Job> positionPageCon() throws Exception {
        return jobService.listJob();
    }

    @Override
    public void Register(RegisterAccount registerAccount) throws Exception {
//        生成密文
        List<String> list = MD5.getText(registerAccount.getPassword(),null);
        registerAccount.setSalt(list.get(0));
        registerAccount.setPassword(list.get(1));
        accountService.register(registerAccount);
    }

    @Override
    public Cookie checkLogin(LoginAccount loginAccount) throws Exception {
        RegisterAccount registerAccount = accountService.checkLogin(loginAccount);
        List<String> lists = MD5.getText(loginAccount.getPassword(), registerAccount);
        if (registerAccount.getPassword().equals(lists.get(1))) {
                System.out.println("验证成功，引导至首页");

                //加密
                byte[]bytes=DES.desEncodeCBC(DES.keyiv,new String(loginAccount.getAccount()+"/"+lists.get(0)).getBytes());
                Character character = null;
                String tokenString=null;
                System.out.println("byteSIZE"+bytes.length);
                for (byte b:bytes){
                    character=(char)b;
                    tokenString=character.toString();
                }
                Cookie token = new Cookie("token",tokenString);
                token.setMaxAge(3600*24*3);//设置其生命周期
                return token;
            }
            return null;
    }


}
