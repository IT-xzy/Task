//package jnshu.memcached;
//import jnshu.dao.AccountMapper;
//import jnshu.dao.StudentMapper;
//import jnshu.pojo.Account;
//import jnshu.util.DES;
//import net.rubyeye.xmemcached.MemcachedClient;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import redis.clients.jedis.Jedis;
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:application.xml")
//public class TestConnection {
//    @Autowired
//    @Qualifier("StudentDAOBean")
//    private StudentMapper studentMapper;
//
//    @Autowired
//    private AccountMapper accountMapper;
//
//    @SuppressWarnings("resource")
//    public static void main(String[] args) {
//        new ClassPathXmlApplicationContext("application.xml");
//
//        //设置key
//        boolean isSuccess = MemcacheUtil.set("修真院88", "abc");
//        System.out.println("是否成功：" + isSuccess);
//        Object obj = MemcacheUtil.get("修真院88");
//        System.out.println("获取name:" + obj);
//    }
//
//    @Test
//    public void saveSerialize(){
//        try {
//            boolean flag = MemcacheUtil.set("fakeData",SerializeUtil.serialize(studentMapper.findByStudentID(5)));
//            System.out.println("插入缓存::"+flag);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }
//
//    @Test
//    public void unSerialize(){
//        System.out.println(SerializeUtil.unserialize((byte[])MemcacheUtil.get("fakeData")));
//    }
//    @Test
//    public void test2(){
//        new ClassPathXmlApplicationContext("application.xml");
//
//        //设置key
//        try {
//            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xmemcached.xml");
//            MemcachedClient memcachedClient = (MemcachedClient)applicationContext.getBean("memcachedClient");
//            memcachedClient.set("123",3600,studentMapper.findByStudentID(5));
////            boolean isSuccess = MemcacheUtil.set("obj",sumMapper.findByStudentID(5),new Date());
////            System.out.println("是否成功：" + isSuccess);
//            Object obj = MemcacheUtil.get("123");
//            System.out.println("获取name:" + obj);
//        }catch (Exception w){
//            w.printStackTrace();
//        }
//
//    }
//
//    @Test
//    public void returnValue()throws Exception{
//        studentMapper.listStudent().forEach(System.out::println);
//    }
//
//    @Test
//    public void Redis()throws Exception{
//        //连接本地的 Redis 服务
//        Jedis jedis = new Jedis("localhost");
//        //        清空键值
////        System.out.println(jedis.flushDB());
////        System.out.println(jedis.flushAll());
////
////        //查看服务是否运行
////        System.out.println("服务正在运行: "+jedis.ping());
////        jedis.close();
////        System.out.println("服务正在运行: "+jedis.ping());
////        System.out.println(jedis.get("abc"));
////        jedis.lpush("site-list", "Runoob");
////        jedis.lpush("site-list", "Google");
////        jedis.lpush("site-list2", "Taobao");
////        System.out.println("取数组"+jedis.lrange("site-list",0,99999).size());
////        System.out.println("取所有key"+jedis.keys("*"));
////
////        System.out.println("是否存在键:"+(jedis.exists("site-list")?"存在":"不存在")+"\n");
////
////        System.out.println("查看键的剩余生存时间：" + jedis.ttl("site-list"));
////        System.out.println("移除键的生存时间：" + jedis.persist("site-list"));
////        System.out.println("查看键的剩余生存时间：" + jedis.ttl("site-list"));
////        System.out.println("查看键所存储的值的类型：" + jedis.type("site-list"));
////
////        System.out.println("\n新增键值对防止覆盖原先值:");
////        System.out.println(jedis.setnx("key001", "value001"));
////        System.out.println(jedis.setnx("key002", "value002"));
////        System.out.println(jedis.setnx("key002", "value002-new"));
////        System.out.println("获取键key001的值：" + jedis.get("key001"));
////        System.out.println("获取键key002的值：" + jedis.get("key002"));
////
////        System.out.println("\n新增键值对并设置有效时间:");
////        System.out.println(jedis.setex("key003", 2, "value003"));
////        System.out.println("获取键key003的值：" + jedis.get("key003"));
////        TimeUnit.SECONDS.sleep(3);
////        System.out.println("获取键key003的值：" + jedis.get("key003"));
////
////        System.out.println("获取原值，更新为新值:");
////        System.out.println(jedis.getSet("key002", "key2GetSet"));
////        System.out.println("获取键key002的值：" + jedis.get("key002"));
////
////        System.out.println("截取key002的值的字符串：" + jedis.getrange("key002", 2, 5));
//        List<String>list=null;
////        int i=0;
////        int j=2;
////        jedis.lrange("site-list",0,999).forEach((x)->  list.add(i,x));
////
////        list.forEach(System.out::println);
////        Account account = new Account(123,"account","password","false","jack","rose","boy","137")(p-> System.out.println(p));
//            list=jedis.lrange("site-list",0,999);
//        System.out.println(list.toString());
//
//    }
//
//    @Test
//    public void testRedisSer()throws Exception{
//        Jedis jedis = new Jedis("localhost");
////        jedis.set(SerializeUtil.serialize("ab"),SerializeUtil.serialize("131231231"));
////        System.out.println(jedis.lrange( SerializeUtil.serialize("ab"),0,99));
////        byte[]bytes=SerializeUtil.serialize("abc");
//
////        jedis.set(new String("def").getBytes(),SerializeUtil.serialize(new Student()));
////        byte[] bytes=jedis.get(new String("def").getBytes());
////        Student student = (Student) SerializeUtil.unserialize(bytes);
////        System.out.println(student.toString());
//        jedis.set("123","789");
//        jedis.setnx("123","666");//不存在的话才插入
//        jedis.setex("123",3,"999");//无论存在与否，都会把持久key更新或新增新的key，并且设定有效期
////        Thread.sleep(8);
//        TimeUnit.SECONDS.sleep(8);
//        System.out.println(jedis.exists(new String("123").getBytes()));
//
//    }
//
//    @Test
//    public void testDES()throws Exception{
//        byte[] bytes =DES.desEncodeCBC(DES.keyiv,new String("ABCDEFG//666b").getBytes());
//        for (byte b:bytes){
//            System.out.println((char) b);
//        }
//        Character character =null;
//        byte[]bytes1=DES.desDecodeCBC(DES.keyiv,bytes);
//        for (byte b:bytes1){
//            character= (char) b;
//            String c=(String) character.toString();
//            System.out.println((char) b);
//        }
//
//        System.out.println("aaa:"+character);
//
////        List<Account>list= accountMapper.listAccount();
//        String s = "d"+"/"+"v";
//        System.out.println(s);
//
//    }
//
//}
