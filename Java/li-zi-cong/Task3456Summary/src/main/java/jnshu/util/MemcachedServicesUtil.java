//package jnshu.util;
//import jnshu.dao.StudentMapper;
//import jnshu.util.MemcacheUtil;
//import jnshu.util.SerializeUtil;
//import jnshu.pojo.Student;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service("memcachedUtil")
//public class MemcachedServicesUtil {
//
//    @Autowired
//    @Qualifier("StudentDAOBean")
//    private StudentMapper studentMapper;
//
//    static float index=0;
//    static float count=0;
//    static float wait=0;
//    static boolean flag=true;
//
//    private static Logger logger = LogManager.getLogger(MemcachedServicesUtil.class);
//
//    public static boolean saveUpdate(String key,Object object,List<?> ListObject){
//        try {
//            if (ListObject!=null){
//                MemcacheUtil.set(key,SerializeUtil.serializeList(ListObject));
//                return true;
//            }else {
//                MemcacheUtil.set(key,SerializeUtil.serialize(object));
//                return true;
//            }
//        }catch (Exception e){
//            logger.error(e.getMessage());
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    public static void delete(String key){
//        try {
//            MemcacheUtil.delete(key);
//        }catch (Exception e){
//            logger.error(e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//    public Object get(String key){
//        try {
//            if (MemcacheUtil.get(key)!=null) {
//                index++;
//                List<Object> object = SerializeUtil.unserializeList((byte[]) MemcacheUtil.get(key));
//                System.out.println("@命中缓存,命中率:"+(int)(index/(wait+count+index)*100)+"%  命中数:"+(int)index+" ,总请求数:"+(int)(wait+count+index));
//                return object;
//            }
//            else if (flag==true){
//                flag=false;
//                count++;
//                List<Student>temp=studentMapper.listStudent();
//                System.out.println("！穿透缓存,穿透率:"+(count/(wait+count+index)*100)+"%  穿透数:"+(int)count);
//                if (temp!=null){
//                    System.out.println("锁中:已从DB获得新值");
//                    MemcacheUtil.set(key,SerializeUtil.serializeList(temp));
//                    return  SerializeUtil.unserializeList((byte[]) MemcacheUtil.get(key));
//                }else if (temp==null) {
//                    System.out.println("锁中:从DB未获得新值");
//                    MemcacheUtil.set(key,SerializeUtil.serialize("false"));
//                    return null;
//                }
//            }else if (flag==false){
//                wait++;
//                System.out.println("~未命中缓存, 未命中数:"+(int)(wait));
//                Thread.sleep(500);
//                return get(key);
//            }
//        }catch (Exception e){
//            logger.error(e.getMessage());
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
