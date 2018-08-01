package memcached;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pojo.Student;

import java.util.List;
import java.util.concurrent.TimeoutException;

@Component
public class StudentMemcached {
    Logger logger = Logger.getLogger("StudentMemcached.class");
    private int expTime = 3600;
    @Autowired
    private MemcachedClient memcachedClient;

//    //获取long型数据缓存
//    public Long getNum(String str) {
//        try {
//            return memcachedClient.get(str);
//        } catch (TimeoutException | InterruptedException | MemcachedException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    // 获取学生列表型数据缓存
//    public List<Student> getgood(String str) {
//        try {
//            List<Student> studentList = memcachedClient.get(str);
//            return studentList;
//        } catch (TimeoutException | InterruptedException | MemcachedException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    // 更新缓存
    public void setMem(String key, Object value) {
        try {
            memcachedClient.set(key, expTime, value);
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
    }
//
//    // 更新学生集合
//    public void setgood(String good, List<Student> students) {
//        try {
//            memcachedClient.set(good, expTime, students);
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (MemcachedException e) {
//            e.printStackTrace();
//        }
//    }

    public Object getObj(String s){
        try {
            return  memcachedClient.get(s);
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
return  null;
    }



    // 删除缓存
    public void deleteMem(String string) {
        try {
            memcachedClient.delete(string);
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
    }

}

