package com.jnshu.tools;

import com.jnshu.model.User;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class TestXMemcache {

    ApplicationContext build = new ClassPathXmlApplicationContext("xmemcache.xml");

    MemcachedClient memcachedClient = (MemcachedClient) build.getBean("memcachedClient");

    public void SaveMemcache(String Mname, User value) {
        try {
            memcachedClient.set(Mname, 3600, value);
            User v = memcachedClient.get(Mname);
            System.out.println("保存" + Mname + "=" + v.getName());
        } catch (MemcachedException e) {
            System.err.println("MemcachedClient operation fail");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.err.println("MemcachedClient operation timeout");
            e.printStackTrace();
        } catch (InterruptedException e) {
        }
    }

    public void SaveMemcache(String Mname,User value,int time) {
        try {
            memcachedClient.set(Mname, time,value);
        } catch (MemcachedException e) {
            System.err.println("MemcachedClient operation fail");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.err.println("MemcachedClient operation timeout");
            e.printStackTrace();
        } catch (InterruptedException e) {
        }
    }


    public void SaveMemcache(String Mname, List<String> value) {
        try {
            memcachedClient.set(Mname, 3600, value);
            List<String> v = memcachedClient.get(Mname);
            System.out.println("保存" + Mname + "=" + v.get(0));
        } catch (MemcachedException e) {
            System.err.println("MemcachedClient operation fail");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.err.println("MemcachedClient operation timeout");
            e.printStackTrace();
        } catch (InterruptedException e) {
        }
    }


    public void SaveMemcache(String Mname, Integer value) {
        try {
            memcachedClient.set(Mname, 1800, value);
            System.out.println("保存" + Mname + "=" + value);
        } catch (MemcachedException e) {
            System.err.println("MemcachedClient operation fail");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (TimeoutException e) {

            System.err.println("MemcachedClient operation timeout");
            e.printStackTrace();
        } catch (InterruptedException e) {
        }
    }

    public void DelMemcache(String Mname) {
        try {
            memcachedClient.delete(Mname);

            System.out.println("清除缓存" + Mname);
        } catch (MemcachedException e) {
            System.err.println("MemcachedClient operation fail");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.err.println("MemcachedClient operation timeout");
            e.printStackTrace();
        } catch (InterruptedException e) {
        }
    }

    public User GetMemcache(String Mname) {
        User value = null;
        try {
            value = memcachedClient.get(Mname);
        } catch (MemcachedException e) {
            System.err.println("MemcachedClient operation fail");
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.err.println("MemcachedClient operation timeout");
            e.printStackTrace();
        } catch (InterruptedException e) {
        }
        return value;
    }

    public MemcachedClient get(String Mname) throws InterruptedException, MemcachedException, TimeoutException {
        return  memcachedClient.get(Mname);
    }

    public Integer GetCountMemcache(String Mname) {
        Integer value = null;
        try {
            value = memcachedClient.get(Mname);
            if (value == 0) {
                return null;
            }
        } catch (MemcachedException e) {
            System.err.println("MemcachedClient operation fail");
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.err.println("MemcachedClient operation timeout");
            e.printStackTrace();
        } catch (InterruptedException e) {
        }
        return value;
    }

    public List<String> GetIdMemcache(String Mname) {
        List<String> value = null;
        try {
            value = memcachedClient.get(Mname);
            System.out.println("获取" + value.get(0));
        } catch (MemcachedException e) {
            System.err.println("MemcachedClient operation fail");
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.err.println("MemcachedClient operation timeout");
            e.printStackTrace();
        } catch (InterruptedException e) {
        }
        return value;
    }

    public List<User> list(List<String> key) {
        List<User> rt = new ArrayList<>();
        User t;
        if (key.size() == 0){
            return null;
        }
        for (String i : key) {
            try {
                System.out.println("key值" + i);
                t = memcachedClient.get(i);
                if (t == null) {
                    return null;
                }
                rt.add(t);
            } catch (TimeoutException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (MemcachedException e) {
                e.printStackTrace();
            }
        }
        return rt;
    }
}

